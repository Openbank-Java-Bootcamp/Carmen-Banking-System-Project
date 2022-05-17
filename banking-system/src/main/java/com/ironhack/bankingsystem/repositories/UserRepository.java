package com.ironhack.bankingsystem.repositories;

import com.ironhack.bankingsystem.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
