package kz.almaty.ilil.rest;

import kz.almaty.ilil.dto.auth.AuthenticationRequestDto;
import kz.almaty.ilil.dto.auth.AuthenticationResponseDto;
import kz.almaty.ilil.dto.auth.RegistrationRequestDto;
import kz.almaty.ilil.dto.UserDto;
import kz.almaty.ilil.entity.User;
import kz.almaty.ilil.security.JwtTokenFilter;
import kz.almaty.ilil.security.JwtTokenProvider;
import kz.almaty.ilil.security.JwtUserDetailsService;
import kz.almaty.ilil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/auth/")
public class AuthenticationRestControllerV1 {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody AuthenticationRequestDto requestDto){
        String username = requestDto.getUsername();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,requestDto.getPassword()));
        }catch (AuthenticationException e){
            throw new BadCredentialsException("Invalid username or password");
            /*Map<Object, Object> response = new HashMap<>();
            response.put("errorMsg",e.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(response);*/
        }

        /*User user = jwtUserDetailsService.findByUsername(username);

        if(user == null)
            throw new UsernameNotFoundException("User with username: " + username + "not found");

        String token = jwtTokenProvider.createToken(username,user.getRoles());

        Map<Object, Object> response = new HashMap<>();
        response.put("username",username);
        response.put("token",token);
        response.put("user", UserDto.fromUser(user));

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Set-Token",token);

        return ResponseEntity
                .ok().headers(responseHeaders).body(response);*/

        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(requestDto.getUsername());

        final String jwt = jwtTokenProvider.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponseDto(jwt));

    }

    /*@RequestMapping(value = "user",method = RequestMethod.POST)
    public ResponseEntity getUser(@RequestHeader("Set-Token") String token) {

        String username = jwtTokenProvider.getUsername(token);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Baeldung-Example-Header",
                "Value-ResponseEntityBuilderWithHttpHeaders");
        responseHeaders.set("Set-Token",token);

        User user = userService.findByUsername(username);

        return ResponseEntity.ok().headers(responseHeaders).body(UserDto.fromUser(user));
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public ResponseEntity registerUser(@RequestBody RegistrationRequestDto userDto){
        User registeredUser = null;
        String msg = "Заригистрирован пользователь с номером : " + userDto.getUsername();
        try{
            registeredUser = userService.register(userDto.toUser());
            if(registeredUser==null){
                msg = "Ошибка. Пользователь не заригестрирован";
            }
        }catch (Exception e){
            msg="Ошибка. Пользователь не заригестрирован : "+e.toString();
        }
        Map<Object, Object> response = new HashMap<>();
        response.put("msg",msg);

        return ResponseEntity
                .ok().body(response);
    }*/


}
