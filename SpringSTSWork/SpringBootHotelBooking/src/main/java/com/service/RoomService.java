package com.service;

import java.util.List;

import com.model.Room;

public interface RoomService {
	
	public List<Room> allRooms();
	public Room addRoom(Room room);
	public Room updateRoom(Room room,Long id);
	public Room roomById(Long id);
	public void deleteRoom(Long id);
	

}
