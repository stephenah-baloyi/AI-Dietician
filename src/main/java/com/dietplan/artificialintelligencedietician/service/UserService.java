package com.dietplan.artificialintelligencedietician.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dietplan.artificialintelligencedietician.model.User;
import com.dietplan.artificialintelligencedietician.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public double calculateBMI(double weight, double height)
	{
		 double BMI = weight / (Math.pow(height, 2));
		 
		 return BMI;
	}
	
	public User getUserByUsername(String email)
	{
		return repo.findByUsername(email);
	}
	
	public User getUserByUsernameAndPassword(String email, String password)
	{
		return repo.findByUsernameAndPassword(email, password);
	}

}
