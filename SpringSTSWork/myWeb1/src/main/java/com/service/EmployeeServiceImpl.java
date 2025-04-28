package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeDao;
import com.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao dao;

	@Override
	public int addOrUpdateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return dao.addOrUpdateEmployee(emp);
	}

	@Override
	public List<Employee> allEmployees() {
		// TODO Auto-generated method stub
		return dao.allEmployees();
	}

	@Override
	public int deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return dao.deleteEmployee(id);
	}

	@Override
	public Employee EmployeeById(int id) {
		// TODO Auto-generated method stub
		return dao.EmployeeById(id);
	}


}
