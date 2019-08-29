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
import com.accenture.bootcamp.legalspy.model.EmployeeFeedback;
import com.accenture.bootcamp.legalspy.model.EmployeeFeedbackManager;
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
	}


	 @RequestMapping(value = { "/feedbackForm" }, method = RequestMethod.POST)
		public String teamFive(
				Model model,
				@RequestParam(value = "userTo", required = false) String userTo,
				@RequestParam(value = "userFrom", required = false) String userFrom,
				@RequestParam(value = "projectTo", required = false) String projectTo,
				@RequestParam(value = "general_work_quality", required = false) String generalWorkQuality,
				@RequestParam(value = "dependability", required = false) String dependability,
				@RequestParam(value = "area_knowledge", required = false) String areaKnowledge,
				@RequestParam(value = "communication_skills", required = false) String communicationSkills,
				@RequestParam(value = "management_skills", required = false) String managementSkills,
				@RequestParam(value = "contribution", required = false) String contribution,
				@RequestParam(value = "personality", required = false) String personality,
				@RequestParam(value = "productivity", required = false) String productivity,
				@RequestParam(value = "strong_points", required = false) String strongPoints,
				@RequestParam(value = "weak_points", required = false) String weakPoints,
				@RequestParam(value = "comment", required = false) String comment
				) throws SQLException 
	    {
		 	
		 	EmployeeFeedbackManager efm = new EmployeeFeedbackManager();
		 	EmployeeFeedback ef = new EmployeeFeedback(0, Integer.parseInt(userTo), Integer.parseInt(userFrom), Integer.parseInt(projectTo), "", 
		 			Integer.parseInt(generalWorkQuality), Integer.parseInt(dependability), 
		 			Integer.parseInt(areaKnowledge), Integer.parseInt(communicationSkills), Integer.parseInt(personality), 
		 			Integer.parseInt(managementSkills), Integer.parseInt(contribution), 
		 			Integer.parseInt(productivity), strongPoints, weakPoints, comment);
		 	
		 	
		 	if (efm.insertEmployeeFeedback(ef)) {
		 		return "redirect:/completedForms";
		 	} else {
		 		return "feedbackForm?id=" + userTo;
		 	}

	    }

}