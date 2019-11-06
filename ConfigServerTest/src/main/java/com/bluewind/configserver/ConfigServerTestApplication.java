package com.bluewind.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/*
 * https://spring.io/guides/gs/centralized-configuration/
 * https://www.devglan.com/spring-cloud/refresh-property-config-runtime
 * 
 * Attention: "/actuator/refresh" is a POST method, rather than GET
 * 
 * In spring.cloud.config.server.git.uri,
 * property keys in more specifically named files (such as a-bootiful-client.properties) 
 * override those in application.properties or application.yml.
 * If there is no such key in config server, the property with the same name will be searched in client app's application.properties file as a fallback.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerTestApplication.class, args);
	}

}
