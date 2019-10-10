package com.bluewind.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bluewind.demo.entity.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long>{
	List<Customer> findAll();
}
