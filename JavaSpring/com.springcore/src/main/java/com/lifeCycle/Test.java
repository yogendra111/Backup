package com.lifeCycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.PostMapping;

//public class Test implements InitializingBean, DisposableBean{
public class Test {

	public Test() {
		System.out.println("Test constructor");
	}
	public void init() {
		System.out.println("Init Method");
	}
	public void destroy() {
		System.out.println("Destroy Method");
	}
//	public void afterPropertiesSet() throws Exception {
//		
//	}

}
