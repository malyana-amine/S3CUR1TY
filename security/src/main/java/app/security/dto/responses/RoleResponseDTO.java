package app.security.dto.responses;



import app.security.domain.Authority;
import app.security.domain.Role;
import app.security.domain.enums.AuthorityEnum;

import java.util.List;

public record RoleResponseDTO(
        String name,
        List<AuthorityEnum> authorities,
        boolean isDefault
) {
    public static RoleResponseDTO fromRole(Role role){
        return new RoleResponseDTO(
                role.getName(),
                role.getAuthorities().stream().map(Authority::getName).toList(),
                role.isDefault()
        );
    }
}
