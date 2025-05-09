package com.Controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.Dto.UserDto;
import com.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/")
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
		UserDto user = service.addUser(userDto);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> allUser() {
		List<UserDto> allUser = service.allUser();
		return new ResponseEntity<>(allUser, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable ("id") int id) {
		
		UserDto updateUser = service.updateUser(userDto, id);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable ("id") int id) {
		service.deleteUserBy(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> name(@PathVariable ("id") int id) {
		UserDto userById = service.userById(id);
		return new ResponseEntity<>(userById, HttpStatus.OK);
		
	}

}
