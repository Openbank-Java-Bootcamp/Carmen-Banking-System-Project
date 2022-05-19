package com.ironhack.bankingsystem.controllers.interfaces;

import com.ironhack.bankingsystem.models.CreditCard;
import com.ironhack.bankingsystem.models.Savings;

public interface CreditCardControllerInterface {
    CreditCard getCreditCard(Long id);
    public CreditCard createCreditCard(CreditCard creditCard);
    void updateCreditCard(Long id, CreditCard creditCard);
    void deleteCreditCard(Long id);
}
