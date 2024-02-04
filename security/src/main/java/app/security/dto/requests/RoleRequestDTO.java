package app.security.dto.requests;



import app.security.domain.Authority;
import app.security.domain.Role;

import java.util.List;

public record RoleRequestDTO(
         String name,
         List<Authority> authorities,
         boolean isDefault
){
    public Role toRole(){
        return Role.builder()
                .name(name)
                .isDefault(isDefault)
                .authorities(authorities)
                .build();
    }
}
