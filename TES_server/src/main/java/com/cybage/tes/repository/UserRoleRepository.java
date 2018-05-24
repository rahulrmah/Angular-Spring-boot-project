package com.cybage.tes.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.tes.model.User;
import com.cybage.tes.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

	List<UserRole> findByRole(String role);

	List<UserRole> findByRoleAndUser(String role, User u);

	

}
