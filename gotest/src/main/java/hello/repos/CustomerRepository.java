package hello.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hello.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	List<Customer> findByLastName(String lastName);
	
	Customer findById(long id);
	
	List<Customer> findByLastNameAndFirstName(String lastName, String firstName);
	
	List<Customer> findByLastNameIn(List<String> lastNames);
}
