package com.accenture.bootcamp.legalspy.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
public class AddEmployeeController {

	@RequestMapping(value = { "/addEmployee" }, method = RequestMethod.GET)
	public String addEmployee(Model model) throws SQLException {
		RoleManager rm = new RoleManager();
		List<Role> roles = rm.findRoles();
		
		AccessLevelManager alm = new AccessLevelManager();
		List<AccessLevel> aLevels = alm.findAccessLevels();
		
		model.addAttribute("roles", roles);
		model.addAttribute("accessLevels" , aLevels);
		
		return "addEmployee";
	}
	

	@RequestMapping(value = { "/addEmployee" }, method = RequestMethod.POST)
	public String addEmployee(Model model,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "surname", required = false) String surname,
			@RequestParam(value = "personCode", required = false) String personCode,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "rPassword", required = false) String rPassword,
			@RequestParam(value = "accessLevel", required = false) String accessLevel,
			@RequestParam(value = "role", required = false) String role) throws SQLException {
	
		
		
		
		EmployeeManager e = new EmployeeManager();
		Employee emp = new Employee(0, name, surname, personCode, email, password, 
						Integer.parseInt(accessLevel), Integer.parseInt(role));
		
		System.out.println(emp);
		System.out.println(rPassword);
		
		if (password.equals(rPassword)) {
			e.insertEmployee(emp);
			return "redirect:/employeeList";
		} else {
			return "redirect:/addEmployee";
		}        
	}
	
}
