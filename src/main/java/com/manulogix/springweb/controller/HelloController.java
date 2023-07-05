package com.manulogix.springweb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Value ("${welcome.message}")
	private String welcomeText;
	
	@GetMapping(value= "/hello")
	public String helloWorld()
	{
		
		
		return welcomeText;
	}
}
