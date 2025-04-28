package com.service;

import java.util.List;

import com.model.Employee;

public interface EmployeeService {
	
	public int addOrUpdateEmployee(Employee emp);
	public List<Employee> allEmployees();
	public int deleteEmployee(int id);
	public Employee EmployeeById(int id);
}
