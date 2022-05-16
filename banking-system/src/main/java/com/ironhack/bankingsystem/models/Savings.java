package com.ironhack.bankingsystem.models;

import com.ironhack.bankingsystem.classes.Money;
import com.ironhack.bankingsystem.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "savings")
public class Savings extends Account{

    private double interestRate;


    public Savings(Money balance, String primaryOwner, String secondaryOwner, Money penaltyFee, Date creationDate, Status status, String secretKey, double interestRate) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee, creationDate, status, secretKey);
        this.interestRate = interestRate;
    }
}
