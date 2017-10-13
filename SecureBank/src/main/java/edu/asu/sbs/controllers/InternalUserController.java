package edu.asu.sbs.controllers;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.asu.sbs.model.Account;
import edu.asu.sbs.model.ExternalUser;
import edu.asu.sbs.model.ExternalUserSearch;
import edu.asu.sbs.model.InternalUser;
import edu.asu.sbs.model.SystemLog;
import edu.asu.sbs.services.AccountService;
import edu.asu.sbs.services.ExternalUserService;
import edu.asu.sbs.services.InternalUserService;
import edu.asu.sbs.services.SystemLogService;

@Controller
public class InternalUserController {

	@Autowired
	private SystemLogService systemLogService;
	
	@Autowired
	private InternalUserService internalUserService;
	
	@Autowired
	private ExternalUserService externalUserService;
	
	@Autowired
	private AccountService accountService;
	
	@ModelAttribute
	public ExternalUserSearch getExternalUser() {
		return new ExternalUserSearch();
	}
	
	/** Lists all the System logs */
	@RequestMapping(value="/admin/systemlogs",method=RequestMethod.GET)
	public String getSystemLogs(Model model) {
		System.out.println("Fetching System logs..");
		List<SystemLog> systemLogList = systemLogService.getSystemLog();
		for(SystemLog log : systemLogList) {
			System.out.println(log.getFirstName());
		}
		model.addAttribute("systemLog", new SystemLog());
		model.addAttribute("systemLogList", systemLogList);
		model.addAttribute("msg", " Welcome Santosh");
		return "systemLog";
	}
	
	/** Add new System Log to the DB 
	 *  call the system log method
	 *  where its required. 
	 *  This is just for testing purpose
	 * */
	public String addSystemLog(@ModelAttribute("systemLog") SystemLog systemLog) {
		return "redirect:/systemLog";
	}
	
	
	/** add, delete, update, find internal users **/
	
	/** lists all the internal users **/
	@RequestMapping(value="/employee/list")
	public ModelAndView listOfEmployees() {
		ModelAndView modelAndView = new ModelAndView("employeeList");
		System.out.println("All Users Page");
		@SuppressWarnings("rawtypes")
		List employees = internalUserService.findAllUsers();
		modelAndView.addObject("employees", employees);
		return modelAndView;
	}
	
	@RequestMapping(value="/employee/add")
	public ModelAndView addInternalUserPage() {
		System.out.println("Add new user page");
		ModelAndView modelAndView = new ModelAndView("addUser");
		modelAndView.addObject("employee", "new");
		modelAndView.addObject("employeeForm", new InternalUser());
		return modelAndView;
	}
	
	// show update form
	@RequestMapping(value = "/employee/{id}/update", method = RequestMethod.GET)
	public ModelAndView showUpdateEmployeeForm(@PathVariable("id") int id, Model model) {
		ModelAndView modelAndView = new ModelAndView("addUser");
		InternalUser internalUser = internalUserService.findUserById(id);
		modelAndView.addObject("employee", "exists");
		model.addAttribute("employeeForm", internalUser);
		return modelAndView;

	}
	
	@RequestMapping(value="/employee/addormodify")
	public ModelAndView addingInternalUser(@ModelAttribute InternalUser internalUser) {
		System.out.println("Adding new user and redirecting" + internalUser.getPasswordHash());
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		internalUser.setCreationDate(date);
		internalUser.setLastLogin(date);
		
		if( internalUser.getEmployeeId() == 0) {
			System.out.println("Add User" + internalUser.getEmployeeId());
			internalUserService.addUser(internalUser);	
		}else {
			System.out.println("Modify User" + internalUser.getEmployeeId());
			internalUserService.updateUser(internalUser);
		}
		ModelAndView modelAndView = new ModelAndView("employeeList");
		System.out.println("All Users Page");
		@SuppressWarnings("rawtypes")
		List employees = internalUserService.findAllUsers();
		modelAndView.addObject("employees", employees);
		return modelAndView;
	}
	

	@RequestMapping(value="/employee/{id}/delete", method=RequestMethod.POST)
	public ModelAndView deleteInternalUser(@PathVariable Integer id) {
		System.out.println("Deleting the user with id"+ id);
		internalUserService.deleteUser(id);
		ModelAndView modelAndView = new ModelAndView("employeeList");
		System.out.println("All Users Page");
		@SuppressWarnings("rawtypes")
		List employees = internalUserService.findAllUsers();
		modelAndView.addObject("employees", employees);
		return modelAndView;
	}
	
	@RequestMapping(value="/employee/transaction", method = RequestMethod.GET)
	public ModelAndView returnTransactionPage() {
		ModelAndView modelAndView  = new ModelAndView("customerSearch");
		modelAndView.addObject("externalUser", getExternalUser());
		return modelAndView;
	}
	
	/** get accounts from the customer/merchant for transfer */
	@RequestMapping(value="/employee/transaction", method = RequestMethod.POST)
	public ModelAndView returnTransactionPage(@ModelAttribute ExternalUserSearch customer) {
		ModelAndView modelAndView  = new ModelAndView("internalUserTransaction");
		System.out.println("Fetching the user details " + customer.getCustomerId());
		ExternalUser externalUser  = externalUserService.findUserById(customer.getCustomerId()); 
		List<Account> accounts = accountService.getAccountByCustomerId(externalUser.getCustomerId());
		modelAndView.addObject("accounts", accounts);
		modelAndView.addObject("user", externalUser);
		return modelAndView;
	}
	
	/** process the transaction **/
	@RequestMapping(value="/employee/transaction/process", method = RequestMethod.POST)
	public ModelAndView processTransaction() {
		
		return new ModelAndView();
	}
}
