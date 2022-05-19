package com.ironhack.bankingsystem.service.interfaces;

import com.ironhack.bankingsystem.models.CreditCard;
import com.ironhack.bankingsystem.models.Savings;

public interface SavingsServiceInterface {
    Savings getSavings(Long id);
    public Savings saveSavings(Savings savings);

    void updateSavings(Long id, Savings savings);
    void deleteSavings(Long id);
}
