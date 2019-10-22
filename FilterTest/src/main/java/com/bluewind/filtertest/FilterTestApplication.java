package com.bluewind.filtertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bluewind.filtertest.filter.RequestResponseLoggingFilter;
import com.bluewind.filtertest.filter.TransactionFilter;

@SpringBootApplication
@RestController
public class FilterTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilterTestApplication.class, args);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<String> hello() {
		return ResponseEntity.ok().header("my-header", "niuniu").body("Hello World!");
	}
	
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public String getAll() {
		return "all";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String getAllUsers() {
		return "user1, user2, user3";
	}
	
	/*
	 * To control the filter/URL mapping, we can use FilterRegistrationBean, which can control URL patterns and filter order.
	 * https://www.baeldung.com/spring-boot-add-filter
	 * https://www.concretepage.com/spring-boot/spring-boot-filter#FilterRegistrationBean
	 * 
	 */
	
	
	@Bean
	public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilter(){
		FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean = new FilterRegistrationBean<RequestResponseLoggingFilter>();
		registrationBean.setFilter(new RequestResponseLoggingFilter());
		registrationBean.addUrlPatterns("/users/*");
		registrationBean.setOrder(Ordered.LOWEST_PRECEDENCE);
		
		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean<TransactionFilter> transactionFilter(){
		FilterRegistrationBean<TransactionFilter> registrationBean = new FilterRegistrationBean<TransactionFilter>();
		registrationBean.setFilter(new TransactionFilter());
		registrationBean.addUrlPatterns("/users/*");
		registrationBean.setOrder(Ordered.LOWEST_PRECEDENCE - 1);
		
		return registrationBean;
	}
}
