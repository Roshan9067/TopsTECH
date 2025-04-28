package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Booking;
import com.repo.BookingRepo;
import com.service.BookingService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookingImpl implements BookingService{
	
	@Autowired
	BookingRepo repo;

	@Override
	public List<Booking> allrBooking() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Booking addBooking(Booking booking) {
		// TODO Auto-generated method stub
		return repo.save(booking);
	}

	@Override
	public Booking updateBooking(Booking booking, Long id) {
		// TODO Auto-generated method stub
		booking.setId(id);
		return repo.save(booking);
	}

	@Override
	public Booking bookingById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void deleteBooking(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
