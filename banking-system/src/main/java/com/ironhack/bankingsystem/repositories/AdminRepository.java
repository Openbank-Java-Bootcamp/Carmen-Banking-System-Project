package com.ironhack.bankingsystem.repositories;

import com.ironhack.bankingsystem.users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByName(String name);

    /*void saveAdmin(Admin admin);*/
}