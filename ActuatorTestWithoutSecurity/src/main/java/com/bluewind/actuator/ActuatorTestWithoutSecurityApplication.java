package com.bluewind.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Actuator does not have any dependency on spring security. 
 * Actuator only exposes several entry points like /actuator/metrics, /actuator/beans, etc
 */
@SpringBootApplication
public class ActuatorTestWithoutSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActuatorTestWithoutSecurityApplication.class, args);
	}

}
