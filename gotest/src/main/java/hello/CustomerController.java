package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.entity.Customer;
import hello.repos.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository repos;

	@GetMapping(path="/getAll")
	Iterable<Customer> getAll(){
		return repos.findAll();
	}
}
