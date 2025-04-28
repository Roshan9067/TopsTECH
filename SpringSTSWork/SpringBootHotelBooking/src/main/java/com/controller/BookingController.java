package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.BookingDto;
import com.dto.CustomerDto;
import com.dto.RoomDto;
import com.model.Booking;
import com.service.BookingService;
import com.service.CustomerService;
import com.service.RoomService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	RoomService roomService;
	
	@PostMapping("/{cid}/{rid}")
	public ResponseEntity<BookingDto> addBookings(@RequestBody Booking booking, @PathVariable ("cid") Long cid, @PathVariable ("rid") Long rid) {
		
		booking.setRoom(roomService.roomById(rid));
		booking.setCustomer(customerService.customerById(cid));
		
		
		Booking createBooking = bookingService.addBooking(booking);
		
		BookingDto dto = new BookingDto();
		dto.setId(createBooking.getId());
		dto.setCheakInTime(createBooking.getCheakInTime());
		dto.setCheakOutTime(createBooking.getCheakOutTime());
		
		CustomerDto cdto = new CustomerDto();
		cdto.setId(createBooking.getCustomer().getId());
		cdto.setFname(createBooking.getCustomer().getFname());
		cdto.setLname(createBooking.getCustomer().getLname());
		cdto.setEmail(createBooking.getCustomer().getEmail());
		cdto.setPhone(createBooking.getCustomer().getPhone());
		dto.setCustomerDto(cdto);
		
		
		RoomDto rdto = new RoomDto();
		rdto.setId(createBooking.getRoom().getId());
		rdto.setType(createBooking.getRoom().getType());
		rdto.setRatePerNight(createBooking.getRoom().getRatePerNight());
		dto.setRoomDto(rdto);
		
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
				
				
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<BookingDto>> viewAllBooking() {
		
		List<Booking> allBookings = bookingService.allrBooking();
		
		List<BookingDto> dto = new ArrayList<>();
		
		for(Booking b : allBookings) {
			
			BookingDto bdto = new BookingDto();
			
			bdto.setId(b.getId());
			bdto.setCheakInTime(b.getCheakInTime());
			bdto.setCheakOutTime(b.getCheakOutTime());
			
			
			CustomerDto cdto = new CustomerDto();
			cdto.setId(b.getCustomer().getId());
			cdto.setFname(b.getCustomer().getFname());
			cdto.setLname(b.getCustomer().getLname());
			cdto.setEmail(b.getCustomer().getEmail());
			cdto.setPhone(b.getCustomer().getPhone());
			
			RoomDto rdto = new RoomDto();
			rdto.setId(b.getRoom().getId());
			rdto.setType(b.getRoom().getType());
			rdto.setRatePerNight(b.getRoom().getRatePerNight());
			
			dto.add(bdto);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	

}
