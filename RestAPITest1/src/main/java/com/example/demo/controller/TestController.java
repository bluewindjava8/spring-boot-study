package com.example.demo.controller;


import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Greeting;
import com.example.demo.service.TestService;

@Controller
@RequestMapping("/bluewind")
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	TestService testService;

	
	//@RequestMapping(value= "/greeting", produces= {MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE})
	//@RequestMapping(value= "/greeting", produces= {MediaType.APPLICATION_JSON_VALUE})
	@RequestMapping(value= "/greeting", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Greeting greeting(@RequestParam(value="name", defaultValue="world")String name, HttpServletRequest req) {
		System.out.println("Invoked in " + req.getMethod());
		Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
		logger.info("this is in TestController.greeting()");
		say();
		logger.info(req.getRequestURL().toString());
		
		return greeting;
	}

	private void say() {
		logger.info("this is in TestController.say()");
		testService.hello();
		
	}
}
