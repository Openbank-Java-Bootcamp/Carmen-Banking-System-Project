package com.ironhack.bankingsystem.service.interfaces;


import com.ironhack.bankingsystem.models.Role;


public interface RoleServiceInterface {
    Role saveRole(Role role);
    void addRoleToUser(String userName, String roleName);

}
