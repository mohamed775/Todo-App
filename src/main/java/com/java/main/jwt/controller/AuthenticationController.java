package com.java.main.jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.main.jwt.config.AuthenticationService;
import com.java.main.jwt.dto.AuthenticationRequest;
import com.java.main.jwt.dto.AuthenticationResponse;
import com.java.main.jwt.dto.RegisterRequest;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	
	private final AuthenticationService service;

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
		
		return ResponseEntity.ok(service.register(request)) ;
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
		
		return ResponseEntity.ok(service.authenticate(request));
 
	}
	
	
}
