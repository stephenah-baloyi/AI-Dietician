package com.dietplan.artificialintelligencedietician.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dietplan.artificialintelligencedietician.model.User;
import com.dietplan.artificialintelligencedietician.repository.UserRepository;
import com.dietplan.artificialintelligencedietician.service.ResourceNotFoundException;
import com.dietplan.artificialintelligencedietician.service.UserService;

@RestController
@RequestMapping("/app/")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
		// create user
		@PostMapping("/register")
		public User createUser(@RequestBody User user) {
			
			String email = user.getUsername();
			
			if(email != null && !"".equals(email)) {
				User userObj = userService.getUserByUsername(email);
				
				if(userObj != null) {
					throw new ResourceNotFoundException("Username already exist, please try another username.");
				}
			}
			return userRepository.save(user);
		}
		
		// get user by Id
		@GetMapping("/users/{id}")
		public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
			User user = userRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User does not exist with id :" + id));
			return ResponseEntity.ok(user);
		}
		
		// get all users
		@GetMapping("/users")
		public List<User> getUsers(){
			return userRepository.findAll();
		}		
				
		// update user details		
		@PutMapping("/updateUser/{id}")
		public ResponseEntity<User> updateEmployee(@PathVariable("id") Long id, @RequestBody User userDetails){
			User user = userRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User does not exist with id :" + id));
			
			user.setName(userDetails.getName());
			user.setSurname(userDetails.getSurname());
			user.setGender(userDetails.getGender());
			user.setAge(userDetails.getAge());
			user.setHeight(userDetails.getHeight());
			user.setWeight(userDetails.getWeight());
			user.setWeight_goal(userDetails.getWeight_goal());
			user.setActivity_level(userDetails.getActivity_level());
			user.setUsername(userDetails.getUsername());
			user.setPassword(userDetails.getPassword());
			
			User updatedUser = userRepository.save(user);
			return ResponseEntity.ok(updatedUser);
		}
		
		// delete user
		@DeleteMapping("/deleteUser/{id}")
		public ResponseEntity<User> deleteUser(@PathVariable("id") Long id){
			User user = userRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("User does not exist with id :" + id));
			
			userRepository.delete(user);
			return ResponseEntity.ok(user);
		}

		//Login method
		@PostMapping("/login")
		public ResponseEntity<User> login(@RequestBody User user){
			String email = user.getUsername();
			String password = user.getPassword();
			
			User userObjUser = null;
			
			if(email != null && password != null)
			{
				userObjUser = userService.getUserByUsernameAndPassword(email, password);
			}
			
			return ResponseEntity.ok(userObjUser);
			
		}
		
		//Calculate BMI
		

}
