package com.bluewind.restclient.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bluewind.restclient.model.Product;

@RestController
public class RestClientController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/template/products")
	public String getProductList() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		//HttpEntity represents an HTTP request or response entity, consisting of headers and body. (not including http method and URL)
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		return restTemplate.exchange("http://localhost:8080/products", HttpMethod.GET, entity, String.class).getBody();
	}
	
	@PostMapping("/template/products")
	public String createProduct(@RequestBody Product product) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		//HttpEntity represents an HTTP request or response entity, consisting of headers and body. (not including http method and URL)
		HttpEntity<Product> entity = new HttpEntity<>(product, headers);
		
		return restTemplate.exchange("http://localhost:8080/products", HttpMethod.POST, entity, String.class).getBody();
	}	
	
	@PutMapping("/template/products/{id}")
	public String updateProduct(@PathVariable(name = "id") String id, @RequestBody Product product) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		//HttpEntity represents an HTTP request or response entity, consisting of headers and body. (not including http method and URL)
		HttpEntity<Product> entity = new HttpEntity<>(product, headers);
		
		return restTemplate.exchange("http://localhost:8080/products" + "/" + id, HttpMethod.PUT, entity, String.class).getBody();
	}
	
	@DeleteMapping("/template/products/{id}")
	public String deleteProduct(@PathVariable(name = "id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		//HttpEntity represents an HTTP request or response entity, consisting of headers and body. (not including http method and URL)
		HttpEntity<Product> entity = new HttpEntity<>(headers);
		
		return restTemplate.exchange("http://localhost:8080/products" + "/" + id, HttpMethod.DELETE, entity, String.class).getBody();
	}
	
	
	//Addtional test to return Product instead of String
	@PostMapping("/template/v2/products")
	public Product createProductV2(@RequestBody Product product) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		//HttpEntity represents an HTTP request or response entity, consisting of headers and body. (not including http method and URL)
		HttpEntity<Product> entity = new HttpEntity<>(product, headers);
		
		return restTemplate.exchange("http://localhost:8080/v2/products", HttpMethod.POST, entity, Product.class).getBody();
	}	
		
		
}
