package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.RoomDto;
import com.model.Room;
import com.repo.RoomRepo;
import com.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {

  
	
	@Autowired
	RoomService roomService;


	
	
	@PostMapping("/")
	public ResponseEntity<RoomDto> addRoom(@RequestBody Room room) {
		
		Room createRoom = roomService.addRoom(room);
		
		RoomDto dto = new RoomDto();
		dto.setId(createRoom.getId());
		dto.setType(createRoom.getType());
		dto.setRatePerNight(createRoom.getRatePerNight());
		
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<RoomDto>> allRooms(@RequestBody Room room) {
		
		List<Room> viewRooms = roomService.allRooms();
		
		List<RoomDto> dto = new ArrayList<>();
		
		for(Room r: viewRooms) {
			RoomDto dt = new RoomDto();
			dt.setId(r.getId());
			dt.setType(r.getType());
			dt.setRatePerNight(r.getRatePerNight());
			
			dto.add(dt);
			
			
		}
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
		
	}
	
	@PutMapping("/{rid}")
	public ResponseEntity<Room> updateRoom(@RequestBody Room room, @PathVariable ("rid") Long rid) {
		
		Room update = roomService.updateRoom(room, rid);
		
		return new ResponseEntity<>(update, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{did}")
	public void deleteRoom(@PathVariable ("did") Long did) {
		roomService.deleteRoom(did);
		
		
	}

}
