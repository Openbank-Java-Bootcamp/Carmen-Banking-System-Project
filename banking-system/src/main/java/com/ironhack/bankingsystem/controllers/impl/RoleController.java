package com.ironhack.bankingsystem.controllers.impl;

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

    @PostMapping("/roles/addtoadmin")
    public void addRoleToAdmin(@RequestBody RoleToAdminDTO roleToAdminDTO) {
        roleService.addRoleToAdmin(roleToAdminDTO.getUsername(), roleToAdminDTO.getRoleName());
    }
}
