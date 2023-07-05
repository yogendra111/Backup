package com.firstproject.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//@SpringBootApplication
public class FirstProjectApplication {

	public static void main(String[] args) {
//		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml")) {
//			Student s = (Student) context.getBean("e");
//			s.show();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Employee e = (Employee) context.getBean("emp");
		System.out.println(e);
	}

}
