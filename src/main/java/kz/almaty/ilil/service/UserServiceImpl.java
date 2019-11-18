package kz.almaty.ilil.service;

import kz.almaty.ilil.entity.Role;
import kz.almaty.ilil.entity.Status;
import kz.almaty.ilil.entity.User;
import kz.almaty.ilil.repository.RoleRepository;
import kz.almaty.ilil.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    /*
     * Регистрация пользователя
     */
    @Override
    public User register(User user) {
        /*
         *Присвоение роли пользователя
         */
        Role roleUser = roleRepository.findByName("ROLE_USER");
        /*if email exist return error*/
        if(existEmail(user.getEmail())){
            return null;
        }
        List<Role> userRoles = new ArrayList<>();
        user.setUsername(user.getEmail());
        userRoles.add(roleUser);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);

        user.setStatus(Status.ACTIVE);
        user.setCreated(new Date());
        user.setUpdated(new Date());

        User registeredUser = userRepository.save(user);

        log.info("IN register - user {} successfuly registered",registeredUser);

        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRepository.findAll();
        log.info("IN getAll - {} users found ", result.size());

        return result;
    }

    @Override
    public User findByUsername(String username) {
        User result = userRepository.findByUsername(username);
        log.info("IN findByUsername - user:{} found by username: {}",result,username);
        return result;
    }

    @Override
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);
        if(result==null){
            log.warn("IN findById - no user found by id: {}",id);
        }

        log.info("IN findById - user: {} found by id:{}",result,id);

        return result;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("IN delete - user with id: {} successfully delete",id);
    }

    public boolean existEmail(String email){

        if(userRepository.findByUsername(email)!=null){
            return true;
        }

        return false;
    }
}
