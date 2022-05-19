package com.ironhack.bankingsystem.controllers.interfaces;

import com.ironhack.bankingsystem.DTO.CheckingAccountsDTO;
import com.ironhack.bankingsystem.models.CheckingAccounts;
import com.ironhack.bankingsystem.users.AccountHolders;

public interface CheckingAccountsControllerInterface {
    CheckingAccounts getCheckingAccounts(Long id);
    public CheckingAccounts createCheckingAccounts(CheckingAccountsDTO checkingAccounts);
    void updateCheckingAccounts(Long id, CheckingAccounts checkingAccounts);
    void deleteCheckingAccounts(Long id);
}
