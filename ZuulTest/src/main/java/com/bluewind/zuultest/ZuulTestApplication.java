package com.bluewind.zuultest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/*
 * 
 * https://spring.io/guides/gs/routing-and-filtering/
 * https://cloud.spring.io/spring-cloud-netflix/multi/multi__router_and_filter_zuul.html
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulTestApplication.class, args);
	}
	
	  @Bean
	  public SimpleZuulFilter simpleFilter() {
	    return new SimpleZuulFilter();
	  }

}
