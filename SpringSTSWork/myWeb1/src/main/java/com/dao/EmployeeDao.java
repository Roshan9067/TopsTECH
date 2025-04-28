package com.dao;

import java.util.List;

import com.model.Employee;

public interface EmployeeDao {
	public int addOrUpdateEmployee(Employee emp);
	public List<Employee> allEmployees();
	public int deleteEmployee(int id);
	public Employee EmployeeById(int id);

}
