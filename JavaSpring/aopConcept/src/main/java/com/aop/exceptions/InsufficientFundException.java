package com.aop.exceptions;

public class InsufficientFundException extends Exception {
	
	public InsufficientFundException(String errorDescription) {
		super(errorDescription);
	}
	
}