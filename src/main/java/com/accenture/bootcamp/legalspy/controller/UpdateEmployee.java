package com.accenture.bootcamp.legalspy.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.accenture.bootcamp.legalspy.model.AccessLevel;
import com.accenture.bootcamp.legalspy.model.AccessLevelManager;
import com.accenture.bootcamp.legalspy.model.Employee;
import com.accenture.bootcamp.legalspy.model.EmployeeManager;
import com.accenture.bootcamp.legalspy.model.Role;
import com.accenture.bootcamp.legalspy.model.RoleManager;

@Controller
public class UpdateEmployee {

	@RequestMapping(value = { "/updateEmployee" }, method = RequestMethod.GET)
	public String updateEmployee(
		Model model, 
		@RequestParam(value = "id", required = true) String id) 
		throws SQLException {
			EmployeeManager e = new EmployeeManager();
			Employee emp = e.findEmployee(Integer.parseInt(id));
			model.addAttribute("id", emp.getId());
			model.addAttribute("name", emp.getName());
			model.addAttribute("surname", emp.getSurname());
			model.addAttribute("personCode", emp.getPersonCode());
			model.addAttribute("email", emp.getEmail());
			model.addAttribute("accessLevelID", emp.getAccessLevelID());
			model.addAttribute("accessLevel", emp.getAccessLevel());
			model.addAttribute("roleID", emp.getRoleID());
			model.addAttribute("role", emp.getRole());
			model.addAttribute("education", emp.getEducationString());
			RoleManager rm = new RoleManager();
			List<Role> roles = rm.findRoles();
			
			AccessLevelManager alm = new AccessLevelManager();
			List<AccessLevel> aLevels = alm.findAccessLevels();
			
			model.addAttribute("roles", roles);
			model.addAttribute("accessLevels" , aLevels);
			return "updateEmployee";
	}
	
	@RequestMapping(value = { "/updateEmployee" }, method = RequestMethod.POST)
	public String doUpdateEmployee(
		Model model, 
		@RequestParam(value = "id", required = true) String id,
		@RequestParam(value = "name", required = false) String name,
		@RequestParam(value = "surname", required = false) String surname,
		@RequestParam(value = "personCode", required = false) String personCode,
		@RequestParam(value = "email", required = false) String email,
		@RequestParam(value = "password", required = false) String password,
		@RequestParam(value = "accessLevel", required = false) String accessLevel,
		@RequestParam(value = "role", required = false) String role) throws SQLException
	{
		// ToDo update employee in DB
		EmployeeManager e = new EmployeeManager();
		Employee emp = new Employee(Integer.parseInt(id), name, surname, personCode, email, password, 
						Integer.parseInt(accessLevel), Integer.parseInt(role));
		
		System.out.println(emp);
		
		if (e.updateEmployee(emp)) {
			return "redirect:/employeeDetails?id=" + id;
		} else {
			return "redirect:/updateEmployee?id=" + id;
		}
				
		
	}

}
