package com.service;

import java.util.List;

import com.model.Booking;


public interface BookingService {
	
	public List<Booking> allrBooking();
	public Booking addBooking(Booking booking);
	public Booking updateBooking(Booking booking,Long id);
	public Booking bookingById(Long id);
	public void deleteBooking(Long id);
	

}
