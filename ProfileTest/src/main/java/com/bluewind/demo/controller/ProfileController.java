package com.bluewind.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bluewind.demo.component.DevBean;
import com.bluewind.demo.component.NormalBean;
import com.bluewind.demo.component.ProdBean;

@RestController
public class ProfileController {
	@Value("${server.port:8080}")
	int port;
	
	
	@Value("${spring.application.name:bluewind-app}")
	String appName;
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private ConfigurableEnvironment environment;
	
	//Spring boot will not config SpringApplication bean. If we want, if we have to config it manually.
//	@Autowired
//	private SpringApplication application;
	
	@GetMapping("/activeProfile")
	public String getActiveProfile() {
		System.out.println("port = " + port);
		System.out.println("appName = " + appName);
		
		return "profile = " + Arrays.asList(environment.getActiveProfiles());
	}
	
	@GetMapping("/changeProfile")
	public List<String> changeProfile(@RequestParam(name="profile", defaultValue = "dev") String profile) {
		environment.setActiveProfiles(profile);
		return Arrays.asList(environment.getActiveProfiles());
	}
	
	/*
	 * We can change the active profile after the springboot application started (as the /changeProfile api does),
	 * but that will neither change the bean configuration (beans with @Profile annotation)
	 * nor affect which profile-specific properties file is used, 
	 * because those are already done before the springboot application' start completed.
	 */
	@RequestMapping(value="/showBeansDynamically", method=RequestMethod.GET)
	public String showBeansDynamically() {
		NormalBean normalBean = context.getBean(NormalBean.class);
		DevBean devBean = (DevBean)context.getBean(DevBean.class);
		ProdBean prodBean = (ProdBean)context.getBean(ProdBean.class);
		
		return "Avaible beans are : " + normalBean + ", " + devBean + ", " + prodBean;
		
	}
}
