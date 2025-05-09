package com.service;
import java.util.List;
import com.Dto.UserDto;
public interface UserService {
	
	public UserDto addUser(UserDto userDto);
	public List<UserDto> allUser();
	public UserDto userById(int id);
	public void deleteUserBy(int id);
	public UserDto updateUser(UserDto userDto,int id);

}
