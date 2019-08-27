package com.accenture.bootcamp.legalspy.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class EmployeeListController {

	@RequestMapping(value = { "/employeeList" }, method = RequestMethod.GET)
	public String employeeList(Model model) {

		return "employeeList";

	}

		@RequestMapping(value = { "/feedbackForm" }, method = RequestMethod.GET)
		public String feedbackForm(Model model) {

			return "feedbackForm";

	}
	
}