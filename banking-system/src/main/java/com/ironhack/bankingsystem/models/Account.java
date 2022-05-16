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
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "account")
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(length = 510)
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "balance_amount", nullable = false)),
            @AttributeOverride(name = "currency", column = @Column(name = "balance_currency", nullable = false))
    })
    private Money balance;
    @NotNull
    private String primaryOwner;
    private String secondaryOwner;
    @NotNull
    @Column(length = 510)
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "penaltyFee_amount", nullable = false)),
            @AttributeOverride(name = "currency", column = @Column(name = "penaltyFee_currency", nullable = false))
    })
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


}
