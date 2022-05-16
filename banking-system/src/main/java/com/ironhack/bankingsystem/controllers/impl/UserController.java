package com.ironhack.bankingsystem.controllers.impl;

import com.ironhack.bankingsystem.controllers.interfaces.UserControllerInterface;
import com.ironhack.bankingsystem.service.interfaces.AdminServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController implements UserControllerInterface {


    @Autowired
    private AdminServiceInterface userService;

   /* @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }*/



}
