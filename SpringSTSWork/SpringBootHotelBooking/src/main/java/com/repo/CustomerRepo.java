package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Booking;
import com.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	public Customer findById(Long id);

	public void deleteById(Long id);

}
