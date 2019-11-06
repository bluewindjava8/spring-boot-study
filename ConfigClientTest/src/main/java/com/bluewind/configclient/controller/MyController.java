package com.bluewind.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
 * "/actuator/refresh" (POST)  endpoint only refreshes those properties annotated with @ConfigurationProperties,
 * which means it does not refresh those properties which are initialized during app initialization like @Value.
 * To update property annotated with @Value, we need to annotate the class with @RefreshScope.
 * 
 * https://www.devglan.com/spring-cloud/refresh-property-config-runtime
 * 
 */

@RestController
@RefreshScope
public class MyController {
	@Value("${message:Hello default}")
	private String message;

	@RequestMapping("/message")
	String getMessage() {
		return this.message;
	}
}
