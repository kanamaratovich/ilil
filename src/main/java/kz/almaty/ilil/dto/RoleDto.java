package kz.almaty.ilil.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kz.almaty.ilil.entity.Role;
import lombok.Data;
import lombok.ToString;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class RoleDto {
    private Long id;
    private String name;

    public static RoleDto fromRole(Role role){
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setName(role.getName());
        return roleDto;
    }

    public Role toRole(){
        Role role = new Role();
        role.setName(this.name);
        role.setId(this.id);
        return role;
    }
}
