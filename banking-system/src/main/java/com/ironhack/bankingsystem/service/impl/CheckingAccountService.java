package com.ironhack.bankingsystem.service.impl;

import com.ironhack.bankingsystem.DTO.CheckingAccountsDTO;
import com.ironhack.bankingsystem.DTO.TransferDTO;
import com.ironhack.bankingsystem.classes.Money;
import com.ironhack.bankingsystem.models.Account;
import com.ironhack.bankingsystem.models.CheckingAccount;

import com.ironhack.bankingsystem.models.StudentChecking;
import com.ironhack.bankingsystem.repositories.AccountHolderRepository;
import com.ironhack.bankingsystem.repositories.CheckingAccountRepository;
import com.ironhack.bankingsystem.repositories.StudentCheckingRepository;
import com.ironhack.bankingsystem.service.interfaces.CheckingAccountServiceInterface;

import com.ironhack.bankingsystem.users.AccountHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
public class CheckingAccountService implements CheckingAccountServiceInterface {
    @Autowired
    CheckingAccountRepository checkingAccountRepository;

    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    StudentCheckingRepository studentCheckingRepository;

    public CheckingAccount getCheckingAccounts(Long id){
        return checkingAccountRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Checking account not found"));
    }
    public Account saveCheckingAccounts(CheckingAccountsDTO checkingAccounts) {
        try {
            AccountHolder primaryOwner = accountHolderRepository.findById(checkingAccounts.primaryOwner).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Primary owner not found"));
           LocalDate today =  LocalDate.now();
           Date primaryOwnerDate = primaryOwner.getDateOfBirth();
           LocalDate pastDate = LocalDate.from(Instant.ofEpochMilli(primaryOwnerDate.getTime())
                   .atZone(ZoneId.systemDefault())
                   .toLocalDateTime());
                   int compareValue = today.compareTo(pastDate);
           System.out.println(compareValue);
            if (compareValue > 24) {
                return checkingAccountRepository.save(new CheckingAccount(
                        checkingAccounts.getBalance(),
                        primaryOwner,
                        checkingAccounts.getSecondaryOwner(),
                        checkingAccounts.getPenaltyFee(),
                        checkingAccounts.getCreationDate(),
                        checkingAccounts.getStatus(),
                        checkingAccounts.getSecretKey()
                ));
            }else{
                return studentCheckingRepository.save(new StudentChecking(
                        checkingAccounts.getBalance(),
                        primaryOwner,
                        checkingAccounts.getSecondaryOwner(),
                        checkingAccounts.getPenaltyFee(),
                        checkingAccounts.getCreationDate(),
                        checkingAccounts.getStatus(),
                        checkingAccounts.getSecretKey(),
                        checkingAccounts.getMinBalance()
                ));
            }
        } catch (Exception e){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.toString());
        }
    }
    public void updateCheckingAccounts(Long id, CheckingAccount checkingAccount){
        CheckingAccount checkingAccountFromDb = checkingAccountRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The checking account is not found"));
        checkingAccount.setId(checkingAccountFromDb.getId());
        checkingAccountRepository.save(checkingAccount);
    }
    public void deleteCheckingAccounts(Long id){
        checkingAccountRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Checking account not found"));
        checkingAccountRepository.deleteById(id);

    }
    public void sendTransfer(Long senderAccountId, TransferDTO transferDTO) {
        String usernameSender;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            usernameSender = ((UserDetails) principal).getUsername();
        } else {
            usernameSender = principal.toString();
        }
        String primaryOwnerName = checkingAccountRepository.findById(senderAccountId).get().getPrimaryOwner().getUsername();
        String secondaryOwnerName = null;
        if (checkingAccountRepository.findById(senderAccountId).get().getSecondaryOwner() != null) {
            secondaryOwnerName = checkingAccountRepository.findById(senderAccountId).get().getSecondaryOwner().getUsername();
        }
        if (primaryOwnerName.equals(usernameSender) || (secondaryOwnerName != null && secondaryOwnerName.equals(usernameSender))) {
            checkingAccountRepository.findById(senderAccountId).get().receiveTransfer(transferDTO.getTransferAmount());
            checkingAccountRepository.findById(transferDTO.getRecipientAccountId()).get().sendTransfer(transferDTO.getTransferAmount());

            checkingAccountRepository.save(checkingAccountRepository.findById(senderAccountId).get());
            checkingAccountRepository.save(checkingAccountRepository.findById(transferDTO.getRecipientAccountId()).get());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No authorization");
        }
    }
 /*   public Money getBalance(Long id){
        Optional<CheckingAccount> checkingAccountFromDb = checkingAccountRepository.findById(id);
        if(checkingAccountFromDb.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Checking Account found with ID:"+ id);
        }else{
            checkingAccountFromDb.get().deductMonthlyMaintenanceFee();
            checkingAccountRepository.save(checkingAccountFromDb.get());
            return checkingAccountFromDb.get().getBalance();
        }
    }*/
}