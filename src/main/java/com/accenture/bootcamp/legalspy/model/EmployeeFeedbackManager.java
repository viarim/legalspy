package com.accenture.bootcamp.legalspy.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFeedbackManager {

	protected Connection conn;

	public EmployeeFeedbackManager() {		
		conn = null;
	}
	
	public void createConnection() throws SQLException {
		
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/?autoReconnect=true&useSSL=false&characterEncoding=utf8",
					"root", 
					"Student007");
			conn.setAutoCommit(false);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
		}
		
	}

	public EmployeeFeedback findEmployeeFeedback(int id) throws SQLException {

		EmployeeFeedback employeeFeedback = null;
		List<String> comments = new ArrayList<String>();
		try {
			this.createConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("select * from internal_enterprise_system.Employee_feedbacks "
					+ " where internal_enterprise_system.Employee_feedbacks.id = ?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			conn.commit();
			
			if (rs.next()) {
				employeeFeedback = new EmployeeFeedback(rs.getInt("id"), 
									rs.getInt("fk_employee_to"),
									rs.getInt("fk_employee_from"),
									rs.getInt("fk_project"),
									rs.getString("date"),
									rs.getInt("general_work_quality"),
									rs.getInt("dependability"),
									rs.getInt("area_knowledge"),
									rs.getInt("communication_skills"),
									rs.getInt("personality"),
									rs.getInt("management_skills"),
									rs.getInt("contribution"),
									rs.getInt("productivity"),
									rs.getString("strong_points"),
									rs.getString("weak_points"),
									rs.getString("comment"));

				
				// TO BE REMOVED
				System.out.println(employeeFeedback);
				
				
				pstmt = conn.prepareStatement("select * from internal_enterprise_system.Employee_comments "
						+ " where internal_enterprise_system.Employee_comments.fk_employee_feedback_to = ?");
				pstmt.setInt(1, employeeFeedback.getId());
				rs = pstmt.executeQuery();
				conn.commit();
				
				while (rs.next()) {
					comments.add(rs.getString("comment"));
				}
				employeeFeedback.setComments(comments);
				
				// TO BE REMOVED
				for (String s : employeeFeedback.getComments()) {
					System.out.println("\t Additional comment: " + s);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
			this.closeConnecion();
		}
		
		return employeeFeedback;
	}
	
	
	
	public List<EmployeeFeedback> findEmployeeFeedbacks(int id) throws SQLException {
		
		List<EmployeeFeedback> employeeFeedbacks = new ArrayList<EmployeeFeedback>();
		EmployeeFeedback employeeFeedback = null;
		
		try {
			
			this.createConnection();
			conn.setAutoCommit(false);
			
			PreparedStatement pstmt = conn.prepareStatement(
					"select f.*, e.name, e.surname from internal_enterprise_system.Employee_feedbacks AS f,"
					+ " internal_enterprise_system.Employees as e"
					+ " where e.id=f.fk_employee_from"
					+ " and f.fk_employee_to = ?"
					);
			
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			conn.commit();
			
			while (rs.next()) {
				employeeFeedback = new EmployeeFeedback(rs.getInt("id"), 
						rs.getInt("fk_employee_to"),
						rs.getInt("fk_employee_from"),
						rs.getInt("fk_project"),
						rs.getString("date"),
						rs.getInt("general_work_quality"),
						rs.getInt("dependability"),
						rs.getInt("area_knowledge"),
						rs.getInt("communication_skills"),
						rs.getInt("personality"),
						rs.getInt("management_skills"),
						rs.getInt("contribution"),
						rs.getInt("productivity"),
						rs.getString("strong_points"),
						rs.getString("weak_points"),
						rs.getString("comment"),
						rs.getString("name"),
						rs.getString("surname")
						);				
				
				employeeFeedbacks.add(employeeFeedback);
			}
			
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
			this.closeConnecion();
		}
		
		// TO BE REMOVED
		for(EmployeeFeedback e : employeeFeedbacks) {
			System.out.println(e);
		}
		return employeeFeedbacks;
	}
	
	
	public boolean insertEmployeeFeedback(EmployeeFeedback employeeFeedback) throws SQLException {
		
		boolean result = false;
		try {
			this.createConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into internal_enterprise_system.Employee_feedbacks (id, fk_employee_to, fk_employee_from, fk_project, date, general_work_quality, dependability, area_knowledge, communication_skills, personality, management_skills, contribution, productivity, strong_points, weak_points, comment) values (?, ?, ?, ?, NOW(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, 0);
			pstmt.setInt(2, employeeFeedback.getEmployeeToID());
			pstmt.setInt(3, employeeFeedback.getEmployeeFromID());
			pstmt.setInt(4, employeeFeedback.getProjectID());
			pstmt.setInt(5, employeeFeedback.getRateWorkQuality());
			pstmt.setInt(6, employeeFeedback.getRateDependability());
			pstmt.setInt(7, employeeFeedback.getRateAreaKnowledge());
			pstmt.setInt(8, employeeFeedback.getRateCommunicationSkills());
			pstmt.setInt(9, employeeFeedback.getRatePersonality());
			pstmt.setInt(10, employeeFeedback.getRateManagementSkills());
			pstmt.setInt(11, employeeFeedback.getRateContribution());
			pstmt.setInt(12, employeeFeedback.getRateProductivity());
			pstmt.setString(13, employeeFeedback.getStrongPoints());
			pstmt.setString(14, employeeFeedback.getWeakPoint());
			pstmt.setString(15, employeeFeedback.getComment());
			
			int rs = pstmt.executeUpdate();
			if(rs > 0) result = true;
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
			this.closeConnecion();
		}
		return result;
	}
	
	
	public boolean updateEmployeeFeedback(EmployeeFeedback employeeFeedback) throws SQLException {
		boolean result = false;
		
		try {
			this.createConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("update internal_enterprise_system.Employee_feedbacks "
					+ "set fk_employee_to = ?, fk_employee_from = ?, fk_project = ?, general_work_quality = ?, dependability = ?, area_knowledge = ?, "
					+ "communication_skills = ?, personality = ?, management_skills = ?, contribution = ?, productivity = ?, strong_points = ?, "
					+ "weak_points = ?, comment = ? "
					+ " where id = ?");
			
			pstmt.setInt(1, employeeFeedback.getEmployeeToID());
			pstmt.setInt(2, employeeFeedback.getEmployeeFromID());
			pstmt.setInt(3, employeeFeedback.getProjectID());
			pstmt.setInt(4, employeeFeedback.getRateWorkQuality());
			pstmt.setInt(5, employeeFeedback.getRateDependability());
			pstmt.setInt(6, employeeFeedback.getRateAreaKnowledge());
			pstmt.setInt(7, employeeFeedback.getRateCommunicationSkills());
			pstmt.setInt(8, employeeFeedback.getRatePersonality());
			pstmt.setInt(9, employeeFeedback.getRateManagementSkills());
			pstmt.setInt(10, employeeFeedback.getRateContribution());
			pstmt.setInt(11, employeeFeedback.getRateProductivity());
			pstmt.setString(12, employeeFeedback.getStrongPoints());
			pstmt.setString(13, employeeFeedback.getWeakPoint());
			pstmt.setString(14, employeeFeedback.getComment());
			pstmt.setInt(15, employeeFeedback.getId());
			
			int rs = pstmt.executeUpdate();
			conn.commit();
			if (rs > 0) result = true;
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
			this.closeConnecion();
		}
		return result;
	}
	
	public boolean deleteEmployee(int id) throws SQLException {
		boolean result = false;
		
		try {
			this.createConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from internal_enterprise_system.Employee_feedbacks where id = ?");
			pstmt.setInt(1, id);
			int rs = pstmt.executeUpdate();
			if (rs > 0) result = true;
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
			this.closeConnecion();
		}
		return result;
	}

	public void closeConnecion() {
		try {
			conn.close();
		} catch (SQLException e) {	} 
		conn = null;
	}
	
	
	public static void main(String args[]) throws SQLException {
		
		EmployeeFeedbackManager e = new EmployeeFeedbackManager();
		e.findEmployeeFeedback(10);
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		e.findEmployeeFeedbacks(1);
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		e.findEmployeeFeedbacks(2);
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		e.findEmployeeFeedbacks(4);
		
		EmployeeFeedback efb = new EmployeeFeedback(0, 1, 2, 1, "", 5, 5, 5, 5, 5, 5, 5, 5, "polska strong", "kurwa", "perdalaj");
		if (e.insertEmployeeFeedback(efb)) {
			System.out.println("SUCCESS");
		} else {
			System.out.println("FAILED");
		}
		e.findEmployeeFeedbacks(1);
		
		
		System.out.println("==========================================");
		
		e.findEmployeeFeedbacks(4);
		
		EmployeeFeedback ef = new EmployeeFeedback(12, 1, 2, 1, "", 5, 5, 5, 5, 5, 5, 5, 5, "kurek", "kurek", "kurek kurek");
		if (e.updateEmployeeFeedback(ef)) {
			System.out.println("SUCCESS");
		} else {
			System.out.println("FAILED");
		}
		e.findEmployeeFeedbacks(1);
		
		System.out.println("-----------------------------------------------------------");
		
		e.findEmployeeFeedbacks(4);
		
		if (e.deleteEmployee(12)) {
			System.out.println("SUCCESS");
		} else {
			System.out.println("FAILED");
		}
		e.findEmployeeFeedbacks(1);
	}
	
}
