package com.bluewind.log.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluewind.log.repository.LogRepository;

@RestController
public class LogController {
	
	private static final Logger logger = LoggerFactory.getLogger(LogController.class);
	
	@Autowired
	LogRepository repos;
	
	@GetMapping("/log")
	public ResponseEntity<String> log() {
		logger.debug("This is debug msg in LogController");
		logger.info("This is info msg in LogController");
		logger.warn("This is warn msg in LogController");
		logger.error("This is error msg in LogController");
		
		repos.test();
		
		return ResponseEntity.ok().header("firstName", "wind").header("lastname", "wind").body("log api ok");
	}
}
