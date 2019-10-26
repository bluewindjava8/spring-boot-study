package com.bluewind.cors.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluewind.cors.model.Product;

@RestController
public class MyController {

	
	private static Map<String, Product> productRepo = new HashMap<>();
	static {
		Product honey = new Product();
		honey.setId("1");
		honey.setName("Honey");
		productRepo.put(honey.getId(), honey);

		Product almond = new Product();
		almond.setId("2");
		almond.setName("Almond");
		productRepo.put(almond.getId(), almond);
	}

	@GetMapping("/products")
	//@CrossOrigin(origins = { "http://localhost:8080", "http://127.0.0.1:8080"})
	//@CrossOrigin annotation can combine with the glabal CORS configuration in WebMvcConfigurer.addCorsMappings()
	//Refer to CORSConfiguration.java
	@CrossOrigin(origins = { "http://127.0.0.1:8080"})
	//@CrossOrigin(origins = "*")
	public ResponseEntity<Object> getProduct() {
		return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
	}
	
	
	@GetMapping("/public/blue")
	public  ResponseEntity<Object> blue() {
		Product blue = new Product();
		blue.setId("3");
		blue.setName("blue");
		return new ResponseEntity<>(blue, HttpStatus.OK);
	}
	
	@GetMapping("/public/green")
	public Product green() {
		Product green = new Product();
		green.setId("4");
		green.setName("green");
		return green;

	}
}
