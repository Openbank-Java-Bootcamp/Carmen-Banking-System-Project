package com.ironhack.bankingsystem.controllers.impl;

import com.ironhack.bankingsystem.controllers.interfaces.SavingsControllerInterface;
import com.ironhack.bankingsystem.models.Savings;
import com.ironhack.bankingsystem.service.interfaces.SavingsServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/savings")
public class SavingsController implements SavingsControllerInterface {

    @Autowired
    SavingsServiceInterface savingsServiceInterface;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Savings getSavings(@PathVariable Long id){
        return savingsServiceInterface.getSavings(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Savings createSavings(@RequestBody @Valid Savings savings){
        return savingsServiceInterface.saveSavings(savings);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSavings(@PathVariable Long id, @RequestBody Savings savings){
        savingsServiceInterface.updateSavings(id, savings);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSavings(Long id) {
        savingsServiceInterface.deleteSavings(id);
    }

}
