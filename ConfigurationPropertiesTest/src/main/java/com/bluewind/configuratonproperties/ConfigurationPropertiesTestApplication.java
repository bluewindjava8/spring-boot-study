package com.bluewind.configuratonproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
 * https://www.baeldung.com/configuration-properties-in-spring-boot
 * http://zetcode.com/springboot/configurationproperties/
 */
@SpringBootApplication
@RestController
public class ConfigurationPropertiesTestApplication {
	
	@Autowired
	ConfigProperties configProperties;

	
	@Autowired
	private BlueProperties blueProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigurationPropertiesTestApplication.class, args);
	}

	@GetMapping("/properties")
	public ConfigProperties getProperties() {
		return configProperties;
	}
	
	@GetMapping("/blue")
	public BlueProperties getBlueProperties() {
		return blueProperties;
	}
	
	@GetMapping("/error")
	public String error() {
		return "Some error happens";
	}
	@RequestMapping("/error1")
	public String error1() {
		return "Some error1 happens";
	}	
}
