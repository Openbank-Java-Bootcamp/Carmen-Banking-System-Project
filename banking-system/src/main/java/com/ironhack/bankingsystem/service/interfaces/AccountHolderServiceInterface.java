package com.ironhack.bankingsystem.service.interfaces;

import com.ironhack.bankingsystem.users.AccountHolder;

public interface AccountHolderServiceInterface {

    AccountHolder getAccountHolders(Long id);
    public AccountHolder saveAccountHolders(AccountHolder accountHolder);

    void updateAccountHolders(Long id, AccountHolder accountHolder);
    void deleteAccountHolders(Long id);
}
