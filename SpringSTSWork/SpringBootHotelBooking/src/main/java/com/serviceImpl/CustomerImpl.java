package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Customer;
import com.repo.CustomerRepo;
import com.service.CustomerService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerImpl implements CustomerService {
	
	@Autowired
	CustomerRepo repo;

	@Override
	public List<Customer> allCustomer() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return repo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer, Long id) {
		// TODO Auto-generated method stub
		customer.setId(id);
		return repo.save(customer);
	}

	@Override
	public Customer customerById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);;
	}

}
