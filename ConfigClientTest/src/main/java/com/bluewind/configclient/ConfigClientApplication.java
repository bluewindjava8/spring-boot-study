package com.bluewind.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * https://spring.io/guides/gs/centralized-configuration/
 * https://www.devglan.com/spring-cloud/refresh-property-config-runtime
 * 
 * Attention: "/actuator/refresh" is a POST method, rather than GET
 */
@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

}
