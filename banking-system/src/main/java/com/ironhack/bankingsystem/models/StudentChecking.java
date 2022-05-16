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
@Table(name = "student")
public class StudentChecking extends Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private double interestRate;

    public StudentChecking() {
    }

    public StudentChecking( @NotNull Money balance, @NotNull String primaryOwner, String secondaryOwner, @NotNull Money penaltyFee, @NotNull Date creationDate, @NotNull Status status, @NotNull String secretKey, double interestRate) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee, creationDate, status, secretKey);
        this.interestRate = interestRate;
    }
}
