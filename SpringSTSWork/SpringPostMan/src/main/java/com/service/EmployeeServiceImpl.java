package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Employee;
import com.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepo repo;

	@Override
	public List<Employee> allEmployee() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return repo.save(emp);
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee emp, int id) {
		// TODO Auto-generated method stub
		emp.setId(id);
		return repo.save(emp);
	}

	@Override
	public Employee employeeById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow();
	}

}
