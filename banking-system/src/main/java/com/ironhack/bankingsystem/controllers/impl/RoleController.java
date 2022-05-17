package com.ironhack.bankingsystem.controllers.impl;

import com.ironhack.bankingsystem.DTO.RoleToUserDTO;
import com.ironhack.bankingsystem.controllers.interfaces.RoleControllerInterface;
import com.ironhack.bankingsystem.models.Role;

import com.ironhack.bankingsystem.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RoleController implements RoleControllerInterface {

    @Autowired
    private UserServiceInterface userService;

    @PostMapping("/roles")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRole(@RequestBody Role role) {
        userService.saveRole(role);
    }

    @PostMapping("/roles/addtouser")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addRoleToUser(@RequestBody RoleToUserDTO roleToUserDTO) {
        userService.addRoleToUser(roleToUserDTO.getUsername(), roleToUserDTO.getRoleName());
    }


}
