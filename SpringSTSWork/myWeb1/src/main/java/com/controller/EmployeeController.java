package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.model.Employee;
import com.service.EmployeeService;




@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("employee",new Employee());
		model.addAttribute("employees",employeeService.allEmployees());
		return "index";
		
	}
	

	@PostMapping("/addEmployee")
	public String addStudent(@ModelAttribute("employee") Employee emp,Model model)
	{
		    model.addAttribute("employee",emp);
			model.addAttribute("employees",employeeService.allEmployees());
			int i = employeeService.addOrUpdateEmployee(emp);
			return "redirect:/";
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("did") int did)
	{
		employeeService.deleteEmployee(did);
		return "redirect:/";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam("eid") int eid,Model model)
	{
		model.addAttribute("employee",employeeService.EmployeeById(eid));
		model.addAttribute("employees",employeeService.allEmployees());
		return "index";
		
	}
}
