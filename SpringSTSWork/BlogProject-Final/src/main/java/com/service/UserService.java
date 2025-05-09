package com.service;

import java.util.List;

import com.payload.UserDto;

public interface UserService {
	
	public List<UserDto> allUser();
	public UserDto addUser(UserDto userDto);
	public UserDto updateUser(UserDto userDto , int id);
	public UserDto userById(int id);
	public void deleteUserById(int id);

}
