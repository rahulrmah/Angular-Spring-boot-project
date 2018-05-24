package com.cybage.tes.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;


/**
 * The persistent class for the weekly_mom_details database table.
 * 
 */
@Entity
@Table(name="weekly_mom_details")
@NamedQuery(name="WeeklyMomDetail.findAll", query="SELECT w FROM WeeklyMomDetail w")
public class WeeklyMomDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="assignment_status")
	private String assignmentStatus;

	@Temporal(TemporalType.DATE)
	@Column(name="completion_date")
	private Date completionDate;

	@Column(name="mom_comments")
	private String momComments;

	//bi-directional many-to-one association to Mentee
	@ManyToOne
	@JoinColumn(name="mentee_id")
	@JsonIgnore
	private Mentee mentee;

	//bi-directional many-to-one association to WeeklyMom
	@ManyToOne
	@JoinColumn(name="mom_id")
	@JsonIgnore
	private WeeklyMom weeklyMom;

	public WeeklyMomDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssignmentStatus() {
		return this.assignmentStatus;
	}

	public void setAssignmentStatus(String assignmentStatus) {
		this.assignmentStatus = assignmentStatus;
	}

	public Date getCompletionDate() {
		return this.completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public String getMomComments() {
		return this.momComments;
	}

	public void setMomComments(String momComments) {
		this.momComments = momComments;
	}

	public Mentee getMentee() {
		return this.mentee;
	}

	public void setMentee(Mentee mentee) {
		this.mentee = mentee;
	}

	public WeeklyMom getWeeklyMom() {
		return this.weeklyMom;
	}

	public void setWeeklyMom(WeeklyMom weeklyMom) {
		this.weeklyMom = weeklyMom;
	}

}