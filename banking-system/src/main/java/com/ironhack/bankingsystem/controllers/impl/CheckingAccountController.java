package com.ironhack.bankingsystem.controllers.impl;


import com.ironhack.bankingsystem.DTO.CheckingAccountsDTO;
import com.ironhack.bankingsystem.DTO.TransferDTO;
import com.ironhack.bankingsystem.classes.Money;
import com.ironhack.bankingsystem.controllers.interfaces.CheckingAccountControllerInterface;
import com.ironhack.bankingsystem.models.Account;
import com.ironhack.bankingsystem.models.CheckingAccount;


import com.ironhack.bankingsystem.service.interfaces.CheckingAccountServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkingaccounts")
public class CheckingAccountController implements CheckingAccountControllerInterface {

    @Autowired
    CheckingAccountServiceInterface checkingAccountServiceInterface;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CheckingAccount getCheckingAccounts(@PathVariable Long id){
        return checkingAccountServiceInterface.getCheckingAccounts(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account createCheckingAccounts(@RequestBody @Valid CheckingAccountsDTO checkingAccounts){


        return checkingAccountServiceInterface.saveCheckingAccounts(checkingAccounts);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCheckingAccounts(@PathVariable Long id, @RequestBody CheckingAccount checkingAccount){
        checkingAccountServiceInterface.updateCheckingAccounts(id, checkingAccount);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCheckingAccounts(Long id) {
        checkingAccountServiceInterface.deleteCheckingAccounts(id);
    }

    @Override
    @PatchMapping("/{id}/transfer")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sendTransferAccount(@PathVariable (name = "id") Long senderAccountId, @RequestBody TransferDTO transferDTO){
        System.out.println(senderAccountId);
        checkingAccountServiceInterface.sendTransfer(senderAccountId,transferDTO);
    }

   /* @GetMapping("/checkingAccounts/balance/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getActualBalance(@PathVariable (name = "id") Long id){
        Money actualBalance = checkingAccountServiceInterface.getBalance(id);
        return (actualBalance);
    }*/
}
