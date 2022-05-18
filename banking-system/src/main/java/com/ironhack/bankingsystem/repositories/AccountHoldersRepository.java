package com.ironhack.bankingsystem.repositories;

import com.ironhack.bankingsystem.users.AccountHolders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHoldersRepository extends JpaRepository<AccountHolders, Long> {
}
