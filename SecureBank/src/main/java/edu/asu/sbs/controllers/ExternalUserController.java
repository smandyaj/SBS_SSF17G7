package edu.asu.sbs.controllers;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.asu.sbs.model.ExternalUser;
import edu.asu.sbs.model.InternalUser;
import edu.asu.sbs.services.ExternalUserService;


public class ExternalUserController {
	
	@Autowired
	private ExternalUserService externalUserService;
	
	@RequestMapping(value = "/customer/profile", method = RequestMethod.GET) // "/customer/{id}/profile"
	public ModelAndView showUpdateCustomerForm() {
		ModelAndView modelAndView = new ModelAndView("CustomerProfile");
		//ExternalUser extUser=externalUserService.get
		//@SuppressWarnings("rawtypes")
		//ExternalUser externalUser = externalUserService.findUserById(id);
		//modelAndView.addObject("customer", "exists");
		//model.addAttribute("employeeForm", externalUser);
		
		System.out.println("Customer Page");

		return modelAndView;
	}
	
	@RequestMapping(value="/customer/makeTransfer",method=RequestMethod.POST)
	public ModelAndView makeTransfer() {
		ModelAndView modelAndView = new ModelAndView("ExtUserTransfer");
		
		
		System.out.println("Make Transfer Page");
		return modelAndView;
	}
	
	@RequestMapping(value="/extUser/extUser-add")
	public ModelAndView addInternalUserPage() {
		System.out.println("Add new user page");
		ModelAndView modelAndView = new ModelAndView("registerUser");
		modelAndView.addObject("extUser", "new");
		modelAndView.addObject("extUserForm", new ExternalUser());
		return modelAndView;
	}
	
	@RequestMapping(value="/customer/customer-add")
	public ModelAndView addingCustomer(@ModelAttribute ExternalUser externalUser) {
		System.out.println("Adding new user and redirecting" + externalUser.getPasswordHash());
		/*java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		externalUser.setCreationDate(date);
		externalUser.setLastLogin(date);*/
		
		if( externalUser.getCustomerId() == 0) {
			System.out.println("Add User" + externalUser.getCustomerId());
			externalUserService.addUser(externalUser);	
		}else {
			System.out.println("Modify User" + externalUser.getCustomerId());
			externalUserService.updateUser(externalUser);
		}
		ModelAndView modelAndView = new ModelAndView("login");//redirect to login page
		System.out.println("All Users Page");
		return modelAndView;
	}
	
	@RequestMapping(value="/customer/transactionMgmt",method=RequestMethod.POST)
	public ModelAndView transactionMgmt() {
		ModelAndView modelAndView = new ModelAndView("ExtUserTransactionMgmt");
		
		
		System.out.println("Transaction Mgmt Page");
		return modelAndView;
	
	}
}
