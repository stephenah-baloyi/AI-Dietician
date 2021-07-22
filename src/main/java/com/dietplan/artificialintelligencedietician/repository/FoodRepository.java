package com.dietplan.artificialintelligencedietician.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dietplan.artificialintelligencedietician.model.Food;


@Repository
public interface FoodRepository extends JpaRepository<Food, Long>{

}
