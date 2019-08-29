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


	public EmployeeManager() {
		
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

	public Employee findEmployee(int id) throws SQLException {

		Employee employee = null;
		List<String> education = new ArrayList<String>();
		try {
			this.createConnection();
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
				
				// TO BE REMOVED
				System.out.println(employee);
				
				pstmt = conn.prepareStatement("select * from internal_enterprise_system.Education "
						+ " where internal_enterprise_system.Education.fk_employee = ?");
				pstmt.setInt(1, employee.getId());
				rs = pstmt.executeQuery();
				conn.commit();
				
				while (rs.next()) {
					education.add(rs.getString("description"));
				}
				employee.setEducation(education);
				
				// TO BE REMOVED
				for (String s : employee.getEducation()) {
					System.out.println("\t Education: " + s);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
			this.closeConnecion();
		}
		
		return employee;
	}
	
	
	public String login(String email) throws SQLException {

		String password = "";
		try {
			this.createConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("select id, name, surname, fk_access_level, password from internal_enterprise_system.Employees "
					+ " where internal_enterprise_system.Employees.email = ?");
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			conn.commit();
			
			if (rs.next()) {
				
				password = rs.getString("password");
			}

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
			this.closeConnecion();
		}
		
		return password;
	}
	
	
	
	public List<Employee> findEmployees() throws SQLException {
		
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee = null;
		
		try {
			
			this.createConnection();
			conn.setAutoCommit(false);
			
			PreparedStatement pstmt = conn.prepareStatement("select * from internal_enterprise_system.Employees "
					+ " INNER JOIN internal_enterprise_system.Roles ON internal_enterprise_system.Employees.fk_role=internal_enterprise_system.Roles.id"
					+ " INNER JOIN internal_enterprise_system.Access_levels ON internal_enterprise_system.Employees.fk_access_level=internal_enterprise_system.Access_levels.id");
			ResultSet rs = pstmt.executeQuery();
			conn.commit();
			
			while (rs.next()) {
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
				
				
				employees.add(employee);
			}
			
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
			this.closeConnecion();
		}
		
		// TO BE REMOVED
		for(Employee e : employees) {
			System.out.println(e);
		}
		return employees;
	}
	
	
	public boolean insertEmployee(Employee employee) throws SQLException {
		
		boolean result = false;
		try {
			this.createConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into internal_enterprise_system.Employees (id, name, surname, person_code, email, password, fk_access_level, fk_role) values (?, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, 0);
			pstmt.setString(2, employee.getName());
			pstmt.setString(3, employee.getSurname());
			pstmt.setString(4, employee.getPersonCode());
			pstmt.setString(5, employee.getPassword());
			pstmt.setString(6, employee.getEmail());
			pstmt.setInt(7, employee.getAccessLevelID());
			pstmt.setInt(8, employee.getRoleID());
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
	
	
	public boolean updateEmployee(Employee employee) throws SQLException {
		boolean status = false;
		
		try {
			this.createConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("update internal_enterprise_system.Employees "
					+ "set name = ?, surname = ?, person_code = ?, email = ?, password = ?, fk_access_level = ?, fk_role = ? "
					+ "where id= ?");
			pstmt.setString(1, employee.getName());
			pstmt.setString(2, employee.getSurname());
			pstmt.setString(3, employee.getPersonCode());
			pstmt.setString(4, employee.getEmail());
			pstmt.setString(5, employee.getPassword());
			pstmt.setInt(6, employee.getAccessLevelID());
			pstmt.setInt(7, employee.getRoleID());
			pstmt.setInt(8, employee.getId());
			int result = pstmt.executeUpdate();
			conn.commit();
			if (result > 0) status = true;
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
			this.closeConnecion();
		}
		return status;
	}
	
	
	public boolean deleteEmployee(int id) throws SQLException {
		boolean result = false;
		
		try {
			this.createConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from internal_enterprise_system.Employees where id = ?");
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
		
		EmployeeManager e = new EmployeeManager();
		e.findEmployee(1);
		
		Employee employee = new Employee(0, "testname", "testsurname", "testpersonCode", "testemail", "testpassword", 1, "testaccessLevel", 1, "testrole");
		if (e.insertEmployee(employee)) {
			System.out.println("SUCCESS");
		} else {
			System.out.println("FAILED");
		}
		e.findEmployees();
		
		System.out.println("__________________________________________________________");
		int id = employee.getId();
		employee = new Employee(1985, "test", "test", "test", "test", "test", 1, "test", 1, "test");
		if (e.updateEmployee(employee)) {
			System.out.println("SUCCESS");
		} else {
			System.out.println("FAILED");
		}
		e.findEmployees();
		
		System.out.println("__________________________________________________________");
		if (e.deleteEmployee(1985)) {
			System.out.println("SUCCESS");
		} else {
			System.out.println("FAILED");
		}
		e.findEmployees();
		

		System.out.println(e.login("exmpl@example.com"));
	}
	
}
