package com.ironhack.bankingsystem.controllers.impl;

import com.ironhack.bankingsystem.DTO.RoleToUserDTO;
import com.ironhack.bankingsystem.controllers.interfaces.RoleControllerInterface;
import com.ironhack.bankingsystem.models.Role;
import com.ironhack.bankingsystem.service.interfaces.RoleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RoleController implements RoleControllerInterface {
    @Autowired
    private RoleServiceInterface roleService;

    @PostMapping("/roles")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRole(@RequestBody Role role) {
        roleService.saveRole(role);
    }

    @PostMapping("/roles/addtouser")
    public void addRoleToUser(@RequestBody RoleToUserDTO roleToUserDTO) {
        roleService.addRoleToUser(roleToUserDTO.getUsername(),roleToUserDTO.getRoleName());
    }
}
