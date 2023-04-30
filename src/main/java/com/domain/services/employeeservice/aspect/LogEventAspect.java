package com.domain.services.employeeservice.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.domain.services.employeeservice.model.Employee;

@Aspect
public class LogEventAspect {
	
	@Around("@annotation(com.domain.services.employeeservice.annotation.LogEvent)")
	public Object aroundAnnotation(ProceedingJoinPoint pjp) throws Throwable
	{
		
		System.out.println("Before executing");
		Employee emp = (Employee)pjp.proceed();
		System.out.println("After executing");
		return emp;
	}
	
	

}
