package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer> {

	public Booking findById(Long id);

	public void deleteById(Long id);

}

