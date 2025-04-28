package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Booking;
import com.model.Room;
import java.util.List;


public interface RoomRepo extends JpaRepository<Room, Integer> {

	Room findById(Long id);

	void deleteById(Long id);

}
