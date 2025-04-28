package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.BookingDto;
import com.dto.CustomerDto;
import com.model.Booking;
import com.model.Customer;
import com.service.BookingService;
import com.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/")
	public ResponseEntity<CustomerDto> addCustomer(@RequestBody Customer customer) {
		
		Customer addCustomer = customerService.addCustomer(customer);
	
		
		CustomerDto dto = new CustomerDto();
		dto.setId(addCustomer.getId());
		dto.setFname(addCustomer.getFname());
		dto.setLname(addCustomer.getLname());
		dto.setEmail(addCustomer.getEmail());
		dto.setPhone(addCustomer.getPhone());
		
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CustomerDto>> viewAllBookings(@RequestBody Customer customer) {
		
		List<Customer> viewAllBookings = customerService.allCustomer();
		
		List<CustomerDto> dto = new ArrayList<>();
		
		for(Customer c : viewAllBookings) {
			
			CustomerDto dt = new CustomerDto();
			
			dt.setId(c.getId());
			dt.setFname(c.getFname());
			dt.setLname(c.getLname());
			dt.setEmail(c.getEmail());
			dt.setPhone(c.getPhone());
			
			dto.add(dt);
		}
				
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PutMapping("/{uid}")
	public ResponseEntity<Customer> updateBooking(@RequestBody Customer customer, @PathVariable ("uid") Long uid) {
		
		Customer updateCustomer = customerService.updateCustomer(customer, uid);
		return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{did}")
	public void deleteCustomer(@PathVariable ("did") Long did) {
		
		customerService.deleteCustomer(did);
		
	}
	
	

}
