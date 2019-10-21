package com.bluewind.interceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * https://www.tutorialspoint.com/spring_boot/spring_boot_interceptor.htm
 * Please be noted that HandlerInterceptor is a part of Spring DispatchServlet,
 * so all servlet filters on DispatchServlet are executed before methods in HandlerInterceptor. 
 * Please refer to FilterTest project in the same workspace.
 */
@SpringBootApplication
public class HandlerInterceptorTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HandlerInterceptorTestApplication.class, args);
	}

}
