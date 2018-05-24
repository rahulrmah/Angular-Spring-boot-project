package com.cybage.tes.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;


/**
 * The persistent class for the final_mentor_evaluation database table.
 * 
 */
@Entity
@Table(name="final_mentor_evaluation")
@NamedQuery(name="FinalMentorEvaluation.findAll", query="SELECT f FROM FinalMentorEvaluation f")
public class FinalMentorEvaluation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private BigDecimal attitude;

	private BigDecimal communication;

	private BigDecimal hardworking;

	private BigDecimal iq;

	@Column(name="mentor_comment")
	private String mentorComment;

	private BigDecimal process;

	@Column(name="sme_comment")
	private String smeComment;

	@Column(name="technical_knowledge")
	private BigDecimal technicalKnowledge;

	//bi-directional many-to-one association to Mentee
	@ManyToOne
	@JoinColumn(name="mentee_id")
	@JsonIgnore
	private Mentee mentee;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="mentor_id")
	@JsonIgnore
	private User user;

	public FinalMentorEvaluation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getAttitude() {
		return this.attitude;
	}

	public void setAttitude(BigDecimal attitude) {
		this.attitude = attitude;
	}

	public BigDecimal getCommunication() {
		return this.communication;
	}

	public void setCommunication(BigDecimal communication) {
		this.communication = communication;
	}

	public BigDecimal getHardworking() {
		return this.hardworking;
	}

	public void setHardworking(BigDecimal hardworking) {
		this.hardworking = hardworking;
	}

	public BigDecimal getIq() {
		return this.iq;
	}

	public void setIq(BigDecimal iq) {
		this.iq = iq;
	}

	public String getMentorComment() {
		return this.mentorComment;
	}

	public void setMentorComment(String mentorComment) {
		this.mentorComment = mentorComment;
	}

	public BigDecimal getProcess() {
		return this.process;
	}

	public void setProcess(BigDecimal process) {
		this.process = process;
	}

	public String getSmeComment() {
		return this.smeComment;
	}

	public void setSmeComment(String smeComment) {
		this.smeComment = smeComment;
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