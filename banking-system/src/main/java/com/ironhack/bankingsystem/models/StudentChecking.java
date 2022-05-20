package com.ironhack.bankingsystem.models;

import com.ironhack.bankingsystem.classes.Money;
import com.ironhack.bankingsystem.enums.Status;
import com.ironhack.bankingsystem.users.AccountHolder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@Table(name = "student")
public class StudentChecking extends Account{

    @NotNull
    private double minBalance;



    public StudentChecking(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money penaltyFee, Date creationDate, Status status, String secretKey, double minBalance) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee, creationDate, status, secretKey);
        this.minBalance = minBalance;
    }
}
