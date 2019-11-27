package com.bluewind.autoware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AutowireTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutowireTestApplication.class, args);
	}

	
	@Autowired
	public void testBlue(RestTemplate restTemplate) {
		
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
