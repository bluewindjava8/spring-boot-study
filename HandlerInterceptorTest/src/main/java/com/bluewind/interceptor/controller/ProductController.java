package com.bluewind.interceptor.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluewind.interceptor.model.Product;

@RestController
public class ProductController {

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

	@RequestMapping(value = "/v1/products", method = RequestMethod.GET)
	public ResponseEntity<Object> getProduct() {
		//return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
		return ResponseEntity.ok().header("test", "test_header").body(productRepo.values());
	}
	
	
	@RequestMapping(value = "/v2/products", method = RequestMethod.GET)
	public ResponseEntity<Object> getProductV2() {
		//return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
		return ResponseEntity.ok().header("test_v2", "test_header_v2").body(productRepo.values());
	}
	
	
	@RequestMapping(value = "/v1/products_list", method = RequestMethod.GET)
	public ResponseEntity<Object> getProductList() {
		//return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
		return ResponseEntity.ok().header("test_list", "test_header_list").body(productRepo.values());
	}
	
		
}
