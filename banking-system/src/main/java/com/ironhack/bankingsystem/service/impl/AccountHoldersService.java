package com.ironhack.bankingsystem.service.impl;

import com.ironhack.bankingsystem.models.Role;
import com.ironhack.bankingsystem.repositories.AccountHoldersRepository;
import com.ironhack.bankingsystem.service.interfaces.AccountHoldersServiceInterface;
import com.ironhack.bankingsystem.users.AccountHolders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class AccountHoldersService implements AccountHoldersServiceInterface {

    @Autowired
    AccountHoldersRepository accountHoldersRepository;

    public AccountHolders getAccountHolders(Long id){
        /*log.info("Fetching an account holder");*/
        return accountHoldersRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account holder not found"));
    }
    public AccountHolders saveAccountHolders(AccountHolders accountHolders) {
        try {
            return accountHoldersRepository.save(new AccountHolders(
                    accountHolders.getName(),
                    accountHolders.getUsername(),
                    accountHolders.getPassword(),
                    accountHolders.getDateOfBirth(),
                    accountHolders.getPrimaryAddress(),
                    accountHolders.getMailingAddress()
            ));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No account found");
        }
    }

    public void updateAccountHolders(Long id, AccountHolders accountHolders){
        AccountHolders accountHoldersFromDb = accountHoldersRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The account holder is not found in the database"));
        accountHolders.setId(accountHoldersFromDb.getId());
        accountHoldersRepository.save(accountHolders);
    }
    public void deleteAccountHolders(Long id){
        accountHoldersRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account holder not found"));
        accountHoldersRepository.deleteById(id);

    }
}
