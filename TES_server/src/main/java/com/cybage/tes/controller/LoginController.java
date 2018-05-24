package com.cybage.tes.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cybage.tes.ldap.VerifyCredentials;
import com.cybage.tes.model.User;
import com.cybage.tes.model.UserRole;
import com.cybage.tes.repository.UserRepository;

@RestController
public class LoginController {
		
	@Autowired
	UserRepository userRepo;

	@PostMapping(value="/login")
	public ResponseEntity<User> login(@RequestBody User u,HttpServletRequest request) {
		
		
		String str=new VerifyCredentials().validate(u.getUserName(),u.getPassword(),request); 
		
		if(str=="Success"){
			
			User uu=userRepo.findByUserName(u.getUserName());
			List<UserRole> userList=uu.getUserRoles(); 
			List<String> roleList=new ArrayList<>();
			 for (UserRole e : userList)
	            {
				 roleList.add(e.getRole());
	               
	            }
			
			 return new ResponseEntity<User>(uu, HttpStatus.OK);
		}else
			return null;
	}
	
	
	
	
}