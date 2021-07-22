package com.dietplan.artificialintelligencedietician.controller;

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
import com.dietplan.artificialintelligencedietician.repository.FoodRepository;
import com.dietplan.artificialintelligencedietician.service.ResourceNotFoundException;

@RestController
@RequestMapping("/app")
public class FoodController {

	@Autowired
	private FoodRepository foodRepository;

	// add food
	@PostMapping("/addFood")
	public Food createFood(@RequestBody Food food) {
		
		return foodRepository.save(food);
	}

	// get food by Id
	@GetMapping("/food/{id}")
	public ResponseEntity<Food> getFoodById(@PathVariable("id") Long id) {
		Food food = foodRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Food does not exist with id :" + id));
		return ResponseEntity.ok(food);
	}

	// get all foods
	@GetMapping("/foods")
	public List<Food> getFoods() {
		return foodRepository.findAll();
	}

	// update Food details
	@PutMapping("/updateFood/{id}")
	public ResponseEntity<Food> updateFood(@PathVariable("id") Long id, @RequestBody Food foodDetails) {
		Food food = foodRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Food does not exist with id :" + id));

		food.setFood_name(foodDetails.getFood_name());
		food.setMeal_type(foodDetails.getMeal_type());
		food.setFood_calories(foodDetails.getFood_calories());
		
		Food updatedFood = foodRepository.save(food);
		return ResponseEntity.ok(updatedFood);
	}

	// delete Food
	@DeleteMapping("/deleteFood/{id}")
	public ResponseEntity<Food> deleteFood(@PathVariable("id") Long id) {
		Food food = foodRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Food does not exist with id :" + id));

		foodRepository.delete(food);
		return ResponseEntity.ok(food);
	}

}
