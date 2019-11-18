package kz.almaty.ilil.dto.auth;


import lombok.Data;

@Data
public class AuthenticationRequestDto {
    private String username;
    private String password;
}
