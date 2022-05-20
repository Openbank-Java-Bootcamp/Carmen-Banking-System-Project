package com.ironhack.bankingsystem.controllers.interfaces;

import com.ironhack.bankingsystem.users.AccountHolder;

public interface AccountHolderControllerInterface {
    AccountHolder getAccountHolders(Long id);
    public AccountHolder createAccountHolders(AccountHolder accountHolder);
    void updateAccountHolders(Long id, AccountHolder accountHolder);
    void deleteAccountHolders(Long id);

}
