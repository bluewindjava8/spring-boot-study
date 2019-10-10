package com.example.demo.controller;


import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Greeting;

@Controller
public class TestController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	//@RequestMapping(value= "/greeting", produces= {MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE})
	@RequestMapping(value= "/greeting")
	@ResponseBody
	public Greeting greeting(@RequestParam(value="name", defaultValue="world")String name, HttpServletRequest req) {
		System.out.println("Invoked in " + req.getMethod());
		Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
		
		return greeting;
	}

}
