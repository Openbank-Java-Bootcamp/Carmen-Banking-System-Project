package com.ironhack.bankingsystem.controllers.interfaces;

import com.ironhack.bankingsystem.users.AccountHolders;

public interface AccountHoldersControllerInterface {
    AccountHolders getAccountHolders(Long id);
    public AccountHolders createAccountHolders(AccountHolders accountHolders);
    void updateAccountHolders(Long id, AccountHolders accountHolders);
    void deleteAccountHolders(Long id);

}
