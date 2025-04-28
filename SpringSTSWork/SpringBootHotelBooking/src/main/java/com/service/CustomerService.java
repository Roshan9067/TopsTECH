package com.service;

import java.util.List;

import com.model.Customer;


public interface CustomerService {
	
	public List<Customer> allCustomer();
	public Customer addCustomer(Customer customer);
	public Customer customerById(Long id);
	public void deleteCustomer(Long id);
	public Customer updateCustomer(Customer customer, Long id);
	

}
