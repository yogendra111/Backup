package com.temp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hii");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
	}
	
}
