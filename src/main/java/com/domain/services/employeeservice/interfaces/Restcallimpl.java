package com.domain.services.employeeservice.interfaces;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import com.domain.services.employeeservice.annotation.ActualRest;
import com.domain.services.employeeservice.annotation.Restcall;
import com.domain.services.employeeservice.model.Todo;

@Component
public class Restcallimpl implements RestcallInterface{

	@Restcall
	public String returnName() {
		// TODO Auto-generated method stub
		return "impl";
	}

	@ActualRest(httpMethod = HttpMethod.GET, mediaType = "JSON", url = "https://jsonplaceholder.typicode.com/todos/1", returnType = Todo.class)
	public Todo returnTodo() {
		// TODO Auto-generated method stub
		return null;
	}

	@ActualRest(httpMethod = HttpMethod.GET, mediaType = "JSON", url = "https://jsonplaceholder.typicode.com/todos", returnType = Todo.class)
	public List<Todo> listalltodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
