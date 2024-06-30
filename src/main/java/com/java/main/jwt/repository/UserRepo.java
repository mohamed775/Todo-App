package com.java.main.jwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.main.jwt.model.User;

@Repository
public interface UserRepo  extends JpaRepository<User, Integer>{

	Optional<User> findByEmail(String email);
	
}
