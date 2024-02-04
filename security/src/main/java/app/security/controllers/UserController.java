package app.security.controllers;


import app.security.domain.Role;


import app.security.domain.User;
import app.security.dto.requests.RoleRequestDTO;
import app.security.dto.responses.UserResponseDTO;
import app.security.services.RoleService;
import app.security.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @PutMapping("/assign_role/{id}")
    public ResponseEntity<UserResponseDTO> assignRole(@RequestBody RoleRequestDTO request, @PathVariable Long id){
        Role role = roleService.getByName(request.name()).orElse(null);
        User user = userService.assignRole(id, role);
        if (user == null && role == null) return ResponseEntity.badRequest().build();
        else return new ResponseEntity<>(UserResponseDTO.fromUser(user), HttpStatus.OK);
    }

}
