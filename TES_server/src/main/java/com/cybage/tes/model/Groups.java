package com.cybage.tes.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the group database table.
 * 
 */
@Entity
@NamedQuery(name="Groups.findAll", query="SELECT g FROM Groups g")
public class Groups implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="group_id")
	private int groupId;

	@Column(name="group_name")
	private String groupName;

	//bi-directional many-to-one association to Evaluator
	@OneToMany(mappedBy="groups")
	private List<Evaluator> evaluators;

	//bi-directional many-to-one association to Mentee
	@OneToMany(mappedBy="groups")
	private List<Mentee> mentees;

	//bi-directional many-to-one association to Mentor
	@OneToMany(mappedBy="groups")
	private List<Mentor> mentors;

	public Groups() {
	}

	public int getGroupId() {
		return this.groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<Evaluator> getEvaluators() {
		return this.evaluators;
	}

	public void setEvaluators(List<Evaluator> evaluators) {
		this.evaluators = evaluators;
	}

	public Evaluator addEvaluator(Evaluator evaluator) {
		getEvaluators().add(evaluator);
		evaluator.setGroups(this);

		return evaluator;
	}

	public Evaluator removeEvaluator(Evaluator evaluator) {
		getEvaluators().remove(evaluator);
		evaluator.setGroups(null);

		return evaluator;
	}

	public List<Mentee> getMentees() {
		return this.mentees;
	}

	public void setMentees(List<Mentee> mentees) {
		this.mentees = mentees;
	}

	public Mentee addMentee(Mentee mentee) {
		getMentees().add(mentee);
		mentee.setGroups(this);

		return mentee;
	}

	public Mentee removeMentee(Mentee mentee) {
		getMentees().remove(mentee);
		mentee.setGroups(null);

		return mentee;
	}

	public List<Mentor> getMentors() {
		return this.mentors;
	}

	public void setMentors(List<Mentor> mentors) {
		this.mentors = mentors;
	}

	public Mentor addMentor(Mentor mentor) {
		getMentors().add(mentor);
		mentor.setGroups(this);

		return mentor;
	}

	public Mentor removeMentor(Mentor mentor) {
		getMentors().remove(mentor);
		mentor.setGroups(null);

		return mentor;
	}

}