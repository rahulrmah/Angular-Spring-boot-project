package com.cybage.tes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.tes.model.User;
import com.cybage.tes.repository.MenteeRepository;

@RestController
public class AddUserController {

	@Autowired
	MenteeRepository menteeRepo;
	
	
}
