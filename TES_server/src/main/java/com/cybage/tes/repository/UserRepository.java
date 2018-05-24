package com.cybage.tes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.tes.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserName(String userName);

	List<User> findBytechnology(String technology);

	User findByUserId(int userId);

	
}
