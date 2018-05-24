package com.cybage.tes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.tes.model.Evaluator;
import com.cybage.tes.model.Groups;

public interface EvaluatorRepository extends JpaRepository<Evaluator, Integer> {

	List<Evaluator> findByGroups(Groups g1);



}
