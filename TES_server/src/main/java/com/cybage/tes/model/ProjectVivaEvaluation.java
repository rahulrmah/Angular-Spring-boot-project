package com.cybage.tes.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the project_viva_evaluation database table.
 * 
 */
@Entity
@Table(name="project_viva_evaluation")
@NamedQuery(name="ProjectVivaEvaluation.findAll", query="SELECT p FROM ProjectVivaEvaluation p")
public class ProjectVivaEvaluation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="analytical_skills")
	private BigDecimal analyticalSkills;

	private BigDecimal attitude;

	@Column(name="communication_skills")
	private BigDecimal communicationSkills;

	@Column(name="evaluator_comment")
	private String evaluatorComment;

	@Temporal(TemporalType.DATE)
	@Column(name="project_evaluation_date")
	private Date projectEvaluationDate;

	@Column(name="project_type")
	private String projectType;

	@Column(name="sme_comment")
	private String smeComment;

	@Column(name="team_work")
	private BigDecimal teamWork;

	@Column(name="technical_knowledge")
	private BigDecimal technicalKnowledge;

	//bi-directional many-to-one association to Mentee
	@ManyToOne
	@JoinColumn(name="mentee_id")
	@JsonIgnore
	private Mentee mentee;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="evaluator_id")
	@JsonIgnore
	private User user;

	public ProjectVivaEvaluation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getAnalyticalSkills() {
		return this.analyticalSkills;
	}

	public void setAnalyticalSkills(BigDecimal analyticalSkills) {
		this.analyticalSkills = analyticalSkills;
	}

	public BigDecimal getAttitude() {
		return this.attitude;
	}

	public void setAttitude(BigDecimal attitude) {
		this.attitude = attitude;
	}

	public BigDecimal getCommunicationSkills() {
		return this.communicationSkills;
	}

	public void setCommunicationSkills(BigDecimal communicationSkills) {
		this.communicationSkills = communicationSkills;
	}

	public String getEvaluatorComment() {
		return this.evaluatorComment;
	}

	public void setEvaluatorComment(String evaluatorComment) {
		this.evaluatorComment = evaluatorComment;
	}

	public Date getProjectEvaluationDate() {
		return this.projectEvaluationDate;
	}

	public void setProjectEvaluationDate(Date projectEvaluationDate) {
		this.projectEvaluationDate = projectEvaluationDate;
	}

	public String getProjectType() {
		return this.projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getSmeComment() {
		return this.smeComment;
	}

	public void setSmeComment(String smeComment) {
		this.smeComment = smeComment;
	}

	public BigDecimal getTeamWork() {
		return this.teamWork;
	}

	public void setTeamWork(BigDecimal teamWork) {
		this.teamWork = teamWork;
	}

	public BigDecimal getTechnicalKnowledge() {
		return this.technicalKnowledge;
	}

	public void setTechnicalKnowledge(BigDecimal technicalKnowledge) {
		this.technicalKnowledge = technicalKnowledge;
	}

	public Mentee getMentee() {
		return this.mentee;
	}

	public void setMentee(Mentee mentee) {
		this.mentee = mentee;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}