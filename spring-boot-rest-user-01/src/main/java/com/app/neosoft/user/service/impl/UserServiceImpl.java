package com.app.neosoft.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.neosoft.user.model.User;
import com.app.neosoft.user.repo.UserRepository;
import com.app.neosoft.user.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUserById(Integer userId) {
		return userRepository.findById(userId).get();
	}

	@Override
	public void deleteUserById(Integer userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public User updateUserById(Integer userId, User userToUpdate) {
		User userFromDb=userRepository.findById(userId).get();
		userFromDb.setName(userToUpdate.getName());
		userFromDb.setPinCode(userToUpdate.getPinCode());
		userFromDb.setSurName(userToUpdate.getSurName());
		return userRepository.save(userFromDb);
	}

	@Override
	public List<User> getUserByNameLike(String searchString) {
		return userRepository.findByNameLike(searchString);
	}

	/*
	 * @Override public List<User> getUserByPincode(Integer searchPincode) { return
	 * userRepository.findByPincodeLike(searchPincode); }
	 */

}
