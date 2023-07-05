package com.main;

import org.springframework.beans.factory.annotation.Value;

public class ConditionalMain {
	
	@Value("${con.con}")
	static String kon;

	public static void main(String[] args) {
		System.out.println("Hey "+ kon);
		
	}
	
}
