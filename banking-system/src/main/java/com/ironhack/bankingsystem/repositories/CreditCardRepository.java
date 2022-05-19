package com.ironhack.bankingsystem.repositories;

import com.ironhack.bankingsystem.models.CheckingAccounts;
import com.ironhack.bankingsystem.models.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
