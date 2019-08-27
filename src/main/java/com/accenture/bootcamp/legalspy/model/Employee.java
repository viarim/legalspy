package com.accenture.bootcamp.legalspy.model;

import java.util.List;

public class Employee {

	
	private int id;
	private String name;
	private String surname;
	private String personCode;
	private String email;
	private String password;
	private int accessLevelID;
	private String accessLevel;
	private int roleID;
	private String role;
	private List<String> education;
	
	
	public Employee(int id, 
					String name, 
					String surname,
					String personCode,
					String email,
					String password,
					int accessLevelID,
					String accessLevel,
					int roleID,
					String role) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.personCode = personCode;
		this.email = email;
		this.password = password;
		this.accessLevelID = accessLevelID;
		this.accessLevel = accessLevel;
		this.roleID = roleID;
		this.role = role;
	}


	public List<String> getEducation() {
		return education;
	}


	public void setEducation(List<String> education) {
		this.education = education;
	}


	public String getAccessLevel() {
		return accessLevel;
	}


	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getPersonCode() {
		return personCode;
	}


	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getAccessLevelID() {
		return accessLevelID;
	}


	public void setAccessLevelID(int accessLevelID) {
		this.accessLevelID = accessLevelID;
	}


	public int getRoleID() {
		return roleID;
	}


	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}


	public String toString() {
		return "Employee: \nid: " + id + ",\n name: " + name + ",\n surname: " + surname + ",\n personCode: " + personCode
				+ ",\n email: " + email + ",\n password: " + password + ",\n accessLevelID: " + accessLevelID + ",\n accessLevel: "
				+ accessLevel + ",\n roleID: " + roleID + ",\n role: " + role;
	}
	
	

	
}
