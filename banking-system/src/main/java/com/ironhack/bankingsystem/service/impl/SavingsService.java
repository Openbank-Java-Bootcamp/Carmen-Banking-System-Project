package com.ironhack.bankingsystem.service.impl;

import com.ironhack.bankingsystem.models.Savings;
import com.ironhack.bankingsystem.models.StudentChecking;
import com.ironhack.bankingsystem.repositories.SavingsRepository;
import com.ironhack.bankingsystem.repositories.StudentCheckingRepository;
import com.ironhack.bankingsystem.service.interfaces.SavingsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SavingsService implements SavingsServiceInterface {

    @Autowired
    SavingsRepository savingsRepository;

    public Savings getSavings(Long id){
        return savingsRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Savings account not found"));
    }
    public Savings saveSavings(Savings savings) {
        try {
            return savingsRepository.save(new Savings(
                    savings.getBalance(),
                    savings.getPrimaryOwner(),
                    savings.getSecondaryOwner(),
                    savings.getPenaltyFee(),
                    savings.getCreationDate(),
                    savings.getStatus(),
                    savings.getSecretKey(),
                    savings.getMinBalance(),
                    savings.getInterestRate()

            ));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No savings account found");

        }
    }
    public void updateSavings(Long id, Savings savings){
        Savings savingsFromDb = savingsRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The savings account is not found"));
        savings.setId(savingsFromDb.getId());
        savingsRepository.save(savings);
    }
    public void deleteSavings(Long id){
        savingsRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Savings account not found"));
        savingsRepository.deleteById(id);

    }

}
