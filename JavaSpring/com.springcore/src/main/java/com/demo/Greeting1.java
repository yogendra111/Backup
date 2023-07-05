package com.demo;

public class Greeting1 {
	int i;

	public Greeting1() {
	}
	public Greeting1(int i) {
		super();
		this.i = i;
	}

	public void setI(int i) {
		this.i = i;
	}

	void print() {
		System.out.println("hello greeting1 " + i);
	}

}
