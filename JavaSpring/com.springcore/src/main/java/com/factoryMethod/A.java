package com.factoryMethod;

public class A {
	private static final A obj = new A();
	private static final B obj1 = new B();

	private A() {
		System.out.println("private constructor");
	}

	public static A getA() {
		System.out.println("factory method ");
		return obj;
	}
	public B getB() {
		System.out.println("factory method B");
		return obj1;
	}

	public void msg() {
		System.out.println("hello user");
	}
}
