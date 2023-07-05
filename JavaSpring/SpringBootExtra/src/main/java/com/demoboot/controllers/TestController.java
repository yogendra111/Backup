package com.demoboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoboot.conditional.ConditionProfile;
import com.demoboot.entities.Greeting;

@RestController
public class TestController {
	
	@Autowired
	Greeting greeting;
	
	@Autowired
	ConditionProfile conditionProfile;

	@GetMapping("/home")
	public String home() {
		return greeting.helloBean();
	}

	@GetMapping("/welcome")
	public String welcome() {
		return conditionProfile.welcome();
	}
	
}
