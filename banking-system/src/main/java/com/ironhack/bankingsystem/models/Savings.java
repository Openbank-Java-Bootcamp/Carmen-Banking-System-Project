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
@Table(name = "savings")
public class Savings extends Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double interestRate;

    public Savings() {
    }

    public Savings(Long id, @NotNull Money balance, @NotNull String primaryOwner, String secondaryOwner, @NotNull Money penaltyFee, @NotNull Date creationDate, @NotNull Status status, @NotNull String secretKey, double interestRate) {
        super(id, balance, primaryOwner, secondaryOwner, penaltyFee, creationDate, status, secretKey);
        this.interestRate = interestRate;
    }
}
