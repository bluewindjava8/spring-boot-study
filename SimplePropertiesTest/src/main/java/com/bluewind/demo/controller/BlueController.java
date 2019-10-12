package com.bluewind.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlueController {

	@Value("${server.port:8080}")
	int port;
	
	
	@Value("${spring.application.name:bluewind-app}")
	String appName;
	
	/*
	 * properties can also be passed from as a command line argument with --PROPERTY_NAME
	 * java -jar target\SimplePropertiesTest-0.0.1-SNAPSHOT.jar --spring.application.nickname=littlebluewind
	 */
	@Value("${spring.application.nickname:bluewind-nick-app}")
	String nickName;
	
	
	/*
	 * properties can also be passed from as a JVM parameter with -DPROPERTY_NAME
	 * java -jar -Dspring.application.color=red target\SimplePropertiesTest-0.0.1-SNAPSHOT.jar --spring.application.nickname=littlebluewind
	 */
	@Value("${spring.application.color:blue}")
	String color;
	

	
	@GetMapping("/properties")
	public String getProperties() {
		System.out.println("port = " + port);
		System.out.println("appName = " + appName);
		System.out.println("nickName = " + nickName);
		System.out.println("color = " + color);
		
		return "OK";
	}
	
}
