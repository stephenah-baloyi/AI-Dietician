package com.dietplan.artificialintelligencedietician.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dietplan.artificialintelligencedietician.model.MealPLanDetails;

@Repository
public interface MealPlanDetailsRepository extends JpaRepository<MealPLanDetails, Long>{

}
