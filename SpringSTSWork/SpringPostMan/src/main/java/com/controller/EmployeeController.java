package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;
import com.service.EmployeeService;

//@Controller
@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employee")
	//@ResponseBody
	public List<Employee> viewEmployee() {
		
		List<Employee> employees = employeeService.allEmployee();
		return employees;
	}

	@PostMapping("/employee")
    public Employee addEmployees(@RequestBody Employee emp) {
	Employee createEmployee = employeeService.addEmployee(emp);
	return createEmployee ;
	
   }
	
	@DeleteMapping("/employee/{id}")
	public void deletEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
	}
		
	
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@RequestBody Employee emp,@PathVariable  int id) {
	Employee 	update = employeeService.updateEmployee(emp, id);
    return update;
		
	}
	
	@PatchMapping("/employee/{id}")
	public Employee patchEmployee(@RequestBody Map<String, Object> update, @PathVariable int id) {
		Employee eid = employeeService.employeeById(id);
		
		if(update.containsKey("name")) {
			eid.setName((String) update.get("name"));
		}
		if(update.containsKey("email")) {
			eid.setEmail((String) update.get("email"));
		}
		if(update.containsKey("age")) {
			eid.setAge(Integer.parseInt((String) update.get("age")));
		}
		


		Employee emp = employeeService.updateEmployee(eid, id);
		return emp;
		
	}
	
	
		
}

