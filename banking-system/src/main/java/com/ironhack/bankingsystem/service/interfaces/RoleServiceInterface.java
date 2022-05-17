package com.ironhack.bankingsystem.service.interfaces;


import com.ironhack.bankingsystem.models.Role;


public interface RoleServiceInterface {
    Role saveRole(Role role);
    void addRoleToAdmin(String userName, String roleName);

}
