package com.controller;

import java.util.ArrayList;
import java.util.List;
import com.serviceImpl.UserServiceImpl;
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

import com.dto.UserDto;
import com.model.User;
import com.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userServiceImpl;
	
	@Autowired
	UserService userService;


    UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }
	
	
	@PostMapping("/")
	public ResponseEntity<UserDto> addUser(@RequestBody User user) {
		
		User addUser = userService.addUser(user);
		
		UserDto dto = new UserDto();
		
		dto.setId(addUser.getId());
		dto.setName(addUser.getName());
		dto.setEmail(addUser.getEmail());
		dto.setPassword(addUser.getPassword());
		
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
			
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> viewAllUsers() {
		
		List<User> allUser = userService.allUser();
		
		List<UserDto> dto = new ArrayList<>();
		
		for(User u : allUser) {
			
			UserDto dt = new UserDto();
			
			dt.setId(u.getId());
			dt.setName(u.getName());
			dt.setEmail(u.getEmail());
			dt.setPassword(u.getPassword());
			
			dto.add(dt);
			
			
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable ("id") int id) {
		
		User update = userService.updateUser(user, id);
		return new ResponseEntity<>(update, HttpStatus.OK);
		
	}
	
	public void deleteUser(@PathVariable ("id") int id) {
		
		userService.deleteUser(id);
		
	}
	

}
