package com.example.jwttest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jwttest.domain.User;

public interface UserRepo extends JpaRepository<User, Long>{
	
	User findByUsername(String username);
	
}
