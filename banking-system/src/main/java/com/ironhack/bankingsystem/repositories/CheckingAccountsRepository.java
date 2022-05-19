package com.ironhack.bankingsystem.repositories;
import com.ironhack.bankingsystem.models.CheckingAccounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingAccountsRepository extends JpaRepository<CheckingAccounts, Long> {
}