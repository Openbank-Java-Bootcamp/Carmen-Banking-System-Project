package com.ironhack.bankingsystem.models;

import com.ironhack.bankingsystem.classes.Money;
import com.ironhack.bankingsystem.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@Table(name = "checking")
public class CheckingAccounts extends Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private double minBalance;
    @NotNull
    private Money monthlyMaintenanceFee;

    public CheckingAccounts( @NotNull Money balance, @NotNull String primaryOwner, String secondaryOwner, @NotNull Money penaltyFee, @NotNull Date creationDate, @NotNull Status status, @NotNull String secretKey, double minBalance, Money monthlyMaintenanceFee) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee, creationDate, status, secretKey);
        this.minBalance = minBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public CheckingAccounts() {
    }
}
