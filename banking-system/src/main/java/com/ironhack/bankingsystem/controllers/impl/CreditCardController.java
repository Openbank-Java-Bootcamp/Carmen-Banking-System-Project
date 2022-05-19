package com.ironhack.bankingsystem.controllers.impl;

import com.ironhack.bankingsystem.controllers.interfaces.AccountHoldersControllerInterface;
import com.ironhack.bankingsystem.controllers.interfaces.CreditCardControllerInterface;
import com.ironhack.bankingsystem.models.CreditCard;
import com.ironhack.bankingsystem.models.Savings;
import com.ironhack.bankingsystem.service.interfaces.CreditCardServiceInterface;
import com.ironhack.bankingsystem.service.interfaces.SavingsServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/creditcard")
public class CreditCardController implements CreditCardControllerInterface {

    @Autowired
    CreditCardServiceInterface creditCardServiceInterface;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CreditCard getCreditCard(@PathVariable Long id){
        return creditCardServiceInterface.getCreditCard(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard createCreditCard(@RequestBody @Valid CreditCard creditCard){
        return creditCardServiceInterface.saveCreditCard(creditCard);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCreditCard(@PathVariable Long id, @RequestBody CreditCard creditCard){
        creditCardServiceInterface.updateCreditCard(id, creditCard);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCreditCard(Long id) {
        creditCardServiceInterface.deleteCreditCard(id);
    }


}
