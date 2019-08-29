package com.accenture.bootcamp.legalspy.controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.accenture.bootcamp.legalspy.model.Employee;
import com.accenture.bootcamp.legalspy.model.EmployeeFeedback;
import com.accenture.bootcamp.legalspy.model.EmployeeFeedbackManager;
import com.accenture.bootcamp.legalspy.model.EmployeeManager;

@Controller
public class LogbookController {
	
	public static float round(float d, int decimalPlace) {
	    BigDecimal bd = new BigDecimal(Float.toString(d));
	    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
	    return bd.floatValue();
	}

	@RequestMapping(value = { "/logbook" }, method = RequestMethod.GET)
	public String logbook(Model model) throws SQLException {
		
		int userId = MainController.getIdByEmail();
		model.addAttribute("loggedUserId", userId); 
		
		EmployeeFeedbackManager e = new EmployeeFeedbackManager();
		List<EmployeeFeedback> fbs = e.findEmployeeFeedbacks(userId);
		model.addAttribute("fbs", fbs);
		
		float score = 0;
		
		EmployeeFeedbackManager efm = new EmployeeFeedbackManager();
		List<EmployeeFeedback> efList = efm.findEmployeeFeedbacks(1);
       	for (EmployeeFeedback employeeFeedback : efList) {
       		score += employeeFeedback.getRateAreaKnowledge() + employeeFeedback.getRateCommunicationSkills() +
       				 employeeFeedback.getRateContribution() + employeeFeedback.getRateDependability() +
       				 employeeFeedback.getRateManagementSkills() + employeeFeedback.getRatePersonality() +
       				 employeeFeedback.getRateProductivity() + employeeFeedback.getRateWorkQuality();	
       	}
       	//score = score / (8 * efList.size());
		model.addAttribute("score", score);
		
		return "logbook";
	}
}
