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
import java.time.LocalDate;
import java.time.Period;
import java.util.Currency;
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

        public String sendTransfer (Money transferAmount){
            if (super.getBalance().getAmount().compareTo(transferAmount.getAmount()) >= 0) {
                BigDecimal newBalanceAmount = super.getBalance().getAmount().subtract(transferAmount.getAmount());
                Money newBalance = new Money(newBalanceAmount, Currency.getInstance("USD"));
                this.setBalance(newBalance);
                return ("Your actual balance: " + newBalance);
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not enough balance to do a transfer");
            }
        }

        public void receiveTransfer (Money transferAmount){
            BigDecimal newBalanceAmount = super.getBalance().getAmount().add(transferAmount.getAmount());
            Money newBalance = new Money(newBalanceAmount, Currency.getInstance("USD"));
            this.setBalance(newBalance);
        }

/*  public void deductMonthlyMaintenanceFee(){
        Period period = Period.between(getCreationDate(), LocalDate.now());
        int years = period.getYears();
        int months = period.getMonths() + years * 12;
        int notPaidCounter = months - getMaintenanceFeeCounter();
        if(notPaidCounter != 0){
            BigDecimal totalMaintenanceFee = monthlyMaintenanceFee.getAmount().multiply(new BigDecimal(notPaidCounter));
            BigDecimal newBalanceAmount = super.getBalance().decreaseAmount(totalMaintenanceFee);
            Money newBalance = new Money(newBalanceAmount);
            super.setBalance(newBalance);
            setMaintenanceFeeCounter(notPaidCounter);
        }
    }*/


}
