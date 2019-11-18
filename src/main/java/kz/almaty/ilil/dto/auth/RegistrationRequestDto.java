package kz.almaty.ilil.dto.auth;


import kz.almaty.ilil.entity.User;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class RegistrationRequestDto {
    private String username;
    private String email;
    private String password;

    public User toUser(){
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setEmail(this.email);
        return user;
    }
}
