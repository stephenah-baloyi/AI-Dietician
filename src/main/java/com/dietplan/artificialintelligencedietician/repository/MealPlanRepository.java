package com.dietplan.artificialintelligencedietician.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dietplan.artificialintelligencedietician.model.MealPlan;


@Repository
public interface MealPlanRepository extends JpaRepository<MealPlan, Long>{

}
