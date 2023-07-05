package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.exceptions.InsufficientFundException;
import com.aop.services.PaymentService;
import com.entity.Account;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("com/aop/config.xml");
        Account acc = (Account) context.getBean("account");
        PaymentService pay = context.getBean("payment", PaymentService.class);
        
        try {
			pay.withdraw(acc, 4000);
		} catch (InsufficientFundException e) {
			
		}
    }
}
