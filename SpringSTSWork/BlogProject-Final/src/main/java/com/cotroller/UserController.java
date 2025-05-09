package com.cotroller;

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

import com.payload.UserDto;
import com.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto dto) {
		
		UserDto createUser = userService.addUser(dto);
		return new ResponseEntity<>(createUser, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> allUser() {
		
		List<UserDto> dto = userService.allUser();
		return new ResponseEntity<>(dto, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> UserByid(@PathVariable ("id") int id) {
		
		UserDto dto = userService.userById(id);
		return new ResponseEntity<>(dto, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable ("id") int id) {
		userService.deleteUserById(id);
		
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto dto,@PathVariable ("id") int id) {
		
		UserDto update = userService.updateUser(dto, id);
		return new ResponseEntity<>(update, HttpStatus.OK);
		
	}
	
}
