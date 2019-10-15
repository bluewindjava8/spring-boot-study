package com.bluewind.errorhandling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * https://www.tutorialspoint.com/spring_boot/spring_boot_exception_handling.htm
 * https://www.baeldung.com/spring-boot-custom-error-page
 */

@SpringBootApplication
public class ErrorHandlingTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErrorHandlingTestApplication.class, args);
	}

}
