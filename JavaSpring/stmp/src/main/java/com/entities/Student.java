package com.entities;

import javax.validation.constraints.NotBlank;

public class Student {
	
	@NotBlank
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student() {
		super();
	}

	public Student(String name) {
		super();
		this.name = name;
	}
	
}
