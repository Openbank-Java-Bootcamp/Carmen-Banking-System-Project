package com.ironhack.bankingsystem.service.impl;

import com.ironhack.bankingsystem.models.CheckingAccounts;

import com.ironhack.bankingsystem.repositories.CheckingAccountsRepository;
import com.ironhack.bankingsystem.service.interfaces.CheckingAccountsServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CheckingAccountsService implements CheckingAccountsServiceInterface {
    @Autowired
    CheckingAccountsRepository checkingAccountsRepository;

    public CheckingAccounts getCheckingAccounts(Long id){
        return checkingAccountsRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Checking account not found"));
    }
    public CheckingAccounts saveCheckingAccounts(CheckingAccounts checkingAccounts) {
        try {
            return checkingAccountsRepository.save(new CheckingAccounts(
                    checkingAccounts.getBalance(),
                    checkingAccounts.getPrimaryOwner(),
                    checkingAccounts.getSecondaryOwner(),
                    checkingAccounts.getPenaltyFee(),
                    checkingAccounts.getCreationDate(),
                    checkingAccounts.getStatus(),
                    checkingAccounts.getSecretKey(),
                    checkingAccounts.getMinBalance(),
                    checkingAccounts.getMonthlyMaintenanceFee()
            ));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No account found");

        }
    }
    public void updateCheckingAccounts(Long id, CheckingAccounts checkingAccounts){
        CheckingAccounts checkingAccountsFromDb = checkingAccountsRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The checking account is not found"));
        checkingAccounts.setId(checkingAccountsFromDb.getId());
        checkingAccountsRepository.save(checkingAccounts);
    }
    public void deleteCheckingAccounts(Long id){
        checkingAccountsRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Checking account not found"));
        checkingAccountsRepository.deleteById(id);

    }
}

