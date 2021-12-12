package com.example.jwttest;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.jwttest.domain.User;
import com.example.jwttest.service.UserService;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class LoginController {

	private final UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<User> saveUser(@RequestBody LoginForm loginForm) {
		URI uri = URI.create(ServletUriComponentsBuilder
				.fromCurrentContextPath().path("/api/user/save").toUriString());
		User user = userService.getUser(loginForm.getUsername());
		log.info("{}", user);
		return ResponseEntity.created(uri).body(user);
	}
	
}

@Data
class LoginForm {
	private String username;
	private String password;
}
