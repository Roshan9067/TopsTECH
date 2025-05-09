package com.service;

import java.util.List;

import com.model.User;

public interface UserService {
	
	public User addUser(User user);
	public List<User> allUser();
	public User updateUser(User user, int id);
	public void deleteUser(int id);
	public User userById(int id);

}
