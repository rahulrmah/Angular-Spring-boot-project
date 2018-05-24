package com.cybage.tes.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cybage.tes.model.Mentee;

public interface MenteeRepository extends JpaRepository<Mentee, Integer> {

	List<Mentee> findByTechnology(String technology);

}
