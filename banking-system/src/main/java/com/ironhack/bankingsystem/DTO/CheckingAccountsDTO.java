package com.ironhack.bankingsystem.DTO;

import com.ironhack.bankingsystem.classes.Money;
import com.ironhack.bankingsystem.enums.Status;
import com.ironhack.bankingsystem.models.CheckingAccounts;
import com.ironhack.bankingsystem.users.AccountHolders;
import lombok.Data;

import java.util.Date;

@Data
public class CheckingAccountsDTO  {
    public Money balance;
    public Long primaryOwner;
    public AccountHolders secondaryOwner;
    public Money penaltyFee;
    public Date creationDate;
    public Status status;
    public String secretKey;

    public double minBalance;
    public Money monthlyMaintenanceFee;

}
