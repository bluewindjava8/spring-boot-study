package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	private static final Logger logger = LoggerFactory.getLogger(TestService.class);
	
	public void hello() {
		logger.info("This is TestService.hello()");
	}
}
