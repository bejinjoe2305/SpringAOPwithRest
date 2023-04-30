package com.domain.services.employeeservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.services.employeeservice.annotation.LogEvent;
import com.domain.services.employeeservice.interfaces.RestcallInterface;
import com.domain.services.employeeservice.model.Employee;
import com.domain.services.employeeservice.model.Todo;

@RestController
public class EmployeeSalaryController {
	
	@Autowired
	RestcallInterface rc;
	
	@GetMapping("/employee")
	@LogEvent
	public Employee getEmployee()
	{
		Employee emp = new Employee();
		emp.setName("Bejin");
		emp.setAge(29);
		emp.setEmailId("bejin1993@gmail.com");
		emp.setSalary(new Double(20000));
		
		return emp;
	}
    
	@GetMapping("/")
	public String getrestcall()
	{
		return rc.returnName();
	}
	
	@GetMapping("/todo")
	public Todo getTodo()
	{
		return rc.returnTodo();
	}
	
	@GetMapping("/todos")
	public List<Todo> getTodos()
	{
		return rc.listalltodos();
	}
}
