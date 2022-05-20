package com.ironhack.bankingsystem.controllers.impl;


import com.ironhack.bankingsystem.controllers.interfaces.AccountHolderControllerInterface;
import com.ironhack.bankingsystem.service.interfaces.AccountHolderServiceInterface;
import com.ironhack.bankingsystem.users.AccountHolder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accountholders")
public class AccountHolderController implements AccountHolderControllerInterface {

    @Autowired
    AccountHolderServiceInterface accountHolderServiceInterface;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountHolder getAccountHolders(@PathVariable Long id){
        return accountHolderServiceInterface.getAccountHolders(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder createAccountHolders(@RequestBody @Valid AccountHolder accountHolder){
        return accountHolderServiceInterface.saveAccountHolders(accountHolder);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAccountHolders(@PathVariable Long id, @RequestBody AccountHolder accountHolder){
        accountHolderServiceInterface.updateAccountHolders(id, accountHolder);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccountHolders(Long id) {
        accountHolderServiceInterface.deleteAccountHolders(id);
    }
}
