package com.ironhack.bankingsystem.service.interfaces;

import com.ironhack.bankingsystem.models.CreditCard;

public interface CreditCardServiceInterface {
    CreditCard getCreditCard(Long id);
    public CreditCard saveCreditCard(CreditCard creditCard);

    void updateCreditCard(Long id, CreditCard creditCard);
    void deleteCreditCard(Long id);
}
