package com.ironhack.bankingsystem.controllers.interfaces;


import com.ironhack.bankingsystem.DTO.RoleToUserDTO;
import com.ironhack.bankingsystem.models.Role;


public interface RoleControllerInterface {

    void saveRole(Role role);
    void addRoleToUser(RoleToUserDTO roleToUserDTO);
}
