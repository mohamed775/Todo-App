package com.java.main.jwt.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.java.main.jwt.dto.AuthenticationRequest;
import com.java.main.jwt.dto.AuthenticationResponse;
import com.java.main.jwt.dto.RegisterRequest;
import com.java.main.jwt.model.Role;
import com.java.main.jwt.model.User;
import com.java.main.jwt.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	private final UserRepo userRepo ;
	private final PasswordEncoder passwordEncoder ;
	private final JwtService jwtService ;
	private final AuthenticationManager authenticationManager;

	
	public AuthenticationResponse register(RegisterRequest request) {

		var user = User.builder()
				.firstname(request.getFirstname())
				.lastname(request.getLastname())
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.role(Role.USER)
				.build();
		userRepo.save(user);
		var jwtToken = jwtService.generateToken(user);
		
		return AuthenticationResponse.builder() 
				.token(jwtToken)
				.build();
				
	}

	
	public AuthenticationResponse authenticate(AuthenticationRequest request) {

		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getEmail(),
						request.getPassword()
			    )	
		);
		var user = userRepo.findByEmail(request.getEmail())
				.orElseThrow();
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder() 
				.token(jwtToken)
				.build();		
		
	}

}
