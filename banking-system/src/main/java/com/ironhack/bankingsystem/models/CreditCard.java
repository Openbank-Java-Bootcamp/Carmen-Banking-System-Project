package com.ironhack.bankingsystem.models;

import com.ironhack.bankingsystem.classes.Money;
import com.ironhack.bankingsystem.enums.Status;
import com.ironhack.bankingsystem.users.AccountHolder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@Table(name = "credit_card")
public class CreditCard extends Account{


    @NotNull
    private double creditLimit = 100;
    @NotNull
    private double interestRate = 0.2;



    public CreditCard(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money penaltyFee, Date creationDate, Status status, String secretKey) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee, creationDate, status, secretKey);
        if(creditLimit < 100 || creditLimit > 100000){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Credit limit should be more than 100 and less than 100000");
        }
        if(interestRate > 0.2 || interestRate < 0.1){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The interest rate should be less than 0.2 and more than 0.1");
        }
    }
}
