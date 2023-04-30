package com.domain.services.employeeservice.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

@Aspect
public class RestCallAspect {
	
	
	
	@Around("@annotation(com.domain.services.employeeservice.annotation.Restcall)")
	public String returnObjectWithoutProceeeding(ProceedingJoinPoint pjp)
	{
		return "bejin";
	}

}
