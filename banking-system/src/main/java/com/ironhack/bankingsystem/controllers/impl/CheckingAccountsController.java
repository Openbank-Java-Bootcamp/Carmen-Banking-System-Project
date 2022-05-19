package com.ironhack.bankingsystem.controllers.impl;


import com.ironhack.bankingsystem.DTO.CheckingAccountsDTO;
import com.ironhack.bankingsystem.controllers.interfaces.CheckingAccountsControllerInterface;
import com.ironhack.bankingsystem.models.CheckingAccounts;


import com.ironhack.bankingsystem.service.interfaces.CheckingAccountsServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkingaccounts")
public class CheckingAccountsController implements CheckingAccountsControllerInterface {

    @Autowired
    CheckingAccountsServiceInterface checkingAccountsServiceInterface;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CheckingAccounts getCheckingAccounts(@PathVariable Long id){
        return checkingAccountsServiceInterface.getCheckingAccounts(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CheckingAccounts createCheckingAccounts(@RequestBody @Valid CheckingAccountsDTO checkingAccounts){


        return checkingAccountsServiceInterface.saveCheckingAccounts(checkingAccounts);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCheckingAccounts(@PathVariable Long id, @RequestBody CheckingAccounts checkingAccounts){
        checkingAccountsServiceInterface.updateCheckingAccounts(id, checkingAccounts);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCheckingAccounts(Long id) {
        checkingAccountsServiceInterface.deleteCheckingAccounts(id);
    }

}
