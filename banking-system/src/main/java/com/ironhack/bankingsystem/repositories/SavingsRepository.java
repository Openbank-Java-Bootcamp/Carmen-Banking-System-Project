package com.ironhack.bankingsystem.repositories;

import com.ironhack.bankingsystem.models.CheckingAccounts;
import com.ironhack.bankingsystem.models.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsRepository extends JpaRepository<Savings, Long> {
}
