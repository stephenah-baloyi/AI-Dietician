package com.dietplan.artificialintelligencedietician.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="meal_plan_details")
public class MealPLanDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long food_id;
	private Long meal_id;
	private String meal_type;
	private String food_name;
	private double total_colories;
	
	public MealPLanDetails() {
		
	}
	
	public MealPLanDetails(Long food_id, Long meal_id, String meal_type, String food_name, double total_colories) {
		super();
		this.food_id = food_id;
		this.meal_id = meal_id;
		this.meal_type = meal_type;
		this.food_name = food_name;
		this.total_colories = total_colories;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getFood_id() {
		return food_id;
	}
	public void setFood_id(Long food_id) {
		this.food_id = food_id;
	}
	public Long getMeal_id() {
		return meal_id;
	}
	public void setMeal_id(Long meal_id) {
		this.meal_id = meal_id;
	}
	public String getMeal_type() {
		return meal_type;
	}
	public void setMeal_type(String meal_type) {
		this.meal_type = meal_type;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public double getTotal_colories() {
		return total_colories;
	}
	public void setTotal_colories(double total_colories) {
		this.total_colories = total_colories;
	}
	
	

}
