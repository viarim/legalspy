package com.accenture.bootcamp.legalspy.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accenture.bootcamp.legalspy.model.Employee;

public class EmployeeManager {

	
	protected Connection conn;


	public EmployeeManager() throws SQLException {
		
		conn = null;
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

	public Employee findEmployee(int id) throws SQLException {

		Employee employee = null;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("select * from internal_enterprise_system.Employees "
					+ " INNER JOIN internal_enterprise_system.Roles ON internal_enterprise_system.Employees.fk_role=internal_enterprise_system.Roles.id"
					+ " INNER JOIN internal_enterprise_system.Access_levels ON internal_enterprise_system.Employees.fk_access_level=internal_enterprise_system.Access_levels.id"
					+ " where internal_enterprise_system.Employees.id = ?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			conn.commit();
			
			if (rs.next()) {
				employee = new Employee(rs.getInt("id"), 
										rs.getString("name"), 
										rs.getString("surname"),
										rs.getString("person_code"),
										rs.getString("email"),
										rs.getString("password"),
										rs.getInt("fk_access_level"),
										rs.getString("level"),
										rs.getInt("fk_role"),
										rs.getString("role"));
				
				System.out.println(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
		}
		
		return employee;
	}
	
	public static void main(String args[]) throws SQLException {
		
		EmployeeManager e = new EmployeeManager();
		e.findEmployee(1);
		
	}
	
}
