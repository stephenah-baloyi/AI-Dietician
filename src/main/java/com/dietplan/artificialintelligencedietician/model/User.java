package com.dietplan.artificialintelligencedietician.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String surname;
	private String gender;
	private int age;
	private double height;
	private double  weight;
	private double  weight_goal;
	private String  activity_level;
	private double  BMI;
	private String  username;
	private String password;
	
	@OneToOne(mappedBy = "user")
	private MealPlan mealPlan;
	
	public User() {
		
	}

	public User(String name, String surname, String gender, int age, double height, double weight, double weight_goal,
			String activity_level, double bMI, String username, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.weight_goal = weight_goal;
		this.activity_level = activity_level;
		BMI = bMI;
		this.username = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWeight_goal() {
		return weight_goal;
	}

	public void setWeight_goal(double weight_goal) {
		this.weight_goal = weight_goal;
	}

	public String getActivity_level() {
		return activity_level;
	}

	public void setActivity_level(String activity_level) {
		this.activity_level = activity_level;
	}

	public double getBMI() {
		return BMI;
	}

	public void setBMI(double bMI) {
		BMI = bMI;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MealPlan getMealPlan() {
		return mealPlan;
	}

	public void setMealPlan(MealPlan mealPlan) {
		this.mealPlan = mealPlan;
	}
	
	

}
