package com.ironhack.bankingsystem.service.impl;


import com.ironhack.bankingsystem.models.Role;
import com.ironhack.bankingsystem.repositories.RoleRepository;
import com.ironhack.bankingsystem.repositories.AdminRepository;
import com.ironhack.bankingsystem.service.interfaces.RoleServiceInterface;
import com.ironhack.bankingsystem.users.Admin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleService implements RoleServiceInterface {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AdminRepository adminRepository;

    public Role saveRole(Role role) {
        log.info("Saving a role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    public void addRoleToUser(String name, String roleName) {
        Admin admin = adminRepository.findByName(name);
        Role role = roleRepository.findByName(roleName);

        System.out.println(admin);
        System.out.println(role);
        /*admin.getRoles().add(role);
        adminRepository.save(admin);*/
    }
}
