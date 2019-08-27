package com.accenture.bootcamp.legalspy.model;

import java.util.List;

public class EmployeeFeedback {

	private int id;
	private int employeeToID;
	private int employeeFromID;
	private int projectID;
	private String dateTime;
	private int rateWorkQuality;
	private int rateDependability;
	private int rateAreaKnowledge;
	private int rateCommunicationSkills;
	private int ratePersonality;
	private int rateManagementSkills;
	private int rateContribution;
	private int rateProductivity;
	private String strongPoints;
	private String weakPoint;
	private String comment;
	private List<String> comments;
	
	
	public EmployeeFeedback(int id, int employeeToID, int employeeFromID, int projectID, String dateTime,
			int rateWorkQuality, int rateDependability, int rateAreaKnowledge, int rateCommunicationSkills,
			int ratePersonality, int rateManagementSkills, int rateContribution, int rateProductivity,
			String strongPoints, String weakPoint, String comment) {
		super();
		this.id = id;
		this.employeeToID = employeeToID;
		this.employeeFromID = employeeFromID;
		this.projectID = projectID;
		this.dateTime = dateTime;
		this.rateWorkQuality = rateWorkQuality;
		this.rateDependability = rateDependability;
		this.rateAreaKnowledge = rateAreaKnowledge;
		this.rateCommunicationSkills = rateCommunicationSkills;
		this.ratePersonality = ratePersonality;
		this.rateManagementSkills = rateManagementSkills;
		this.rateContribution = rateContribution;
		this.rateProductivity = rateProductivity;
		this.strongPoints = strongPoints;
		this.weakPoint = weakPoint;
		this.comment = comment;
		this.comments = null;
	}
	
	public List<String> getComments() {
		return comments;
	}
	public void setComments(List<String> comments) {
		this.comments = comments;
	}


	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployeeToID() {
		return employeeToID;
	}
	public void setEmployeeToID(int employeeToID) {
		this.employeeToID = employeeToID;
	}
	public int getEmployeeFromID() {
		return employeeFromID;
	}
	public void setEmployeeFromID(int employeeFromID) {
		this.employeeFromID = employeeFromID;
	}
	public int getProjectID() {
		return projectID;
	}
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public int getRateWorkQuality() {
		return rateWorkQuality;
	}
	public void setRateWorkQuality(int rateWorkQuality) {
		this.rateWorkQuality = rateWorkQuality;
	}
	public int getRateDependability() {
		return rateDependability;
	}
	public void setRateDependability(int rateDependability) {
		this.rateDependability = rateDependability;
	}
	public int getRateAreaKnowledge() {
		return rateAreaKnowledge;
	}
	public void setRateAreaKnowledge(int rateAreaKnowledge) {
		this.rateAreaKnowledge = rateAreaKnowledge;
	}
	public int getRateCommunicationSkills() {
		return rateCommunicationSkills;
	}
	public void setRateCommunicationSkills(int rateCommunicationSkills) {
		this.rateCommunicationSkills = rateCommunicationSkills;
	}
	public int getRatePersonality() {
		return ratePersonality;
	}
	public void setRatePersonality(int ratePersonality) {
		this.ratePersonality = ratePersonality;
	}
	public int getRateManagementSkills() {
		return rateManagementSkills;
	}
	public void setRateManagementSkills(int rateManagementSkills) {
		this.rateManagementSkills = rateManagementSkills;
	}
	public int getRateContribution() {
		return rateContribution;
	}
	public void setRateContribution(int rateContribution) {
		this.rateContribution = rateContribution;
	}
	public int getRateProductivity() {
		return rateProductivity;
	}
	public void setRateProductivity(int rateProductivity) {
		this.rateProductivity = rateProductivity;
	}
	public String getStrongPoints() {
		return strongPoints;
	}
	public void setStrongPoints(String strongPoints) {
		this.strongPoints = strongPoints;
	}
	public String getWeakPoint() {
		return weakPoint;
	}
	public void setWeakPoint(String weakPoint) {
		this.weakPoint = weakPoint;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}


	public String toString() {
		return "EmployeeFeedback id: " + id + ",\n employeeToID: " + employeeToID + ",\n employeeFromID: " + employeeFromID
				+ ",\n projectID: " + projectID + ",\n dateTime: " + dateTime + ",\n rateWorkQuality: " + rateWorkQuality
				+ ",\n rateDependability: " + rateDependability + ",\n rateAreaKnowledge: " + rateAreaKnowledge
				+ ",\n rateCommunicationSkills: " + rateCommunicationSkills + ",\n ratePersonality: " + ratePersonality
				+ ",\n rateManagementSkills: " + rateManagementSkills + ",\n rateContribution: " + rateContribution
				+ ",\n rateProductivity: " + rateProductivity + ",\n strongPoints: " + strongPoints + ",\n weakPoint: "
				+ weakPoint + ",\n comment: " + comment;
	}
	
}
