package com.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repo.UserRepo;
import com.service.UserService;

@Service
public class UserServiceImpl implements UserService  {
	
	@Autowired
	UserRepo repo;

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	@Override
	public List<User> allUser() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public User updateUser(User user, int id) {
		// TODO Auto-generated method stub
		user.setId(id);
		return repo.save(user);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public User userById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow();
	}

}
