package edu.asu.sbs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String renderIndex(){
		return "index";
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String renderExternalLogin(){
		return "CustomerLogin";
	}
	
	@RequestMapping(value="/customerRedirect",method = RequestMethod.POST)
	public String redirectCustomer() {
		return "CustomerDashboard";
	}
	
	@RequestMapping(value="/internal", method = RequestMethod.GET)
	public String renderInternalLogin(){
		return "EmployeeLogin";
	}
}
