package com.bluewind.filtertest;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

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

	/*It seems that there is no way to get the servlet class name from HttpServletRequest in the current version of Servlet.
	 * https://coderanch.com/t/451715/java/ther-servlet-Httprequest-servletContext
	 * 
	 * here a servlet class is mapped to the url pattern through a servlet name...
		and i think there is no method in HttpRequest interface that will give you servlet name...
		you also better check this
		http://java.sun.com/javaee/5/docs/api/javax/servlet/http/HttpServletRequest.html";
		and if you check ServletContext interface you will find
		
		java.util.Enumeration getServletNames()
		Deprecated. As of Java Servlet API 2.1, with no replacement.
		This method was originally defined to return an Enumeration of all the servlet names known to this context. In this version, this method always returns an empty Enumeration and remains only to preserve binary compatibility. This method will be permanently removed in a future version of the Java Servlet API.
		
		java.util.Enumeration getServlets()
		Deprecated. As of Java Servlet API 2.0, with no replacement.
		This method was originally defined to return an Enumeration of all the servlets known to this servlet context. In this version, this method always returns an empty enumeration and remains only to preserve binary compatibility. This method will be permanently removed in a future version of the Java Servlet API.
		
		or you find out
		http://java.sun.com/j2ee/sdk_1.3/techdocs/api/javax/servlet/ServletContext.html
	 */
	@RequestMapping(value = "/servletName", method = RequestMethod.GET)
	public String servletName(HttpServletRequest request) {
		Enumeration<String> servletNames = request.getServletContext().getServletNames();
		String contextName = request.getServletContext().getServletContextName();

		System.out.println("servletNames: " + servletNames);
		

	   while(servletNames.hasMoreElements()) {
	       System.out.println(servletNames.nextElement());
	   }
	   
		System.out.println("servletContextName: " + contextName);
		return contextName;
	}

	/*
	 * To control the filter/URL mapping, we can use FilterRegistrationBean, which
	 * can control URL patterns and filter order.
	 * https://www.baeldung.com/spring-boot-add-filter
	 * https://www.concretepage.com/spring-boot/spring-boot-filter#
	 * FilterRegistrationBean
	 * 
	 */

	@Bean
	public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilter() {
		FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean = new FilterRegistrationBean<RequestResponseLoggingFilter>();
		registrationBean.setFilter(new RequestResponseLoggingFilter());
		registrationBean.addUrlPatterns("/users/*");
		registrationBean.setOrder(Ordered.LOWEST_PRECEDENCE);

		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean<TransactionFilter> transactionFilter() {
		FilterRegistrationBean<TransactionFilter> registrationBean = new FilterRegistrationBean<TransactionFilter>();
		registrationBean.setFilter(new TransactionFilter());
		registrationBean.addUrlPatterns("/users/*");
		registrationBean.setOrder(Ordered.LOWEST_PRECEDENCE - 1);

		return registrationBean;
	}
}
