package com.serviceImpl;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dto.UserDto;
import com.exceptionHandle.ResourceNotFoundException;
import com.model.User;
import com.repo.UserRepo;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo repo;
	

	@Autowired
	ModelMapper mapper;

	@Override
	public UserDto addUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User add = mapper.map(userDto, User.class);
		User save = repo.save(add);
		return mapper.map(save, UserDto.class);
	}

	@Override
	public List<UserDto> allUser() {
		// TODO Auto-generated method stub
		List<User> all = repo.findAll();
		List<UserDto> collect = all.stream().map(e->mapper.map(e,UserDto.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public UserDto userById(int id) {
		// TODO Auto-generated method stub
		User user = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
		return mapper.map(user, UserDto.class);
	}

	@Override
	public void deleteUserBy(int id) {
		// TODO Auto-generated method stub
		User user = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
		repo.delete(user);
	}


	@Override
	public UserDto updateUser(UserDto userDto, int id) {
		// TODO Auto-generated method stub
		User user = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		User update = mapper.map(user, User.class);
		User save = repo.save(update);
		return mapper.map(save, UserDto.class);
		
		
	}

}
