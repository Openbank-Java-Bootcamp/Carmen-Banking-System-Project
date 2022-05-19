package com.ironhack.bankingsystem.service.impl;

import com.ironhack.bankingsystem.DTO.CheckingAccountsDTO;
import com.ironhack.bankingsystem.models.CheckingAccounts;

import com.ironhack.bankingsystem.models.StudentChecking;
import com.ironhack.bankingsystem.repositories.AccountHoldersRepository;
import com.ironhack.bankingsystem.repositories.CheckingAccountsRepository;
import com.ironhack.bankingsystem.repositories.StudentCheckingRepository;
import com.ironhack.bankingsystem.repositories.UserRepository;
import com.ironhack.bankingsystem.service.interfaces.CheckingAccountsServiceInterface;

import com.ironhack.bankingsystem.users.AccountHolders;
import com.ironhack.bankingsystem.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class CheckingAccountsService implements CheckingAccountsServiceInterface {
    @Autowired
    CheckingAccountsRepository checkingAccountsRepository;

    @Autowired
    AccountHoldersRepository accountHoldersRepository;
    @Autowired
    StudentCheckingRepository studentCheckingRepository;

    public CheckingAccounts getCheckingAccounts(Long id){
        return checkingAccountsRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Checking account not found"));
    }
    public CheckingAccounts saveCheckingAccounts(CheckingAccountsDTO checkingAccounts) {
        try {
            AccountHolders primaryOwner = accountHoldersRepository.findById(checkingAccounts.primaryOwner).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Primary owner not found"));
           LocalDate today =  LocalDate.now();
           Date primaryOwnerDate = primaryOwner.getDateOfBirth();
           LocalDate pastDate = LocalDate.from(Instant.ofEpochMilli(primaryOwnerDate.getTime())
                   .atZone(ZoneId.systemDefault())
                   .toLocalDateTime());
                   int compareValue = today.compareTo(pastDate);
           System.out.println(compareValue);
            if (compareValue > 24) {
                return checkingAccountsRepository.save(new CheckingAccounts(
                        checkingAccounts.getBalance(),
                        primaryOwner,
                        checkingAccounts.getSecondaryOwner(),
                        checkingAccounts.getPenaltyFee(),
                        checkingAccounts.getCreationDate(),
                        checkingAccounts.getStatus(),
                        checkingAccounts.getSecretKey(),
                        checkingAccounts.getMinBalance(),
                        checkingAccounts.getMonthlyMaintenanceFee()
                ));
            }else{
                /*StudentChecking studentChecking = studentCheckingRepository.findById(studentChecking)*/
                return studentCheckingRepository.save(new StudentChecking(
                        checkingAccounts.getBalance(),
                        primaryOwner,
                        checkingAccounts.getSecondaryOwner(),
                        checkingAccounts.getPenaltyFee(),
                        checkingAccounts.getCreationDate(),
                        checkingAccounts.getStatus(),
                        checkingAccounts.getSecretKey(),
                        checkingAccounts.getMinBalance(),
                        checkingAccounts.getInterestRate()
                ));
            }
        } catch (Exception e){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString());

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