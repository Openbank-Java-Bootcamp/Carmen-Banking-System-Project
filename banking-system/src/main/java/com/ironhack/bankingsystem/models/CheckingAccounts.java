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
@NoArgsConstructor
@Table(name = "checking")
public class CheckingAccounts extends Account{

    @NotNull
    private double minBalance;
    @NotNull
    @Column(length = 510)
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "monthlyMaintenanceFee_amount", nullable = false)),
            @AttributeOverride(name = "currency", column = @Column(name = "monthlyMaintenanceFee_currency", nullable = false))
    })
    private Money monthlyMaintenanceFee;

    public CheckingAccounts(Money balance, AccountHolders primaryOwner, AccountHolders secondaryOwner, Money penaltyFee, Date creationDate, Status status, String secretKey, double minBalance, Money monthlyMaintenanceFee) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee, creationDate, status, secretKey);
        this.minBalance = minBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }


}
