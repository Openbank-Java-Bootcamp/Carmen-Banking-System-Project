package com.ironhack.bankingsystem.controllers.interfaces;



import com.ironhack.bankingsystem.users.User;

import java.util.List;

public interface UserControllerInterface {
    List<User> getUsers();
    User saveUser(User user);
}
