package com.dto;




public class RoomDto {
	
	
	private Long id;
	private String Type;
	private double ratePerNight;
	
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getType() {
		return Type;
	}


	public void setType(String type) {
		Type = type;
	}


	public double getRatePerNight() {
		return ratePerNight;
	}


	public void setRatePerNight(double ratePerNight) {
		this.ratePerNight = ratePerNight;
	}



	
}
