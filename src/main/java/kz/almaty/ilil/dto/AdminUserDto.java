package kz.almaty.ilil.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kz.almaty.ilil.entity.Status;
import kz.almaty.ilil.entity.User;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String status;
    private List<RoleDto> userRoles;

    public User toUser(){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setStatus(Status.valueOf(status));
        user.setRoles(userRoles.stream().map(roleDto -> roleDto.toRole()).collect(Collectors.toList()));
        return user;
    }

    public static AdminUserDto fromUser(User user) {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setId(user.getId());
        adminUserDto.setUsername(user.getUsername());
        adminUserDto.setFirstName(user.getFirstName());
        adminUserDto.setLastName(user.getLastName());
        adminUserDto.setEmail(user.getEmail());
        adminUserDto.setStatus(user.getStatus().name());
        adminUserDto.setUserRoles(user.getRoles().stream().map(role -> RoleDto.fromRole(role)).collect(Collectors.toList()));
        return adminUserDto;
    }
}

