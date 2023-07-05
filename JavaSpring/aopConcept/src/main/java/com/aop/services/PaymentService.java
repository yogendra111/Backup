package com.aop.services;

import com.aop.exceptions.InsufficientFundException;
import com.entity.Account;

public interface PaymentService {
	public String withdraw(Account acc, int withdrawAmount) throws InsufficientFundException;
}
