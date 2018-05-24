package com.cybage.tes.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the mentees database table.
 * 
 */
@Entity
@Table(name="mentees")
@NamedQuery(name="Mentee.findAll", query="SELECT m FROM Mentee m")
public class Mentee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mentee_id")
	private int menteeId;

	private String email;

	@Column(name="mentee_name")
	private String menteeName;

	private String technology;

	//bi-directional many-to-one association to CommunicationEvaluation
	@OneToMany(mappedBy="mentee")
	private List<CommunicationEvaluation> communicationEvaluations;

	//bi-directional many-to-one association to FinalMentorEvaluation
	@OneToMany(mappedBy="mentee")
	private List<FinalMentorEvaluation> finalMentorEvaluations;

	//bi-directional many-to-one association to FinalReport
	@OneToMany(mappedBy="mentee")
	private List<FinalReport> finalReports;

	//bi-directional many-to-one association to Group
	@ManyToOne
	@JoinColumn(name="group_id")
	@JsonIgnore
	private Groups groups;

	//bi-directional many-to-one association to Ott
	@OneToMany(mappedBy="mentee")
	private List<Ott> otts;

	//bi-directional many-to-one association to ProjectVivaEvaluation
	@OneToMany(mappedBy="mentee")
	private List<ProjectVivaEvaluation> projectVivaEvaluations;

	//bi-directional many-to-one association to WeeklyMomDetail
	@OneToMany(mappedBy="mentee")
	private List<WeeklyMomDetail> weeklyMomDetails;

	public Mentee() {
	}

	public int getMenteeId() {
		return this.menteeId;
	}

	public void setMenteeId(int menteeId) {
		this.menteeId = menteeId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMenteeName() {
		return this.menteeName;
	}

	public void setMenteeName(String menteeName) {
		this.menteeName = menteeName;
	}

	public String getTechnology() {
		return this.technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public List<CommunicationEvaluation> getCommunicationEvaluations() {
		return this.communicationEvaluations;
	}

	public void setCommunicationEvaluations(List<CommunicationEvaluation> communicationEvaluations) {
		this.communicationEvaluations = communicationEvaluations;
	}

	public CommunicationEvaluation addCommunicationEvaluation(CommunicationEvaluation communicationEvaluation) {
		getCommunicationEvaluations().add(communicationEvaluation);
		communicationEvaluation.setMentee(this);

		return communicationEvaluation;
	}

	public CommunicationEvaluation removeCommunicationEvaluation(CommunicationEvaluation communicationEvaluation) {
		getCommunicationEvaluations().remove(communicationEvaluation);
		communicationEvaluation.setMentee(null);

		return communicationEvaluation;
	}

	public List<FinalMentorEvaluation> getFinalMentorEvaluations() {
		return this.finalMentorEvaluations;
	}

	public void setFinalMentorEvaluations(List<FinalMentorEvaluation> finalMentorEvaluations) {
		this.finalMentorEvaluations = finalMentorEvaluations;
	}

	public FinalMentorEvaluation addFinalMentorEvaluation(FinalMentorEvaluation finalMentorEvaluation) {
		getFinalMentorEvaluations().add(finalMentorEvaluation);
		finalMentorEvaluation.setMentee(this);

		return finalMentorEvaluation;
	}

	public FinalMentorEvaluation removeFinalMentorEvaluation(FinalMentorEvaluation finalMentorEvaluation) {
		getFinalMentorEvaluations().remove(finalMentorEvaluation);
		finalMentorEvaluation.setMentee(null);

		return finalMentorEvaluation;
	}

	public List<FinalReport> getFinalReports() {
		return this.finalReports;
	}

	public void setFinalReports(List<FinalReport> finalReports) {
		this.finalReports = finalReports;
	}

	public FinalReport addFinalReport(FinalReport finalReport) {
		getFinalReports().add(finalReport);
		finalReport.setMentee(this);

		return finalReport;
	}

	public FinalReport removeFinalReport(FinalReport finalReport) {
		getFinalReports().remove(finalReport);
		finalReport.setMentee(null);

		return finalReport;
	}

	public Groups getGroups() {
		return this.groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}

	public List<Ott> getOtts() {
		return this.otts;
	}

	public void setOtts(List<Ott> otts) {
		this.otts = otts;
	}

	public Ott addOtt(Ott ott) {
		getOtts().add(ott);
		ott.setMentee(this);

		return ott;
	}

	public Ott removeOtt(Ott ott) {
		getOtts().remove(ott);
		ott.setMentee(null);

		return ott;
	}

	public List<ProjectVivaEvaluation> getProjectVivaEvaluations() {
		return this.projectVivaEvaluations;
	}

	public void setProjectVivaEvaluations(List<ProjectVivaEvaluation> projectVivaEvaluations) {
		this.projectVivaEvaluations = projectVivaEvaluations;
	}

	public ProjectVivaEvaluation addProjectVivaEvaluation(ProjectVivaEvaluation projectVivaEvaluation) {
		getProjectVivaEvaluations().add(projectVivaEvaluation);
		projectVivaEvaluation.setMentee(this);

		return projectVivaEvaluation;
	}

	public ProjectVivaEvaluation removeProjectVivaEvaluation(ProjectVivaEvaluation projectVivaEvaluation) {
		getProjectVivaEvaluations().remove(projectVivaEvaluation);
		projectVivaEvaluation.setMentee(null);

		return projectVivaEvaluation;
	}

	public List<WeeklyMomDetail> getWeeklyMomDetails() {
		return this.weeklyMomDetails;
	}

	public void setWeeklyMomDetails(List<WeeklyMomDetail> weeklyMomDetails) {
		this.weeklyMomDetails = weeklyMomDetails;
	}

	public WeeklyMomDetail addWeeklyMomDetail(WeeklyMomDetail weeklyMomDetail) {
		getWeeklyMomDetails().add(weeklyMomDetail);
		weeklyMomDetail.setMentee(this);

		return weeklyMomDetail;
	}

	public WeeklyMomDetail removeWeeklyMomDetail(WeeklyMomDetail weeklyMomDetail) {
		getWeeklyMomDetails().remove(weeklyMomDetail);
		weeklyMomDetail.setMentee(null);

		return weeklyMomDetail;
	}

}