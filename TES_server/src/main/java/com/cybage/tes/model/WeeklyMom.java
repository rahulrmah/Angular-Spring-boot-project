package com.cybage.tes.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the weekly_mom database table.
 * 
 */
@Entity
@Table(name="weekly_mom")
@NamedQuery(name="WeeklyMom.findAll", query="SELECT w FROM WeeklyMom w")
public class WeeklyMom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="mom_id")
	private int momId;

	@Temporal(TemporalType.DATE)
	@Column(name="mom_date")
	private Date momDate;

	@Column(name="mom_time")
	private Time momTime;

	@Column(name="mom_topic")
	private String momTopic;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="mentor_id")
	@JsonIgnore
	private User user;

	//bi-directional many-to-one association to WeeklyMomDetail
	@OneToMany(mappedBy="weeklyMom")
	private List<WeeklyMomDetail> weeklyMomDetails;

	public WeeklyMom() {
	}

	public int getMomId() {
		return this.momId;
	}

	public void setMomId(int momId) {
		this.momId = momId;
	}

	public Date getMomDate() {
		return this.momDate;
	}

	public void setMomDate(Date momDate) {
		this.momDate = momDate;
	}

	public Time getMomTime() {
		return this.momTime;
	}

	public void setMomTime(Time momTime) {
		this.momTime = momTime;
	}

	public String getMomTopic() {
		return this.momTopic;
	}

	public void setMomTopic(String momTopic) {
		this.momTopic = momTopic;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<WeeklyMomDetail> getWeeklyMomDetails() {
		return this.weeklyMomDetails;
	}

	public void setWeeklyMomDetails(List<WeeklyMomDetail> weeklyMomDetails) {
		this.weeklyMomDetails = weeklyMomDetails;
	}

	public WeeklyMomDetail addWeeklyMomDetail(WeeklyMomDetail weeklyMomDetail) {
		getWeeklyMomDetails().add(weeklyMomDetail);
		weeklyMomDetail.setWeeklyMom(this);

		return weeklyMomDetail;
	}

	public WeeklyMomDetail removeWeeklyMomDetail(WeeklyMomDetail weeklyMomDetail) {
		getWeeklyMomDetails().remove(weeklyMomDetail);
		weeklyMomDetail.setWeeklyMom(null);

		return weeklyMomDetail;
	}

}