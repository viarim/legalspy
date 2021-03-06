package com.accenture.bootcamp.legalspy.controller;

import com.accenture.bootcamp.legalspy.form.PersonForm;
import com.accenture.bootcamp.legalspy.model.EmployeeManager;
import com.accenture.bootcamp.legalspy.model.Person;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
 
    private static List<Person> persons = new ArrayList<Person>();
 
    static {
        persons.add(new Person("Bill", "Gates"));
        persons.add(new Person("Steve", "Jobs"));
    }
 
    // Inject via application.properties
    @Value("${welcome.message}")
    private String message;
 
    @Value("${error.message}")
    private String errorMessage;
 
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String home(Model model) throws SQLException { 
       
    	model.addAttribute("message", message);
        model.addAttribute("loggedUserId", getIdByEmail()); 
        
        return "home"; //show template index.html
    }
 
    /**
     * This method return user ID  by given email. We need to translate this, because 
     * email is used as a login name for the user. 
     * User ID then is used to retrieve data for particular user within this application.
     */
    public static int getIdByEmail() throws SQLException {
    	EmployeeManager em = new EmployeeManager();
		return Integer.parseInt(em.getIdByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
	}

	@RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
    public String personList(Model model) {
 
        model.addAttribute("persons", persons);
 
        return "personList";
    }
 
    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {
 
        PersonForm personForm = new PersonForm();
        model.addAttribute("personForm", personForm);
 
        return "addPerson";
    }
 
    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.POST)
    public String savePerson(Model model, //
            @ModelAttribute("personForm") PersonForm personForm) {
 
        String firstName = personForm.getFirstName();
        String lastName = personForm.getLastName();
 
        if (firstName != null && firstName.length() > 0 //
                && lastName != null && lastName.length() > 0) {
            Person newPerson = new Person(firstName, lastName);
            persons.add(newPerson);
 
            return "redirect:/personList";
        }
 
        model.addAttribute("errorMessage", errorMessage);
        return "addPerson";
    }
 
}