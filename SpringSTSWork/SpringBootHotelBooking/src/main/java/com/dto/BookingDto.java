package com.dto;

import java.time.LocalDate;






public class BookingDto {
	
	private Long id;
	private LocalDate cheakInTime;
	private LocalDate cheakOutTime;
	private CustomerDto customerDto;
	private RoomDto roomDto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getCheakInTime() {
		return cheakInTime;
	}

	public void setCheakInTime(LocalDate cheakInTime) {
		this.cheakInTime = cheakInTime;
	}

	public LocalDate getCheakOutTime() {
		return cheakOutTime;
	}

	public void setCheakOutTime(LocalDate cheakOutTime) {
		this.cheakOutTime = cheakOutTime;
	}

	public CustomerDto getCustomerDto() {
		return customerDto;
	}

	public void setCustomerDto(CustomerDto customerDto) {
		this.customerDto = customerDto;
	}

	public RoomDto getRoomDto() {
		return roomDto;
	}

	public void setRoomDto(RoomDto roomDto) {
		this.roomDto = roomDto;
	}


	
	
	
	

}
