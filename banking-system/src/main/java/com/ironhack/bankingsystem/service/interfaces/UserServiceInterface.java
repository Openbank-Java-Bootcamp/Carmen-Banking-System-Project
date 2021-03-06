package com.ironhack.bankingsystem.service.interfaces;

import com.ironhack.bankingsystem.models.Role;
import com.ironhack.bankingsystem.users.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    Optional<User> getUser(String username);
    List<User> getUsers();
}
