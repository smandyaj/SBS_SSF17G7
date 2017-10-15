package edu.asu.sbs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.asu.sbs.model.ExternalUser;
import edu.asu.sbs.services.ExternalUserService;


public class ExternalUserController {
	
	@Autowired
	private ExternalUserService externalUserService;
	
	
	
	@RequestMapping(value = "/customer/profile", method = RequestMethod.GET) // "/customer/{id}/profile"
	public ModelAndView showUpdateCustomerForm() {
		ModelAndView modelAndView = new ModelAndView("CustomerProfile");
		//@SuppressWarnings("rawtypes")
		//ExternalUser externalUser = externalUserService.findUserById(id);
		//modelAndView.addObject("customer", "exists");
		//model.addAttribute("employeeForm", externalUser);
		
		System.out.println("Customer Page");

		return modelAndView;
		

	}
}
