package com.bluewind.filtertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FilterTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilterTestApplication.class, args);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<String> hello() {
		return ResponseEntity.ok().header("my-header", "niuniu").body("Hello World!");
	}
	
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public String getAll() {
		return "all";
	}

}
