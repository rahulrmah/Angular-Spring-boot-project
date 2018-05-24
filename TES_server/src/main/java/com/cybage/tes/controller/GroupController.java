package com.cybage.tes.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.tes.model.*;
import com.cybage.tes.repository.*;


@RestController
public class GroupController {
	@Autowired
	MentorRepository mentorRepo;
	@Autowired
	GroupsRepository groupsRepo;
	@Autowired
	MenteeRepository menteeRepo;
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping(value="/addGroup/{groupName}")
	public Groups addGroup(@RequestBody Double[] menteesIdList,@PathVariable("groupName") String groupName) {
		
		Groups g=new Groups();
		g.setGroupName(groupName);
		g=groupsRepo.saveAndFlush(g);
		for(Double id:menteesIdList){
			
			Mentee mentee=menteeRepo.getOne(id.intValue());
			mentee.setGroups(g);
			mentee=menteeRepo.saveAndFlush(mentee);
		}
		
		g=groupsRepo.getOne(g.getGroupId());
		return g;
	}
	
	@RequestMapping(value="/getJavaMentees")
	public List<Mentee> getJavaMentees(){
		
		List<Mentee> mentees=menteeRepo.findAll();
		List<Mentee> menteesList=new ArrayList<>();
		for(Mentee m:mentees){
			if("Java".equals(m.getTechnology()) && m.getGroups()==null)
				menteesList.add(m);
		}
		return menteesList;
	}
	@RequestMapping(value="/getDotNetMentees")
	public List<Mentee> getDotNetMentees(){
		
		List<Mentee> mentees=menteeRepo.findAll();
		List<Mentee> menteesList=new ArrayList<>();
		for(Mentee m:mentees){
			if("DotNet".equals(m.getTechnology()) && m.getGroups()==null)
				menteesList.add(m);
		}
		return menteesList;
	}
	@RequestMapping(value="/getFETMentees")
	public List<Mentee> getFETMentees(){
		
		List<Mentee> mentees=menteeRepo.findAll();
		List<Mentee> menteesList=new ArrayList<>();
		for(Mentee m:mentees){
			if("FET".equals(m.getTechnology()) && m.getGroups()==null)
				menteesList.add(m);
		}
		return menteesList;
	}
	
}




















