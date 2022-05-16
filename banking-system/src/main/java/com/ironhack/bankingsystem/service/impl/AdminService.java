package com.ironhack.bankingsystem.service.impl;


import com.ironhack.bankingsystem.models.Role;
import com.ironhack.bankingsystem.repositories.RoleRepository;
import com.ironhack.bankingsystem.repositories.AdminRepository;
import com.ironhack.bankingsystem.service.interfaces.AdminServiceInterface;
import com.ironhack.bankingsystem.users.Admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminService implements AdminServiceInterface {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private RoleRepository  roleRepository;


    public Admin saveAdmin(Admin admin){
        log.info("Saving a role {} to the database", admin.getName());
       return adminRepository.save(admin);
    }
}
