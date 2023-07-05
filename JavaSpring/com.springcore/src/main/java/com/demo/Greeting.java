package com.demo;

public class Greeting {
	Greeting1 g1;

	public Greeting() {
	}
	public Greeting(Greeting1 g1) {
		super();
		System.out.println("Welcome greeting.");
		this.g1 = g1;
	}

//	public void setG1(Greeting1 g1) {
//		this.g1 = g1;
//	}
	

	void print() {
		System.out.println("hello greeting");
	}

	void display() {
		print();
		g1.print();
	}


}
