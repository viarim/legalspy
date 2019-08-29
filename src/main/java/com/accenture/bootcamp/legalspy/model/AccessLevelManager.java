package com.accenture.bootcamp.legalspy.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccessLevelManager {
	protected Connection conn;


	public AccessLevelManager() {
		
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
	
	public List<AccessLevel> findAccessLevels() throws SQLException {
		
		List<AccessLevel> accessLevels = new ArrayList<AccessLevel>();
		AccessLevel accessLevel = null;
		
		try {
			
			this.createConnection();
			conn.setAutoCommit(false);
			
			PreparedStatement pstmt = conn.prepareStatement("select * from internal_enterprise_system.Access_levels");
			ResultSet rs = pstmt.executeQuery();
			conn.commit();
			
			while (rs.next()) {
				accessLevel = new AccessLevel(rs.getInt("id"), rs.getString("level"));
				
				
				accessLevels.add(accessLevel);
			}
			
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
			this.closeConnecion();
		}

		return accessLevels;
	}
	
	public void closeConnecion() {
		try {
			conn.close();
		} catch (SQLException e) {	} 
		conn = null;
	}
}
