package com.ironhack.bankingsystem.controllers.interfaces;

import com.ironhack.bankingsystem.models.Savings;
import com.ironhack.bankingsystem.models.StudentChecking;

public interface SavingsControllerInterface {
    Savings getSavings(Long id);
    public Savings createSavings(Savings savings);
    void updateSavings(Long id, Savings savings);
    void deleteSavings(Long id);
}
