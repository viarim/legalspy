package com.accenture.bootcamp.legalspy.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import com.accenture.bootcamp.legalspy.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class EmployeeListController {

	@RequestMapping(value = { "/employeeList" }, method = RequestMethod.GET)
	public String employeeList(Model model) throws SQLException {
				
		EmployeeManager e = new EmployeeManager();
		List<Employee> emps = e.findEmployees();
		
		model.addAttribute("employees", emps);
			
		
		
		return "employeeList";

	}

	
	
}