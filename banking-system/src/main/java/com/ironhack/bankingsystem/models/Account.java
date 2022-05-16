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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Money balance;
    @NotNull
    private String primaryOwner;
    private String secondaryOwner;
    @NotNull
    private Money penaltyFee;
    @NotNull
    private Date creationDate;
    @NotNull
    private Status status;
    @NotNull
    private String secretKey;

    public Account(Money balance, String primaryOwner, String secondaryOwner, Money penaltyFee, Date creationDate, Status status, String secretKey) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.penaltyFee = penaltyFee;
        this.creationDate = creationDate;
        this.status = status;
        this.secretKey = secretKey;
    }

    public Account() {
    }
}
