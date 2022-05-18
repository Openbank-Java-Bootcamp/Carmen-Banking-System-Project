package com.ironhack.bankingsystem.controllers.impl;


import com.ironhack.bankingsystem.controllers.interfaces.AccountHoldersControllerInterface;
import com.ironhack.bankingsystem.service.interfaces.AccountHoldersServiceInterface;
import com.ironhack.bankingsystem.users.AccountHolders;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accountholders")
public class AccountHolderController implements AccountHoldersControllerInterface{

    @Autowired
    AccountHoldersServiceInterface accountHoldersServiceInterface;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountHolders getAccountHolders(@PathVariable Long id){
        return accountHoldersServiceInterface.getAccountHolders(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolders createAccountHolders(@RequestBody @Valid AccountHolders accountHolders){
        return accountHoldersServiceInterface.saveAccountHolders(accountHolders);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAccountHolders(@PathVariable Long id, @RequestBody AccountHolders accountHolders){
        accountHoldersServiceInterface.updateAccountHolders(id, accountHolders);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccountHolders(Long id) {
        accountHoldersServiceInterface.deleteAccountHolders(id);
    }
}
