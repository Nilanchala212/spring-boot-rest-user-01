package com.app.neosoft.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.neosoft.user.model.User;
import com.app.neosoft.user.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@PostMapping("/createUser")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User saveUser = userService.saveUser(user);
		return new ResponseEntity<>(saveUser, HttpStatus.CREATED);

	}
	@GetMapping("/allUser")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> userList=userService.getAllUsers();
		return new ResponseEntity<>(userList,HttpStatus.OK);
		
	}
	@GetMapping("/getById/{userId}")
	public ResponseEntity<User> getUserById(
			@PathVariable("userId") final Integer userId){
		User user=userService.getUserById(userId);	
		return new ResponseEntity<>(user,HttpStatus.OK);
		
	}
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUserById(
			@PathVariable("userId") Integer userId){
		userService.deleteUserById(userId);
		return new ResponseEntity<>("Record Deleted Successfully",HttpStatus.OK);
		
	}
	@PutMapping("/updateById/{userId}")
	public ResponseEntity<User> updateUserById(@PathVariable("userId") Integer userId,
			@RequestBody User userToUpdate){
		User updateUser=userService.updateUserById(userId, userToUpdate);
		return new ResponseEntity<> (updateUser,HttpStatus.OK);
	}
	@GetMapping("/search/{searchString}")
	public ResponseEntity<List<User>> getUserByName(
			@PathVariable("searchString") String searchString){
		List<User> usersList=userService.getUserByNameLike(searchString);
		return new ResponseEntity<>(usersList,HttpStatus.OK);
		
	}
	/*
	 * @GetMapping("/search/{searchPincode}") public ResponseEntity<List<User>>
	 * getUserByPincode(
	 * 
	 * @PathVariable("searchPincode") Integer searchPincode){ List<User>
	 * userpin=userService.getUserByPincode(searchPincode); return new
	 * ResponseEntity<>(userpin,HttpStatus.OK);
	 * 
	 * }
	 */

}
