package com.cybage.tes.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the mentor database table.
 * 
 */
@Entity
@NamedQuery(name="Mentor.findAll", query="SELECT m FROM Mentor m")
public class Mentor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="assigned_date")
	private Date assignedDate;

	@Column(name="current_mentor")
	private byte currentMentor;

	//bi-directional many-to-one association to Group
	@ManyToOne
	@JoinColumn(name="group_id")
	@JsonIgnore
	private Groups groups;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="mentor_id")
	@JsonIgnore
	private User user;

	public Mentor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAssignedDate() {
		return this.assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	public byte getCurrentMentor() {
		return this.currentMentor;
	}

	public void setCurrentMentor(byte currentMentor) {
		this.currentMentor = currentMentor;
	}

	public Groups getGroups() {
		return this.groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}