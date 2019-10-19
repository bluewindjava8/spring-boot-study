package com.bluewind.actuator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@GetMapping("/getAll")
	public String getAll() {
		return "This is /getAll mapping";
	}
	
	@GetMapping("/getBook")
	public String getBookById() {
		return "This is /getBook mapping";
	}
	
}
