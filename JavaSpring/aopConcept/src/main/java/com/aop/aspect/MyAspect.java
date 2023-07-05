package com.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.aop.exceptions.InsufficientFundException;
import com.entity.Account;

@Aspect
public class MyAspect {

	@Before("execution(String com.aop.services.PaymentServiceImpl.withdraw(..))")
	public void printBefore(JoinPoint jp) {
		Object[] args = jp.getArgs();
		Account acc = (Account) args[0];
		System.out.println("Payment Initiated, Initial Balance: " + acc.getBalance());
	}

	@After("execution(* com.aop.services.PaymentServiceImpl.withdraw(..))")
	public void printAfter(JoinPoint jp) {
		Object[] args = jp.getArgs();
		Account acc = (Account) args[0];
		System.out.println("Payment Completed, Final Balance: " + acc.getBalance());
	}

	@AfterReturning(pointcut = "execution(* com.aop.services.PaymentServiceImpl.*(..))", returning = "status")
	public void printAfterReturning(JoinPoint jp, String status) {
		System.out.println("After Returning Advice : Transaction Status : " + status);
	}

	@Around("execution(* com.aop.services.PaymentServiceImpl.*(..))")
	public void printAround(ProceedingJoinPoint pjp) {
		System.out.println("Around Advice : Before " + pjp.getSignature().getName() + " Method Execution");
		String statu = "";
		try {
			statu = (String) pjp.proceed();
		} catch (Throwable e) {
		}
		System.out.println("Around Advice : After : Transaction Status : " + statu);
	}

	@AfterThrowing(pointcut = "execution(* com.aop.services.PaymentServiceImpl.*(..))", throwing = "e")
	public void printAfterThrowing(JoinPoint jp, InsufficientFundException e) {
		System.out.println("After Throwing Advice : Exception : " + e.getClass().getName() + " In the Transaction : "
				+ e.getMessage());
	}

}
