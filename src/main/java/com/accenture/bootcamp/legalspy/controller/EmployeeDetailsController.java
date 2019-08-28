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

import com.accenture.bootcamp.legalspy.model.Employee;
import com.accenture.bootcamp.legalspy.model.EmployeeManager;

@Controller
public class EmployeeDetailsController {

	@RequestMapping(value = { "/employeeDetails" }, method = RequestMethod.GET)
	public String employeeDetails(Model model, @RequestParam(value = "id", required = false) String id) throws SQLException {
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
			
		
		return "employeeDetails";
	}
}
