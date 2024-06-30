package com.java.main.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
	
	@GetMapping("/dashboard")
    public String adminDashboard() {
        return "Welcome to the Admin Dashboard";
    }

}
