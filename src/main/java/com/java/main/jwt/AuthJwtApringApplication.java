package com.java.main.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.java.main.jwt.model.Role;
import com.java.main.jwt.model.User;
import com.java.main.jwt.repository.UserRepo;

@SpringBootApplication
public class AuthJwtApringApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepo userRepo ;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(AuthJwtApringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		var user = User.builder()
				.firstname("admin")
				.lastname("admin")
				.email("admin@gmail.com")
				.password(passwordEncoder.encode("admin"))
				.role(Role.ADMIN)
				.build();
		userRepo.save(user);
				
	}

}
