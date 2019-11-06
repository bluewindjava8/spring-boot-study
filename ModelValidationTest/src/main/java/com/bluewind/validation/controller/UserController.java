package com.bluewind.validation.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bluewind.validation.entity.User;


@RestController
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/users")
	public ResponseEntity<String> addUser(@Valid @RequestBody User user){
		logger.info(user + " '\n is here. xxxxxxxxxxxxxxx");
		return ResponseEntity.ok().body("user is valid");
	}

}
