package com.ironhack.bankingsystem.models;

import com.ironhack.bankingsystem.classes.Money;
import com.ironhack.bankingsystem.enums.Status;
import com.ironhack.bankingsystem.users.AccountHolders;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@Table(name = "credit_card")
public class CreditCard extends Account{


    @NotNull
    private double creditLimit;
    @NotNull
    private double interestRate;



    public CreditCard(Money balance, AccountHolders primaryOwner, AccountHolders secondaryOwner, Money penaltyFee, Date creationDate, Status status, String secretKey) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee, creationDate, status, secretKey);
        this.creditLimit = 100;
        this.interestRate = 0.2;
    }
}
