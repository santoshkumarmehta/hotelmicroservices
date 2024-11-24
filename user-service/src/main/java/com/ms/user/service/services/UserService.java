package com.ms.user.service.services;

import java.util.List;

import com.ms.user.service.entities.User;

public interface UserService {

	
	//create User
	User saveUser(User user);
	
	//get All Users
	List<User> getAllUsers();
	
	// get user by ID
	User getUserID(Long stringId);
}
