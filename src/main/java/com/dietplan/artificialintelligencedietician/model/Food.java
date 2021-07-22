package com.dietplan.artificialintelligencedietician.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="food")
public class Food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String food_name;
	private double food_calories;
	private String meal_type;
	
	public Food() {
		
	}
	
	public Food(String food_name, double food_calories, String meal_type) {
		super();
		this.food_name = food_name;
		this.food_calories = food_calories;
		this.meal_type = meal_type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public double getFood_calories() {
		return food_calories;
	}
	public void setFood_calories(double food_calories) {
		this.food_calories = food_calories;
	}
	public String getMeal_type() {
		return meal_type;
	}
	public void setMeal_type(String meal_type) {
		this.meal_type = meal_type;
	}
	
	

}
