package com.accenture.bootcamp.legalspy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeamFive {

	@RequestMapping(value = { "/teamFive" }, method = RequestMethod.GET)
	public String teamFive(
			Model model,
			@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "doc", required = false) String doc
			) 
    {
	
		model.addAttribute("myVariable", "This is my string (in GET mode)");
		model.addAttribute("myId", id);
		model.addAttribute("myDoc", doc);
		
		return "teamFive/teamFive"; // show this VIEW (html): folder/filename.html VIEW
    }
    
    @RequestMapping(value = { "/teamFive" }, method = RequestMethod.POST)
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