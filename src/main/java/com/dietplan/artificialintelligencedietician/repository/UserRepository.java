package com.dietplan.artificialintelligencedietician.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dietplan.artificialintelligencedietician.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public User findByUsername(String email);
	public User findByUsernameAndPassword(String email, String password);

}
