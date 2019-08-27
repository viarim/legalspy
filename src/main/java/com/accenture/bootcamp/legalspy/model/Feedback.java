/**
 * 
 */
package com.accenture.bootcamp.legalspy.model;

/**
 * @Useless info
 *
 */
public class Feedback {
	private int generalWorkQuality;
	private int dependability;
	private int areaKnowledge;
	private int communicationSkills;
	private int managementSkills;
	private int contribution;
	private int productivity;
	private String strongPoints;
	private String weakPoints;
	private String commentVarchar;

	public Feedback(int generalWorkQuality, int dependability, int areaKnowledge, int communicationSkills,
			int managementSkills, int contribution, int productivity, String strongPoints, String weakPoints,
			String commentVarchar) {
		this.generalWorkQuality = generalWorkQuality;
		this.dependability = dependability;
		this.areaKnowledge = areaKnowledge;
		this.communicationSkills = communicationSkills;
		this.managementSkills = managementSkills;
		this.contribution = contribution;
		this.productivity = productivity;
		this.strongPoints = strongPoints;
		this.weakPoints = weakPoints;
		this.commentVarchar = commentVarchar;
	}

	public int getGeneralWorkQuality() {
		return generalWorkQuality;
	}

	public void setGeneralWorkQuality(int generalWorkQuality) {
		this.generalWorkQuality = generalWorkQuality;
	}

	public int getDependability() {
		return dependability;
	}

	public void setDependability(int dependability) {
		this.dependability = dependability;
	}

	public int getAreaKnowledge() {
		return areaKnowledge;
	}

	public void setAreaKnowledge(int areaKnowledge) {
		this.areaKnowledge = areaKnowledge;
	}

	public int getCommunicationSkills() {
		return communicationSkills;
	}

	public void setCommunicationSkills(int communicationSkills) {
		this.communicationSkills = communicationSkills;
	}

	public int getManagementSkills() {
		return managementSkills;
	}

	public void setManagementSkills(int managementSkills) {
		this.managementSkills = managementSkills;
	}

	public int getContribution() {
		return contribution;
	}

	public void setContribution(int contribution) {
		this.contribution = contribution;
	}

	public int getProductivity() {
		return productivity;
	}

	public void setProductivity(int productivity) {
		this.productivity = productivity;
	}

	public String getStrongPoints() {
		return strongPoints;
	}

	public void setStrongPoints(String strongPoints) {
		this.strongPoints = strongPoints;
	}

	public String getWeakPoints() {
		return weakPoints;
	}

	public void setWeakPoints(String weakPoints) {
		this.weakPoints = weakPoints;
	}

	public String getCommentVarchar() {
		return commentVarchar;
	}

	public void setCommentVarchar(String commentVarchar) {
		this.commentVarchar = commentVarchar;
	}

	@Override
	public String toString() {
		return "Feedback [generalWorkQuality=" + generalWorkQuality + ", dependability=" + dependability
				+ ", areaKnowledge=" + areaKnowledge + ", communicationSkills=" + communicationSkills
				+ ", managementSkills=" + managementSkills + ", contribution=" + contribution + ", productivity="
				+ productivity + ", strongPoints=" + strongPoints + ", weakPoints=" + weakPoints + ", commentVarchar="
				+ commentVarchar + "]";
	}

	
}
