package com.ironhack.bankingsystem.service.interfaces;

import com.ironhack.bankingsystem.users.AccountHolders;

public interface AccountHoldersServiceInterface {

    AccountHolders getAccountHolders(Long id);
    public AccountHolders saveAccountHolders(AccountHolders accountHolders);

    void updateAccountHolders(Long id, AccountHolders accountHolders);
    void deleteAccountHolders(Long id);
}
