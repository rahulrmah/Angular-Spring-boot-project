package com.cybage.tes.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;

	@Column(name="email_id")
	private String emailId;

	private String technology;
	
	private String password;
	
	@Column(name="user_name")
	private String userName;

	//bi-directional many-to-one association to CommunicationEvaluation
	@OneToMany(mappedBy="user")
	private List<CommunicationEvaluation> communicationEvaluations;

	//bi-directional many-to-one association to Evaluator
	@OneToMany(mappedBy="user")
	private List<Evaluator> evaluators;

	//bi-directional many-to-one association to FinalMentorEvaluation
	@OneToMany(mappedBy="user")
	private List<FinalMentorEvaluation> finalMentorEvaluations;

	//bi-directional many-to-one association to Mentor
	@OneToMany(mappedBy="user")
	private List<Mentor> mentors;

	//bi-directional many-to-one association to ProjectVivaEvaluation
	@OneToMany(mappedBy="user")
	private List<ProjectVivaEvaluation> projectVivaEvaluations;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="user")
	private List<UserRole> userRoles;

	//bi-directional many-to-one association to WeeklyMom
	@OneToMany(mappedBy="user")
	private List<WeeklyMom> weeklyMoms;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTechnology() {
		return this.technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<CommunicationEvaluation> getCommunicationEvaluations() {
		return this.communicationEvaluations;
	}

	public void setCommunicationEvaluations(List<CommunicationEvaluation> communicationEvaluations) {
		this.communicationEvaluations = communicationEvaluations;
	}

	public CommunicationEvaluation addCommunicationEvaluation(CommunicationEvaluation communicationEvaluation) {
		getCommunicationEvaluations().add(communicationEvaluation);
		communicationEvaluation.setUser(this);

		return communicationEvaluation;
	}

	public CommunicationEvaluation removeCommunicationEvaluation(CommunicationEvaluation communicationEvaluation) {
		getCommunicationEvaluations().remove(communicationEvaluation);
		communicationEvaluation.setUser(null);

		return communicationEvaluation;
	}

	public List<Evaluator> getEvaluators() {
		return this.evaluators;
	}

	public void setEvaluators(List<Evaluator> evaluators) {
		this.evaluators = evaluators;
	}

	public Evaluator addEvaluator(Evaluator evaluator) {
		getEvaluators().add(evaluator);
		evaluator.setUser(this);

		return evaluator;
	}

	public Evaluator removeEvaluator(Evaluator evaluator) {
		getEvaluators().remove(evaluator);
		evaluator.setUser(null);

		return evaluator;
	}

	public List<FinalMentorEvaluation> getFinalMentorEvaluations() {
		return this.finalMentorEvaluations;
	}

	public void setFinalMentorEvaluations(List<FinalMentorEvaluation> finalMentorEvaluations) {
		this.finalMentorEvaluations = finalMentorEvaluations;
	}

	public FinalMentorEvaluation addFinalMentorEvaluation(FinalMentorEvaluation finalMentorEvaluation) {
		getFinalMentorEvaluations().add(finalMentorEvaluation);
		finalMentorEvaluation.setUser(this);

		return finalMentorEvaluation;
	}

	public FinalMentorEvaluation removeFinalMentorEvaluation(FinalMentorEvaluation finalMentorEvaluation) {
		getFinalMentorEvaluations().remove(finalMentorEvaluation);
		finalMentorEvaluation.setUser(null);

		return finalMentorEvaluation;
	}

	public List<Mentor> getMentors() {
		return this.mentors;
	}

	public void setMentors(List<Mentor> mentors) {
		this.mentors = mentors;
	}

	public Mentor addMentor(Mentor mentor) {
		getMentors().add(mentor);
		mentor.setUser(this);

		return mentor;
	}

	public Mentor removeMentor(Mentor mentor) {
		getMentors().remove(mentor);
		mentor.setUser(null);

		return mentor;
	}

	public List<ProjectVivaEvaluation> getProjectVivaEvaluations() {
		return this.projectVivaEvaluations;
	}

	public void setProjectVivaEvaluations(List<ProjectVivaEvaluation> projectVivaEvaluations) {
		this.projectVivaEvaluations = projectVivaEvaluations;
	}

	public ProjectVivaEvaluation addProjectVivaEvaluation(ProjectVivaEvaluation projectVivaEvaluation) {
		getProjectVivaEvaluations().add(projectVivaEvaluation);
		projectVivaEvaluation.setUser(this);

		return projectVivaEvaluation;
	}

	public ProjectVivaEvaluation removeProjectVivaEvaluation(ProjectVivaEvaluation projectVivaEvaluation) {
		getProjectVivaEvaluations().remove(projectVivaEvaluation);
		projectVivaEvaluation.setUser(null);

		return projectVivaEvaluation;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setUser(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setUser(null);

		return userRole;
	}

	public List<WeeklyMom> getWeeklyMoms() {
		return this.weeklyMoms;
	}

	public void setWeeklyMoms(List<WeeklyMom> weeklyMoms) {
		this.weeklyMoms = weeklyMoms;
	}

	public WeeklyMom addWeeklyMom(WeeklyMom weeklyMom) {
		getWeeklyMoms().add(weeklyMom);
		weeklyMom.setUser(this);

		return weeklyMom;
	}

	public WeeklyMom removeWeeklyMom(WeeklyMom weeklyMom) {
		getWeeklyMoms().remove(weeklyMom);
		weeklyMom.setUser(null);

		return weeklyMom;
	}

}