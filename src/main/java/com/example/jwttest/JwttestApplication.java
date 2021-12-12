package com.example.jwttest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.jwttest.domain.Role;
import com.example.jwttest.domain.User;
import com.example.jwttest.service.UserService;

@SpringBootApplication
public class JwttestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwttestApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(Role.builder().name("ROLE_USER").build());
			userService.saveRole(Role.builder().name("ROLE_MANAGER").build());
			userService.saveRole(Role.builder().name("ROLE_ADMIN").build());
			userService.saveRole(Role.builder().name("ROLE_SUPER_ADMIN").build());
			
			userService.saveUser(User.builder().name("John Travolta").username("john").password(passwordEncoder().encode("1234")).build());
			userService.saveUser(User.builder().name("Will Smith").username("will").password(passwordEncoder().encode("1234")).build());
			userService.saveUser(User.builder().name("Jim Carry").username("jim").password(passwordEncoder().encode("1234")).build());
			userService.saveUser(User.builder().name("Arnold Schwarzenegger").username("arnold").password(passwordEncoder().encode("1234")).build());
			
			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("john", "ROLE_MANAGER");
			userService.addRoleToUser("will", "ROLE_MANAGER");
			userService.addRoleToUser("jim", "ROLE_ADMIN");
			userService.addRoleToUser("arnold", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("arnold", "ROLE_ADMIN");
			userService.addRoleToUser("arnold", "ROLE_USER");
		};
	}
	
}
