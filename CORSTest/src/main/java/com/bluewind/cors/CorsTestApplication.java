package com.bluewind.cors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 * https://spring.io/guides/gs/rest-service-cors/
 * https://www.tutorialspoint.com/spring_boot/spring_boot_cors_support.htm
 * https://www.tutorialspoint.com/spring_boot/spring_boot_consuming_restful_web_services.htm
 */
@SpringBootApplication
public class CorsTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorsTestApplication.class, args);
	}

}
