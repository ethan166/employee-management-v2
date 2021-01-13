package com.hteiktan.util;

import java.text.DateFormat;
import java.util.List;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.hteiktan.dto.EmployeeDTO;

@Component
@Aspect
public class LoggingAspect {
	private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
//	@AfterThrowing("execution(* com.hteiktan.service.EmployeeServiceImpl.getAllEmployee(..))")
//	public void logAfterThrowingAdvice(JoinPoint joinPoint) {
//		logger.info("In After throwing Advice,Joinpoint signature : {}", joinPoint.getSignature());
//	}
//	
//	@AfterThrowing(pointcut = "execution(* com.hteiktan.service.EmployeeServiceImpl.getAllEmployee(..))", throwing = "exception")
//	public void logAfterThrowingAdviceDetails(JoinPoint joinPoint, Exception exception) {
//		logger.info("In After throwing Advice details,Joinpoint signature : {}", joinPoint.getSignature());
//		logger.error(exception.getMessage(), exception);
//	}
//	
//	@After("execution(* com.hteiktan.service.EmployeeServiceImpl.getAllEmployee(..))")
//	public void logAfterAdvice(JoinPoint joinPoint)
//	{
//		logger.info("In After Advice, Joinpoint signature : {}", joinPoint.getSignature());
//		long time = System.currentTimeMillis();
//		String date = DateFormat.getDateTimeInstance().format(time);
//		logger.info("Report generated at time{}", date);
//				
//	}
//	
//	@Before("execution(* com.hteiktan.service.EmployeeServiceImpl.getAllEmployee(..))")
//	public void logBeforeAdvice(JoinPoint joinPoint) {
//		logger.info("In Before Advice, Joinpoint signature : {}", joinPoint.getSignature());
//		long time = System.currentTimeMillis();
//		String date = DateFormat.getDateTimeInstance().format(time);
//		logger.info("Report generated at time{}", date);
//	}
//	
//	@AfterReturning(pointcut = "execution(* com.hteiktan.service.EmployeeServiceImpl.getAllEmployee(..))", returning="result")
//	public void logAfterReturningDetails(JoinPoint joinPoint, List<EmployeeDTO> result)
//	{
//		logger.info("In AfterReturning Advice with return value, Joinpoint: {}", joinPoint.getSignature());
//		System.out.println(result);
//		long time = System.currentTimeMillis();
//		String date = DateFormat.getDateTimeInstance().format(time);
//		logger.info("Report generated at time:{}", date);
//	}
	
	@Around("execution(* com.hteiktan.service.EmployeeServiceImpl.getAllEmployee(..))")
	public Object logAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Before proceeding part of the Around advice");
		Object cust = joinPoint.proceed();
		System.out.println("After proceeding part of the Around advice");
		return cust;
	}
}
	
	
	
	

