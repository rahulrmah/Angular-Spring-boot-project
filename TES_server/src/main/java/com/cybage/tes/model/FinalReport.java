package com.cybage.tes.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;


/**
 * The persistent class for the final_report database table.
 * 
 */
@Entity
@Table(name="final_report")
@NamedQuery(name="FinalReport.findAll", query="SELECT f FROM FinalReport f")
public class FinalReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="evaluator_comments")
	private String evaluatorComments;

	@Column(name="mentee_name")
	private String menteeName;

	@Column(name="mentor_comments")
	private String mentorComments;

	@Column(name="mentor_score")
	private BigDecimal mentorScore;

	@Column(name="project_evaluation_score")
	private BigDecimal projectEvaluationScore;

	@Column(name="project_reeval_score")
	private BigDecimal projectReevalScore;

	@Column(name="soft_skill_score")
	private String softSkillScore;

	//bi-directional many-to-one association to Mentee
	@ManyToOne
	@JoinColumn(name="mentee_id")
	@JsonIgnore
	private Mentee mentee;

	public FinalReport() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEvaluatorComments() {
		return this.evaluatorComments;
	}

	public void setEvaluatorComments(String evaluatorComments) {
		this.evaluatorComments = evaluatorComments;
	}

	public String getMenteeName() {
		return this.menteeName;
	}

	public void setMenteeName(String menteeName) {
		this.menteeName = menteeName;
	}

	public String getMentorComments() {
		return this.mentorComments;
	}

	public void setMentorComments(String mentorComments) {
		this.mentorComments = mentorComments;
	}

	public BigDecimal getMentorScore() {
		return this.mentorScore;
	}

	public void setMentorScore(BigDecimal mentorScore) {
		this.mentorScore = mentorScore;
	}

	public BigDecimal getProjectEvaluationScore() {
		return this.projectEvaluationScore;
	}

	public void setProjectEvaluationScore(BigDecimal projectEvaluationScore) {
		this.projectEvaluationScore = projectEvaluationScore;
	}

	public BigDecimal getProjectReevalScore() {
		return this.projectReevalScore;
	}

	public void setProjectReevalScore(BigDecimal projectReevalScore) {
		this.projectReevalScore = projectReevalScore;
	}

	public String getSoftSkillScore() {
		return this.softSkillScore;
	}

	public void setSoftSkillScore(String softSkillScore) {
		this.softSkillScore = softSkillScore;
	}

	@JsonIgnore
	public Mentee getMentee() {
		return this.mentee;
	}

	public void setMentee(Mentee mentee) {
		this.mentee = mentee;
	}

}