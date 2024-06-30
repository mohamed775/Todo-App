package com.java.main.jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/v1/demo-controller")
public class DemoController {
	
	@GetMapping("/hello")
	public ResponseEntity<String> sayHello() {
		return ResponseEntity.ok("hello from secure endpoint ");
	}
	
//	@GetMapping("/user/hello")
//	public ResponseEntity<String> userAccess() {
//		return ResponseEntity.ok("hello from user endpoint secure");
//	}
//	
//	@GetMapping("/admin/hello")
//	public ResponseEntity<String> adminAccess() {
//		return ResponseEntity.ok("hello from admin endpoint secure");
//	}
	

}
