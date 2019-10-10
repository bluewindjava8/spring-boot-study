package com.bluewind.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bluewind.demo.entity.Customer;
import com.bluewind.demo.repository.CustomerRepository;


@RestController
public class CustomerController {

	@Autowired
	CustomerRepository repository;
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Customer> getAll() {
		List<Customer> customers = repository.findAll();
		return customers;
	}
	

	@GetMapping("/getCustomer/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		Optional<Customer> customer = repository.findById(id);
		if(customer.isPresent()) {
			return customer.get();
		}else{
			throw new RuntimeException("No such Customer with ID: " + id);
		}
	}
	
	/*
	 * If we want to parse a method parameter from a path variable, we must use @PathVariable annotation,
	 * or spring will not parse it for us. This is different from @RequestParam. 
	 * For example, the URL below won't work because spring will only try to parse the id from query string, not from path variable.  
	 * 127.0.0.1:8080/getCustomer_2/3
	 * 
	 * The following URL will work, because it provides the query string "id=3"
	 * 127.0.0.1:8080/getCustomer_2/3?id=3
	 */
	@GetMapping("/getCustomer_2/{id}")
	public Customer getCustomer_2(Long id) {
		Optional<Customer> customer = repository.findById(id);
		if(customer.isPresent()) {
			return customer.get();
		}else{
			throw new RuntimeException("No such Customer with ID: " + id);
		}
	}	
	

	/*
	 * If we don't the @RequestParam, spring only get method parameter values which have the exactly same names (case-sensitive) with the parameters in URL query string.
	 *    Or spring will evaluate null to the method parameter which has no matching. If those parameters are primitive type, an exception will happen. 
	 */
	@GetMapping(value="/createCustomerGet1")
	public Customer createCustomerGet1(String firstName, String lastName, int age) {
		System.out.println("age:" + age);
		Customer newCustomer = new Customer(firstName, lastName);
		newCustomer = repository.save(newCustomer);
		return newCustomer;
		
	}
	
	/*
	 * 	While @RequestParams extract values from the query string, @PathVariables extract values from the URI path.
	 *  Method parameters annotated with @RequestParam are required by default.
	 */
	@GetMapping(value="/createCustomerGet1_2")
	public Customer createCustomerGet1_2(@RequestParam String firstName, @RequestParam String lastName, int age) {
		System.out.println("age:" + age);
		Customer newCustomer = new Customer(firstName, lastName);
		newCustomer = repository.save(newCustomer);
		return newCustomer;
		
	}
		
		
	/*
	 * If we don't use @RequestParam on one method parameter, it has the same effect as we use @RequestParam(required=false) on the non-complex method parameter type like String, Integer.
	 * https://www.baeldung.com/spring-request-param
	 * 
	 * Spring can parse the complex type Customer if we don't use @RequestParam annotation like below. 
	 * For example, Sprint will parse the internal fields of the complex type "Customer" for us 
	 * from  query string "firstName" and "lastName", if we don't use @RequestParam annotation:
	 * 127.0.0.1:8080/createCustomerGet2?firstName=ke&lastName=liu&age=102
	 */
	@GetMapping(value="/createCustomerGet2")
	public Customer createCustomerGet2(Customer customer) {
		System.out.println("customer = " + customer);
		Customer newCustomer = repository.save(customer);
		newCustomer = repository.save(newCustomer);
		return newCustomer;
		
	}	
	

	/*
	 * If we use @RequestParam on a complex method parameter type (like String, Integer) that spring cannot parse, 
	 * spring will not parse the internal fields of the complex type for us from several query strings.
	 * 
	 * For example, spring cannot parse the internal fields of the complex type "Customer" for us 
	 * from  query string "firstName" and "lastName", if we use @RequestParam annotation:
	 * 127.0.0.1:8080/createCustomerGet2_2?firstName=ke&lastName=liu&age=102
	 */
	@GetMapping(value="/createCustomerGet2_2")
	public Customer createCustomerGet2_2(@RequestParam(required=false) Customer customer) {
		System.out.println("customer = " + customer);
		Customer newCustomer = repository.save(customer);
		newCustomer = repository.save(newCustomer);
		return newCustomer;
		
	}	
	
	/*
	 * Spring can use one query string (ex. lastName=liu) to match more than one places.
	 * With the URL below, "lastName=liu" will match both the "lastName" method parameter and the customer.lastName.
	 * 127.0.0.1:8080/createCustomerGet2?firstName=ke&lastName=liu&age=102
	 */
	@GetMapping(value="/createCustomerGet3")
	public Customer createCustomerGet3(Customer customer, String firstName, String lastName, Integer age) {
		System.out.println("customer = " + customer);
		System.out.println("firstName = " +firstName + ", lastName = " + lastName + ", age = " + age);
		Customer newCustomer = repository.save(customer);
		newCustomer = repository.save(newCustomer);
		return newCustomer;
		
	}	
	
	/*
	 * https://www.baeldung.com/spring-request-response-body
	 */
	
	@PostMapping(value="/createCustomerPost1")
	public Customer createCustomerPost1(@RequestBody Customer customer) {
		System.out.println("customer = " + customer);
		Customer newCustomer = repository.save(customer);
		newCustomer = repository.save(newCustomer);
		return newCustomer;
		
	}
	
	
	@PostMapping(value="/createCustomerPost2")
	public Customer createCustomerPost2(Customer customer) {
		System.out.println("customer = " + customer);
		Customer newCustomer = repository.save(customer);
		newCustomer = repository.save(newCustomer);
		return newCustomer;
		
	}
	
	/*
	 * return ResponseEntity to control http status code, http header and so on
	 */
	@PostMapping(value="/createCustomerPost3")
	public ResponseEntity<Customer> createCustomerPost3(@RequestBody Customer customer) {
		System.out.println("customer = " + customer);
		Customer newCustomer = repository.save(customer);
		newCustomer = repository.save(newCustomer);
		return ResponseEntity.status(HttpStatus.CREATED).header("test", "myvalue").body(newCustomer);
		
	}
	
}
