package com.dietplan.artificialintelligencedietician.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.dietplan.artificialintelligencedietician.model.Food;
import com.dietplan.artificialintelligencedietician.model.MealPLanDetails;
import com.dietplan.artificialintelligencedietician.model.MealPlan;
import com.dietplan.artificialintelligencedietician.model.User;
import com.dietplan.artificialintelligencedietician.repository.MealPlanDetailsRepository;
import com.dietplan.artificialintelligencedietician.repository.MealPlanRepository;
import com.dietplan.artificialintelligencedietician.repository.UserRepository;
import com.dietplan.artificialintelligencedietician.service.ResourceNotFoundException;

@RestController
@RequestMapping("/app")
public class MealPlanController {
	
	@Autowired
	private MealPlanRepository mealPlanRepository;
	
	@Autowired
	private MealPlanDetailsRepository mealPlanDetailsRepository;
	
	@Autowired
	private UserRepository userRepository;

	//create meal plan
	@PostMapping("/createMealPlan/{user_id}")
	public MealPlan createFood(@RequestBody ArrayList<Food> foods, @PathVariable("user_id") Long user_id) {
		
		User user = userRepository.findById(user_id)
				.orElseThrow(() -> new ResourceNotFoundException("User does not exist with id :" + user_id));
		
		MealPlan meal = new MealPlan(user);

		mealPlanRepository.save(meal);
		double total_colories = 0.0;
		
		for (int i = 0; i < foods.size(); i++) {
			
			total_colories += foods.get(i).getFood_calories();			
			MealPLanDetails mealDetails = new MealPLanDetails(foods.get(i).getId(), meal.getId(), foods.get(i).getMeal_type(),foods.get(i).getFood_name(),total_colories);
			
			mealPlanDetailsRepository.save(mealDetails);

		}

		return meal;
	}

	// get meal by Id
	@GetMapping("/mealPlan/{id}")
	public ResponseEntity<MealPlan> getMealPlanById(@PathVariable("id") Long id) {
		MealPlan meal = mealPlanRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("MealPlan does not exist with id :" + id));
		return ResponseEntity.ok(meal);
	}

	// get all foods
	@GetMapping("/mealPlans")
	public List<MealPlan> getMealPlans() {
		return mealPlanRepository.findAll();
	}

	// update MealPlan details
	@PutMapping("/updateMealPlan/{id}")
	public ResponseEntity<MealPlan> updateMealPlan(@PathVariable("id") Long id, @RequestBody MealPlan mealDetails) {
		MealPlan mealPlan = mealPlanRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Food does not exist with id :" + id));
		
		MealPlan updatedMeal = mealPlanRepository.save(mealPlan);
		return ResponseEntity.ok(updatedMeal);
	}

	// delete MealPlan
	@DeleteMapping("/deleteMealPlan/{id}")
	public ResponseEntity<MealPlan> deleteMealPlan(@PathVariable("id") Long id) {
		MealPlan meal = mealPlanRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("MealPlan does not exist with id :" + id));

		mealPlanRepository.delete(meal);
		return ResponseEntity.ok(meal);
	}

}
