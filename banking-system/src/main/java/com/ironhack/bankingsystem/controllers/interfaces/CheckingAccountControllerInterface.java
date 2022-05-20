package com.ironhack.bankingsystem.controllers.interfaces;

import com.ironhack.bankingsystem.DTO.CheckingAccountsDTO;
import com.ironhack.bankingsystem.models.Account;
import com.ironhack.bankingsystem.models.CheckingAccount;

public interface CheckingAccountControllerInterface {
    CheckingAccount getCheckingAccounts(Long id);
    public Account createCheckingAccounts(CheckingAccountsDTO checkingAccounts);
    void updateCheckingAccounts(Long id, CheckingAccount checkingAccount);
    void deleteCheckingAccounts(Long id);
}
