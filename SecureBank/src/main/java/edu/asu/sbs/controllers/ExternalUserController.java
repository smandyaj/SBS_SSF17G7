package edu.asu.sbs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.asu.sbs.model.Account;
import edu.asu.sbs.model.ExternalUser;
import edu.asu.sbs.model.ExternalUserSearch;
import edu.asu.sbs.model.InternalUser;
import edu.asu.sbs.model.ModifiedUser;
import edu.asu.sbs.services.AccountService;
import edu.asu.sbs.services.ExternalUserService;
import edu.asu.sbs.services.ModifiedUserService;


@Controller
public class ExternalUserController {
	
	
	@Autowired
	private ModifiedUserService modifiedUserService;
	
	@ModelAttribute
	public ExternalUserSearch getExternalUser() {
		return new ExternalUserSearch();
	}
	
	@Autowired
	private ExternalUserService externalUserService;
	
	@Autowired
	private AccountService accountService;
	
	
	@RequestMapping(value="/customer/home",method=RequestMethod.GET)
	public ModelAndView getCustomerHomePage() {
		return new ModelAndView("customerHome");
	}
	
	
	@RequestMapping(value="/customer/profile",method=RequestMethod.GET)
	public ModelAndView getCustomerProfile() {
		ModelAndView modelAndView = new ModelAndView("customer-profile");
		modelAndView.addObject("customerForm", externalUserService.findByUserName());
		return modelAndView;
		
	}
	
	@RequestMapping(value="/customer/modify-profile",method=RequestMethod.POST)
	public ModelAndView addModifiedProfile(@ModelAttribute ExternalUser externalUser) {
		ModelAndView modelAndView = new ModelAndView("customer-profile");
		System.out.println("User name to be modified ::" + externalUser.getFirstName());
		ModifiedUser modUser =new ModifiedUser(externalUser.getCustomerId(), externalUser.getFirstName(), externalUser.getLastName(), externalUser.getEmailId(), externalUser.getPhone(), externalUser.getCustomerAddress(), 0, "pending", 0);
		modifiedUserService.addUser(modUser);
		modelAndView.addObject("msg", "Profile has been submitted for approval");
		return modelAndView;
	}
	
	@RequestMapping(value="/customer/customer-transaction", method = RequestMethod.GET)
	public ModelAndView returnCustomerTransactionPage() {
		ModelAndView modelAndView  = new ModelAndView("customersearch");
		modelAndView.addObject("externalUser", getExternalUser());
		return modelAndView;
	}

	@RequestMapping(value="/customer/customer-transaction", method = RequestMethod.POST)
	public ModelAndView returnCustomerTransactionPage(@ModelAttribute ExternalUserSearch customer) {
		ModelAndView modelAndView  = new ModelAndView("external_usertransaction");
		System.out.println("Fetching the user details " + customer.getCustomerId());
		ExternalUser externalUser  = externalUserService.findUserById(customer.getCustomerId()); 
		List<Account> accounts = accountService.getAccountByCustomerId(externalUser.getCustomerId());
		modelAndView.addObject("accounts", accounts);
		modelAndView.addObject("user", externalUser);
		return modelAndView;
	}

}
