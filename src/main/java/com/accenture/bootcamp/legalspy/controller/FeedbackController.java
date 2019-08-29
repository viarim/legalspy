/**
 * 
 */
package com.accenture.bootcamp.legalspy.controller;


import java.sql.SQLException;

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
public class FeedbackController {
@RequestMapping(value = { "/feedbackForm" }, method = RequestMethod.GET)
//public String feedbackForm(Model model) {
	public String feedbackForm(Model model, @RequestParam(value = "id", required = false) String id) throws SQLException {
	
	EmployeeManager e = new EmployeeManager();
	Employee emp = e.findEmployee(Integer.parseInt(id));
	model.addAttribute("employee", emp);
	
	int userId = MainController.getIdByEmail();
	model.addAttribute("loggedUserId", userId);

	return "feedbackForm";
}}

 

//	
//	 @RequestMapping(value = { "/feedbackForm" }, method = RequestMethod.POST)
//		public String teamFive(
//				Model model,
//				@RequestParam(value = "postparam", required = false) String postparam
//				) 
//	    {
//	    	model.addAttribute("myVariable", "This is my string (in POST mode)");
//	    	model.addAttribute("postParam", postparam);
//	    	return "teamFive/teamFive";
//	    }

