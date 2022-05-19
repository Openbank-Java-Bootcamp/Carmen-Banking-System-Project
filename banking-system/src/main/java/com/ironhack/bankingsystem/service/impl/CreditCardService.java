package com.ironhack.bankingsystem.service.impl;

import com.ironhack.bankingsystem.models.CreditCard;
import com.ironhack.bankingsystem.models.Savings;
import com.ironhack.bankingsystem.repositories.CreditCardRepository;

import com.ironhack.bankingsystem.service.interfaces.CreditCardServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CreditCardService implements CreditCardServiceInterface {
    @Autowired
    CreditCardRepository creditCardRepository;

    public CreditCard getCreditCard(Long id){
        return creditCardRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "CreditCard account not found"));
    }
    public CreditCard saveCreditCard(CreditCard creditCard) {
        try {
            return creditCardRepository.save(new CreditCard(
                    creditCard.getBalance(),
                    creditCard.getPrimaryOwner(),
                    creditCard.getSecondaryOwner(),
                    creditCard.getPenaltyFee(),
                    creditCard.getCreationDate(),
                    creditCard.getStatus(),
                    creditCard.getSecretKey()
            ));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No CreditCard account found");

        }
    }
    public void updateCreditCard(Long id, CreditCard creditCard){
        CreditCard creditCardFromDb = creditCardRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The credit card account is not found"));
        creditCard.setId(creditCardFromDb.getId());
        creditCardRepository.save(creditCard);
    }
    public void deleteCreditCard(Long id){
        creditCardRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "CreditCard account not found"));
        creditCardRepository.deleteById(id);

    }

}
