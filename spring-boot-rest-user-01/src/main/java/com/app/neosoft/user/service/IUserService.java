package com.app.neosoft.user.service;

import java.util.List;

import com.app.neosoft.user.model.User;

public interface IUserService {
	
	User saveUser(User user);
	List<User> getAllUsers();
	User getUserById(Integer userId);
	void deleteUserById(Integer userId);
	User updateUserById(Integer userId,User userToUpdate);
	List<User> getUserByNameLike(String searchString);
//	List<User> getUserByPincode(Integer searchPincode);

}
