package com.ironhack.bankingsystem;

import com.ironhack.bankingsystem.models.Role;
import com.ironhack.bankingsystem.service.impl.RoleService;
import com.ironhack.bankingsystem.service.impl.AdminService;
import com.ironhack.bankingsystem.users.Admin;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BankingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingSystemApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(AdminService adminService, RoleService roleService) {
		return args -> {
			roleService.saveRole(new Role(null, "ROLE_USER"));
			roleService.saveRole(new Role(null, "ROLE_ADMIN"));

			/*adminService.saveAdmin(new Admin("John Doe"));

			roleService.addRoleToUser("John Doe", "ROLE_ADMIN");*/
		};
	}
}
