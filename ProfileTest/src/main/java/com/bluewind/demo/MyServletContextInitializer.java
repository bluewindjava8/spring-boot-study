package com.bluewind.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyServletContextInitializer implements ServletContextInitializer {
	
	@Value("${spring.profiles.active}")
	String activeProfile;
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
    	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx active profile is : " + activeProfile);
//    	if(activeProfile == null) {
//    		servletContext.setInitParameter("spring.profiles.active", "dev");
//    	}
    	
    	
    	servletContext.setInitParameter("spring.profiles.active", "dev");
		
	}

}
