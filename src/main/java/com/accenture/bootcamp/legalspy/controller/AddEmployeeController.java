package com.accenture.bootcamp.legalspy.controller;

import java.sql.SQLException;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.accenture.bootcamp.legalspy.model.Employee;
import com.accenture.bootcamp.legalspy.model.EmployeeManager;

@Controller
public class AddEmployeeController {

	@RequestMapping(value = { "/addEmployee" }, method = RequestMethod.GET)
	public String addEmployee(Model model) {

		return "addEmployee";
	}
	

@RequestMapping(value = { "/addEmployee" }, method = RequestMethod.POST)
public String addEmployee(Model model, @RequestParam(value = "id", required = false) String id,
		@RequestParam(value = "name", required = false) String name,
		@RequestParam(value = "surname", required = false) String surname,
		@RequestParam(value = "personCode", required = false) String personCode,
		@RequestParam(value = "email", required = false) String email,
		@RequestParam(value = "password", required = false) String password,
		@RequestParam(value = "accessLevelID", required = false) String accessLevelID,
		@RequestParam(value = "accessLevel", required = false) String accessLevel,
		@RequestParam(value = "roleID", required = false) String roleID,
		@RequestParam(value = "role", required = false) String role) throws SQLException {

	EmployeeManager e = new EmployeeManager();
	Employee emp = new Employee(Integer.parseInt(id), name, surname, personCode, email, password, 
					Integer.parseInt(accessLevelID), accessLevel,Integer.parseInt(roleID),role);
     
	model.addAttribute("id", emp.getId());
	model.addAttribute("name",emp.getName());
	model.addAttribute("surname", emp.getSurname());
	model.addAttribute("personCode", emp.getPersonCode());
	model.addAttribute("email", emp.getEmail());
	model.addAttribute("password", emp.getPassword());
	model.addAttribute("accessLevelID",emp.getAccessLevelID());
	model.addAttribute("accessLevel", emp.getAccessLevel());
	model.addAttribute("roleID", emp.getRoleID());
	model.addAttribute("role", emp.getRole());
	

//        if (firstName != null && firstName.length() > 0 //
//                && lastName != null && lastName.length() > 0) {
//            Employee newEmployee = new Employee(id, name,surname,personCode,email,accessLevelID,accessLevel,roleID, role);
//            (persons)employees.add(newEmployee);
 
            return "redirect:/employeeList";
        }
	
}
