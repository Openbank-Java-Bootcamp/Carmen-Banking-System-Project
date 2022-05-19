package com.ironhack.bankingsystem.service.interfaces;

import com.ironhack.bankingsystem.DTO.CheckingAccountsDTO;
import com.ironhack.bankingsystem.models.CheckingAccounts;



public interface CheckingAccountsServiceInterface {
    CheckingAccounts getCheckingAccounts(Long id);
    public CheckingAccounts saveCheckingAccounts(CheckingAccountsDTO checkingAccounts);

    void updateCheckingAccounts(Long id, CheckingAccounts checkingAccounts);
    void deleteCheckingAccounts(Long id);
}
