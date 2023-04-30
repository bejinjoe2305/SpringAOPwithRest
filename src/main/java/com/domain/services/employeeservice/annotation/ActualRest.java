package com.domain.services.employeeservice.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.http.HttpMethod;

@Retention(RetentionPolicy.RUNTIME)
public @interface ActualRest {
	
	String url();
	
	HttpMethod httpMethod();
	
	String mediaType();
	
	Class<?> returnType();

}
