package com.bluewind.cors.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Both @Configuration annotation and @Component annotation will work here
//@Configuration
@Component
public class CORSConfiguration implements WebMvcConfigurer {

	/*
	 * As an alternative to fine-grained annotation-based configuration, you can
	 * also define some global CORS configuration as well. This is similar to using
	 * a Filter based solution, but can be declared within Spring MVC and combined
	 * with fine-grained @CrossOrigin configuration. By default all origins and GET,
	 * HEAD and POST methods are allowed.
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/products").allowedOrigins("http://localhost:8080");
		registry.addMapping("/public/**").allowedOrigins("*");
	}
}