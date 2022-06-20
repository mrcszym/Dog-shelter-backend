package com.mrc.dogspring;

import com.mrc.dogspring.domain.AppUser;
import com.mrc.dogspring.domain.Role;
import com.mrc.dogspring.domain.ApplicationForm;
import com.mrc.dogspring.service.AppFormService;
import com.mrc.dogspring.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DogSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogSpringApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService, AppFormService appFormService) {
		return args -> {
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_USER"));

			userService.saveUser(new AppUser(null, "u1@gmail.com", "u1", new ArrayList<>()));
			userService.saveUser(new AppUser(null, "a1@gmail.com", "a1", new ArrayList<>()));

			userService.addRoleToUser("u1@gmail.com", "ROLE_USER");
			userService.addRoleToUser("a1@gmail.com", "ROLE_ADMIN");

			appFormService.saveForm(new ApplicationForm(
					null,
					"Szymon",
					"Mariacki",
					"Pies rasy Corgi",
					"730555112",
					"oczekujące"
					));

			appFormService.saveForm(new ApplicationForm(
					null,
					"Anna",
					"Kowalska",
					"Kot",
					"609333505",
					"oczekujące"
					));

			appFormService.saveForm(new ApplicationForm(
					null,
					"Thomas",
					"Tomaszewski",
					"Pies dowolnej rasy",
					"881666525",
					"oczekujące"
					));

			System.out.println(appFormService.getForms());
		};
	}
}
