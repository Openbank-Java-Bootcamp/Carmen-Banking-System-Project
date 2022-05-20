package com.ironhack.bankingsystem.models;

import com.ironhack.bankingsystem.classes.Money;
import com.ironhack.bankingsystem.enums.Status;
import com.ironhack.bankingsystem.users.AccountHolder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Date;

import static java.util.Currency.getInstance;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "savings")
public class Savings extends Account {

    @NotNull
    private double interestRate = 0.0025;
    @NotNull
    private double minBalance = 1000;


    public Savings(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money penaltyFee, Date creationDate, Status status, String secretKey, double interestRate, double minBalance) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee, creationDate, status, secretKey);
        this.interestRate = interestRate;
        if (interestRate > 0.5) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Interest rate should be lower than 0.5");
        }
        this.minBalance = minBalance;
        if (minBalance > 1000 || minBalance < 100) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The minimum balance of your account should be between 100 and 1000");
        }
    }

    //insterest rate not working

   /* public void applyMaxInterestRate() {
        if (interestRate.getAmount().compareTo(super.getBalance().getAmount()) > 0.5) {
            BigDecimal newBalanceAmount = super.getBalance().decreaseAmount(getPenaltyFee().getAmount());
            Money newBalance = new Money(newBalanceAmount);
            super.setBalance(newBalance);
        }
    }*/
}