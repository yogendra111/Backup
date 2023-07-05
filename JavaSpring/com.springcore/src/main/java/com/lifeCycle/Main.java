package com.lifeCycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/lifeCycle/ApplicationContext.xml");
		context.getBean("bean1");
		context.close();
//		context.registerShutdownHook();
	}

}
