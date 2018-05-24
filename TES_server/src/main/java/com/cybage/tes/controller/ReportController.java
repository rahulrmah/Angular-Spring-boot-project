package com.cybage.tes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.tes.model.FinalReport;

import com.cybage.tes.repository.FinalReportRepository;
import com.cybage.tes.repository.MenteeRepository;

@RestController
public class ReportController {

	@Autowired
	FinalReportRepository finalReportRepo;
	
	@Autowired
	MenteeRepository menteeRepo;
	
	@RequestMapping(value="/finalReport")
	public List<FinalReport> getFianlReport(){
		
		return finalReportRepo.findAll();
	}
	
}
