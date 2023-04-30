package com.domain.services.employeeservice.aspect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URI;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import com.domain.services.employeeservice.annotation.ActualRest;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
public class ActualRestAspect {
	
    RestTemplate restTemplate;
    
    public ActualRestAspect() {
    	this.restTemplate = new RestTemplate();
    }
	
	@Around("@annotation(com.domain.services.employeeservice.annotation.ActualRest)")
	public Object getTodos(ProceedingJoinPoint joinPoint)
	{
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		Method method = methodSignature.getMethod();
		
		Annotation[] annotations = method.getAnnotations();
		String url = null;
		HttpMethod httpMethod = null;
		//final Class<?> clazz = null;
		String mediaType = null;
		
        for(Annotation annotation : annotations)
        {
        	if(annotation instanceof ActualRest)
        	{
        		url = ((ActualRest) annotation).url();
        		httpMethod = ((ActualRest) annotation).httpMethod();
        		//final Class<?> clazz = ((ActualRest) annotation).returnType();
        		mediaType = ((ActualRest) annotation).mediaType();
        		
        		//RestTemplate restTemplate = new RestTemplate();
        		URI uri = URI.create(url);
        		return restTemplate.execute(uri, httpMethod, new RequestCallback() {
        		    public void doWithRequest(ClientHttpRequest request) throws IOException {
        		        
        		    }
        		},response -> {
        		    ObjectMapper objectMapper = new ObjectMapper();
        		    InputStream inputStream = response.getBody();
        		    Object post = objectMapper.readValue(inputStream, method.getReturnType());
        		    return post;
        		});

        		

        	}
        }

		return null;
	}

}
