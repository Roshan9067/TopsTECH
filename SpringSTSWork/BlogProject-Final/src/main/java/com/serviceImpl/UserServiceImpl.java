package com.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.payload.UserDto;
import com.repo.UserRepo;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	 ModelMapper mapper;

	@Override
	public List<UserDto> allUser() {
		// TODO Auto-generated method stub
		
		List<User> allUser = userRepo.findAll();
		List<UserDto> dtos = allUser.stream().map(userDto->this.userToDto(userDto)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public UserDto addUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = mapper.map(userDto, User.class);
		User addUser = userRepo.save(user);
		UserDto dto = mapper.map(addUser, UserDto.class);
		return dto;
		
	}

	@Override
	public UserDto updateUser(UserDto userDto, int id) {
		// TODO Auto-generated method stub
		User updateUser = userRepo.findById(id).orElseThrow();
		userDto.setName(updateUser.getName());
		userDto.setAbout(updateUser.getAbout());
		userDto.setPassword(updateUser.getPassword());
		
		return this.userToDto(userRepo.save(updateUser));
	}

	@Override
	public UserDto userById(int id) {
		// TODO Auto-generated method stub
		Optional<User> byId = userRepo.findById(id);
		if(byId.isPresent()) {
			User user = byId.get();
		}
			
		 return this.userToDto(userRepo.findById(id).orElseThrow()); 
	}

	
	
	public User dtoToUser(UserDto userDto) {
		User user = mapper.map(userDto, User.class);
		return user;
		
	}
	
	public UserDto userToDto(User user) {
		UserDto dto = mapper.map(user, UserDto.class); 
		return dto;
		
	}

	@Override
	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(id).orElseThrow();
		userRepo.delete(user);
		
	}
	

}
