package com.accenture.bootcamp.legalspy.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.accenture.bootcamp.legalspy.model.EmployeeFeedback;
import com.accenture.bootcamp.legalspy.model.EmployeeFeedbackManager;

@Controller
public class CompletedFormsController {

	@RequestMapping(value = { "/completedForms" }, method = RequestMethod.GET)
	public String completedForms(Model model) throws SQLException {
		int id = MainController.getIdByEmail();
		
		EmployeeFeedbackManager efm = new EmployeeFeedbackManager();
		List<EmployeeFeedback> feedbacks = efm.findEmployeeFeedbacksFrom(id);
		
		model.addAttribute("feedbacks", feedbacks);
		
		
		return "completedForms";
	}
}
