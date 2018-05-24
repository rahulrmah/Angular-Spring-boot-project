package com.cybage.tes.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.tes.model.Evaluator;
import com.cybage.tes.model.Groups;
import com.cybage.tes.model.Mentee;
import com.cybage.tes.model.Mentor;
import com.cybage.tes.model.User;
import com.cybage.tes.model.UserRole;
import com.cybage.tes.repository.EvaluatorRepository;
import com.cybage.tes.repository.GroupsRepository;
import com.cybage.tes.repository.MenteeRepository;
import com.cybage.tes.repository.MentorRepository;
import com.cybage.tes.repository.UserRepository;
import com.cybage.tes.repository.UserRoleRepository;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserRoleRepository userRolRepo;
	
	@Autowired
	MenteeRepository menteeRepo;
	
	
	@Autowired
	GroupsRepository groupsRepo;
	
	@Autowired
	GroupsRepository GroupsRepo;
	
	@Autowired
	EvaluatorRepository EvaluatorRepo;
	
	@Autowired
	MentorRepository MentorRepo;

	@RequestMapping(value="addUser/{userName}/{technology}/{userRoletemp}")
	public User addUser(@PathVariable("userName") String userName,@PathVariable("technology") String technology,@PathVariable("userRoletemp") String userRoletemp) {
		
		User tempUser = new User();
		String email = userName + "@cybage.com";
		UserRole role=new UserRole();
		boolean flag=false;
		if((tempUser=userRepo.findByUserName(userName))!=null){
			
			for(UserRole r:tempUser.getUserRoles()){
				if(null!=r.getRole()){
					if(r.getRole().equals(userRoletemp)){
						flag=true;
						break;
					}
				}
			}
			if(!flag){
				role.setUser(tempUser);
				role.setRole(userRoletemp);
				role=userRolRepo.saveAndFlush(role);
				
				
			}
		}
		else{
			tempUser=new User();
			tempUser.setUserName(userName);
			tempUser.setTechnology(technology);
			tempUser.setEmailId(email);
			tempUser=userRepo.saveAndFlush(tempUser);
			role.setUser(tempUser);
			role.setRole(userRoletemp);
			role=userRolRepo.saveAndFlush(role);
			
		}
		return tempUser;
	}
	
	

	@PostMapping(value="/getGroups")
	public List<Groups>  getMentees(@RequestBody Mentee m ){
		
		
		Set<Integer> ids=new HashSet<>();
		List<Groups> gg=new ArrayList<>();
		
		List<Mentee> mm=menteeRepo.findByTechnology(m.getTechnology());
		for (Mentee mentee : mm) {
			
			ids.add(mentee.getGroups().getGroupId());
		}
		for(Integer id:ids){
			gg.add(groupsRepo.getOne(id));
		}
		return gg;
	}
	
	
	@PostMapping(value="/getByroleName/{technology}")
	public  List<User>  getUserByroleName(@RequestBody UserRole ur,@PathVariable("technology") String technology){
		
	
		 List<User> gg=new ArrayList<>();
	  
		 List <User> uu=userRepo.findBytechnology(technology);
		List<UserRole> rr=new ArrayList<>();
		for (User u : uu) {
			 rr.addAll(userRolRepo.findByRoleAndUser(ur.getRole(),u));	
		}

		for (UserRole r : rr) {
			gg.add(r.getUser());
		}
        return gg;
	}
	
	
	@GetMapping(value="/getEvaluator/{groupId}")
	public List<User> getEvaluator(@PathVariable("groupId") Double groupId)
	{
		System.out.println(groupId.intValue() +"==");
		
		Groups g1=new Groups();
		
		g1.setGroupId(groupId.intValue());
		List<Evaluator> evlList=EvaluatorRepo.findByGroups(g1);
	
		
		List<User> evalu=new ArrayList<>();
	
		if(evlList!=null){
			
			for (Evaluator ev : evlList) {
				evalu.add(userRepo.findByUserId(ev.getUser().getUserId()));	
			}
		}
		
		
		
		
		
		return evalu;
	}

	
	@GetMapping(value="/getMentor/{groupId}")
	public List<User> getMentor(@PathVariable("groupId") Double groupId)
	{
		System.out.println(groupId.intValue() +"==");
		
		Groups g1=new Groups();
		
		g1.setGroupId(groupId.intValue());
	
		List<Mentor> mntList=MentorRepo.findByGroups(g1);
		
		List<User> mntu=new ArrayList<>();
		
		
		if(mntList!=null){
					
		for (Mentor mnt : mntList) {
			mntu.add(userRepo.findByUserId(mnt.getUser().getUserId()));	
			}
		}
				
		
		
		return mntu;
	}
	
	
	
	
	
	
	
	@GetMapping(value="/assignMentorEvaluator/{userId}/{groupId}/{userType}")
	public Groups assignMentorEvaluator(@PathVariable("userId") Double userId,@PathVariable("groupId") Double groupId,@PathVariable("userType") String userType) {
				
		Groups g=new Groups();
		
			g.setGroupId(groupId.intValue());
		if(userType.equals("Evaluator")){
			Evaluator e=new Evaluator();
			User u=new User();
			u.setUserId(userId.intValue());
			e.setUser(u);
			e.setGroups(g);
			
			e.setAssignedDate(new Date());
			
			EvaluatorRepo.save(e);
		}
		else{
			Mentor m=new Mentor();
			User u=new User();
			u.setUserId(userId.intValue());
			m.setUser(u);
			m.setGroups(g);
			m.setAssignedDate(new Date());
			MentorRepo.save(m);
		}
		
		return g;
	}
	
	
	
		
			
	
	
}
