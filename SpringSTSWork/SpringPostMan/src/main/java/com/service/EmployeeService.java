package com.service;

import java.util.List;

import com.model.Employee;

public interface EmployeeService {
	
	public List<Employee> allEmployee();
	public Employee addEmployee(Employee emp);
	public void deleteEmployee(int id);
	public Employee updateEmployee(Employee emp, int id);
	public Employee employeeById(int id);

}
