package com.cybage.tes.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 * The persistent class for the communication_evaluation database table.
 * 
 */
@Entity
@Table(name="communication_evaluation")
@NamedQuery(name="CommunicationEvaluation.findAll", query="SELECT c FROM CommunicationEvaluation c")
public class CommunicationEvaluation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String grade;

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

	public CommunicationEvaluation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
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