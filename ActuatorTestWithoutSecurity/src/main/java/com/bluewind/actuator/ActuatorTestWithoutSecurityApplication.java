package com.bluewind.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ActuatorTestWithoutSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActuatorTestWithoutSecurityApplication.class, args);
	}

}
