package com.bluewind.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bluewind.demo.entity.Customer;
import com.bluewind.demo.repository.CustomerRepository;

@SpringBootApplication
public class RequestParamTestApplication implements CommandLineRunner{

	@Autowired
	CustomerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(RequestParamTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.save(new Customer("Jack", "Bauer"));
		repository.save(new Customer("Chloe", "O'Brian"));
		repository.save(new Customer("Kim", "Bauer"));
		repository.save(new Customer("David", "Palmer"));
		repository.save(new Customer("Michelle", "Dessler"));
	}

}
