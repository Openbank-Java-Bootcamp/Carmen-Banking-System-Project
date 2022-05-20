package com.ironhack.bankingsystem.models;

import com.ironhack.bankingsystem.classes.Money;
import com.ironhack.bankingsystem.enums.Status;
import com.ironhack.bankingsystem.users.AccountHolder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "checking")
public class CheckingAccount extends Account{

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

    public CheckingAccount(Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money penaltyFee, Date creationDate, Status status, String secretKey) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee, creationDate, status, secretKey);
        this.minBalance = 250;
        this.monthlyMaintenanceFee = new Money(BigDecimal.valueOf(12));
    }


}
