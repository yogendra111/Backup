package com.aop.services;

import com.aop.exceptions.InsufficientFundException;
import com.entity.Account;

public class PaymentServiceImpl implements PaymentService{

	@Override
	public String withdraw(Account acc, int withdrawAmount) throws InsufficientFundException {
		
		String status;
		if(acc.getBalance() >= withdrawAmount) {
			acc.setBalance(acc.getBalance() - withdrawAmount);
			System.out.println(withdrawAmount + " debitted from Account");
			status="Sucess";
		}else {
			status="Failed";
			throw new InsufficientFundException("Funds Are Not Sufficient in Your Account");
		}
		return status;
	}

}
