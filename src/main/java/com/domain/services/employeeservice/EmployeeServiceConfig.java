package com.domain.services.employeeservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.domain.services.employeeservice.aspect.ActualRestAspect;
import com.domain.services.employeeservice.aspect.LogEventAspect;
import com.domain.services.employeeservice.aspect.RestCallAspect;

@Configuration
public class EmployeeServiceConfig {
	
	@Bean
	public LogEventAspect getLogEventAspect() {
		
		return new LogEventAspect();
		
	}
	@Bean
	public RestCallAspect getRestCallAspect() {
		
		return new RestCallAspect();
		
	}
	
	@Bean 
	public ActualRestAspect getActualRest() {
		return new ActualRestAspect();
	}
}
