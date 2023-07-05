package com.demo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Main{
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//		Employee emp = (Employee) context.getBean("employee1");
//		System.out.println(emp);
		Greeting g = (Greeting) context.getBean("g");
		System.out.println("+++++++++++++++++++");
		g.display();
	}
}