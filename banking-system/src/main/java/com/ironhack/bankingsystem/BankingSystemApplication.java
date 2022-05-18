package com.ironhack.bankingsystem;

import com.ironhack.bankingsystem.models.Role;

import com.ironhack.bankingsystem.service.impl.UserService;
import com.ironhack.bankingsystem.users.Admin;
import com.ironhack.bankingsystem.users.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

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
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_ACCOUNT_HOLDERS"));

			userService.saveUser(new User("Carmen","1234","Car"));
			userService.saveUser(new User("Luciano","12345","Lucho"));
			userService.saveUser(new User("Wanda","123456","Wan"));

			userService.addRoleToUser("Car", "ROLE_ADMIN");
			userService.addRoleToUser("Lucho", "ROLE_ACCOUNT_HOLDERS");
			userService.addRoleToUser("Wan", "ROLE_ACCOUNT_HOLDERS");




		};
	}
}
