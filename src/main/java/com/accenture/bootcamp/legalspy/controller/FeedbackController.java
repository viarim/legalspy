/**
 * 
 */
package com.accenture.bootcamp.legalspy.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author student
 *TODODODO
 */
public class FeedbackController {
	 @RequestMapping(value = { "/feedbackForm" }, method = RequestMethod.POST)
		public String teamFive(
				Model model,
				@RequestParam(value = "postparam", required = false) String postparam
				) 
	    {
	    	model.addAttribute("myVariable", "This is my string (in POST mode)");
	    	model.addAttribute("postParam", postparam);
	    	return "teamFive/teamFive";
	    }
}
