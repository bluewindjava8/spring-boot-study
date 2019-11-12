package com.bluewind.api.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * https://www.baeldung.com/spring-requestmapping
 * https://www.logicbig.com/tutorials/spring-framework/spring-web-mvc/uri-pattern.html
 * https://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/mvc.html
 */
@RestController
public class MyController {

	@RequestMapping("/books")
	public String books1() {
		return "this is book1";
	}
	
	/*
	 * books1 and books1_test cannot co-exist because they have exactly the same mapping condition.
	 * The application start failure will happen if we use books1 and books1_test in the same time.
	 */
//	@RequestMapping("/books")
//	public String books1_test() {
//		return "this is book1";
//	}	
	
	
	
	/*
	 * Note that book2 and book2 have the same path(/books) and same method(GET).
	 * While on the other hand, books3 has the "produces" field set, so it is considered more "precise" than books2.
	 * As a result, book2 and book3 can co-exist. GET Http request "/books" with "Accept" header "text/html" will be
	 * dispatched to book3 handler, and other http request without "Accept" header "text/html" will be dispatched to book2 handler.
	 */
	@GetMapping("/books")
	public String books2() {
		return "this is book2";
	}
	
	@GetMapping(value = "/books", produces = MediaType.TEXT_HTML_VALUE)
	public String books3() {
		return "this is book3";
	}	
	

}
