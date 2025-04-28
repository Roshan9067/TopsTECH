package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Room;
import com.repo.RoomRepo;
import com.service.RoomService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RoomImpl implements RoomService {
	
	@Autowired
	RoomRepo repo;

	@Override
	public List<Room> allRooms() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Room addRoom(Room room) {
		// TODO Auto-generated method stub
		return repo.save(room);
	}


	@Override
	public Room updateRoom(Room room, Long id) {
		// TODO Auto-generated method stub
		room.setId(id);
		return repo.save(room);
	}

	@Override
	public Room roomById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void deleteRoom(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

}
