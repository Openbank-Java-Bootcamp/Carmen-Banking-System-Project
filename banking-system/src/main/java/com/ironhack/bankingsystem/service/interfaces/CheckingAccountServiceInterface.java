package com.ironhack.bankingsystem.service.interfaces;

import com.ironhack.bankingsystem.DTO.CheckingAccountsDTO;
import com.ironhack.bankingsystem.models.Account;
import com.ironhack.bankingsystem.models.CheckingAccount;



public interface CheckingAccountServiceInterface {
    CheckingAccount getCheckingAccounts(Long id);
    public Account saveCheckingAccounts(CheckingAccountsDTO checkingAccounts);

    void updateCheckingAccounts(Long id, CheckingAccount checkingAccount);
    void deleteCheckingAccounts(Long id);
}
