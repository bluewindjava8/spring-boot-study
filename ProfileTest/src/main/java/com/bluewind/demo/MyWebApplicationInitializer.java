package com.bluewind.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;

@Configuration
public class MyWebApplicationInitializer implements WebApplicationInitializer{
	
	@Value("${spring.profiles.active}")
	String activeProfile;
	
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    	System.out.println("------------------ active profile is : " + activeProfile);
    	if(activeProfile == null) {
    		servletContext.setInitParameter("spring.profiles.active", "dev");
    	}
    }
}
