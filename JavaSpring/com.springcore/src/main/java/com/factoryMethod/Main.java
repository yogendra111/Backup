package com.factoryMethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
	    ApplicationContext context=new ClassPathXmlApplicationContext("context.xml");  
	    A a=(A)context.getBean("a");  
//	    B a = (B) context.getBean("a");
	    a.msg();
	}

}
