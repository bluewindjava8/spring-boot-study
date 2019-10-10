package hello;


import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hello.entity.Customer;
import hello.repos.CustomerRepository;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
			
			// fetch customers by last name and first name
			log.info("Customer found with findByLastName('Bauer', 'Jack'):");
			log.info("--------------------------------------------");
			repository.findByLastNameAndFirstName("Bauer", "Jack").forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info("");
			
			log.info("Customer found with findByLastName('Bauer', 'Jack1'):");
			log.info("--------------------------------------------");
			repository.findByLastNameAndFirstName("Bauer", "Jack1").forEach(bauer -> {
				log.info(bauer.toString());
			});
			
			
			log.info("");
			
			log.info("Customer found with findByLastNameIn):");
			log.info("--------------------------------------------");
			List<String> lastNames = new LinkedList<>();
			lastNames.add("Bauer");
			lastNames.add("Palmer");
			
			repository.findByLastNameIn(lastNames).forEach(person -> {
				log.info(person.toString());
			});
			
			
			log.info("");
		};
	}
}