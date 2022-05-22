package com.ironhack.bankingsystem.service.impl;

import com.ironhack.bankingsystem.classes.Money;
import com.ironhack.bankingsystem.repositories.AccountHolderRepository;
import com.ironhack.bankingsystem.service.interfaces.AccountHolderServiceInterface;
import com.ironhack.bankingsystem.users.AccountHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class AccountHolderService implements AccountHolderServiceInterface {

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public AccountHolder getAccountHolders(Long id){
        return accountHolderRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account holder not found"));
    }
    public AccountHolder saveAccountHolders(AccountHolder accountHolder) {
        try {
            return accountHolderRepository.save(new AccountHolder(
                    accountHolder.getName(),
                    passwordEncoder.encode(accountHolder.getPassword()),
                    accountHolder.getUsername(),
                    accountHolder.getDateOfBirth(),
                    accountHolder.getPrimaryAddress(),
                    accountHolder.getMailingAddress()
            ));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No account found");
        }
    }

    public void updateAccountHolders(Long id, AccountHolder accountHolder){
        AccountHolder accountHolderFromDb = accountHolderRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The account holder is not found in the database"));
        accountHolder.setId(accountHolderFromDb.getId());
        accountHolderRepository.save(accountHolder);
    }
    public void deleteAccountHolders(Long id){
        accountHolderRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account holder not found"));
        accountHolderRepository.deleteById(id);

    }

/*   public void makeTransfer(Long id, String recipientName, Money transferAmount){
       Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

       if (principal instanceof UserDetails) {
           String username = ((UserDetails)principal).getUsername();
       } else {
           String username = principal.toString();
       }
       accountHolderRepository.finB

   }*/

}

//Acceder al accountHolder que hace la transferencia,
//Comprobar que el balance del accountHolder es superior al transferAmount
//Si es true, tenemos que tener acceso al accountHolder que lo recibe hacemos un patch, modificando su balance y añadiendo el transfer amount.
//Deducir el transfer amount del que hace la transferencia del balance.
//Si el false throw exception.


