package com.demoboot.entities;

import org.springframework.stereotype.Component;

@Component
public class Welcome {

	String welcome() {
		return "Welcome Bro";
	}
	
}
