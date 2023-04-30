package com.domain.services.employeeservice.interfaces;

import java.util.List;

import com.domain.services.employeeservice.model.Todo;

public interface RestcallInterface  {
	
	
	String returnName();
	
	Todo returnTodo();
	
	List<Todo> listalltodos();

}
