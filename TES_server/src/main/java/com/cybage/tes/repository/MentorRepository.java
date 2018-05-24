package com.cybage.tes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.tes.model.Groups;
import com.cybage.tes.model.Mentor;

public interface MentorRepository extends JpaRepository<Mentor, Integer> {

	List<Mentor> findByGroups(Groups g1);



}
