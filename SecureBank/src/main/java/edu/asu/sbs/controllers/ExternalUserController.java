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
import edu.asu.sbs.model.ExternalUserTransactionResult;
import edu.asu.sbs.model.InternalUser;
import edu.asu.sbs.services.ExternalUserService;


public class ExternalUserController {
@Autowired
private ExternalUserService externalUserService;

@RequestMapping(value="/admin/merchant-add-modify")
public ModelAndView addingInternalUser(@ModelAttribute ExternalUser externalUser) {
	System.out.println("Adding new user and redirecting" + externalUser.getPasswordHash());
	java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
	java.text.SimpleDateFormat sdf = 
	     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	if( externalUser.getCustomerId() == 0) {
		System.out.println("Add User" + externalUser.getCustomerId());
		externalUserService.add(externalUser);	
	}else {
		System.out.println("Modify User" + externalUser.getCustomerId());
		externalUserService.update(externalUser);
	}
	ModelAndView modelAndView = new ModelAndView("employeelist");
	System.out.println("All Users Page");
	@SuppressWarnings("rawtypes")
	List employees = externalUserService.findAll();
	modelAndView.addObject("employees", employees);
	return modelAndView;
}

@RequestMapping(value="/admin/employee-delete/{id}", method=RequestMethod.POST)
public ModelAndView deleteInternalUser(@PathVariable Integer id) {
	System.out.println("Deleting the user with id"+ id);
	externalUserService.delete(id);
	ModelAndView modelAndView = new ModelAndView("employeelist");
	System.out.println("All Users Page");
	@SuppressWarnings("rawtypes")
	List employees = externalUserService.findAll();
	modelAndView.addObject("employees", employees);
	return modelAndView;
}

@RequestMapping(value="/admin/employee-list")
public ModelAndView listOfEmployees() {
	ModelAndView modelAndView = new ModelAndView("employeelist"); // Change as per views
	System.out.println("All Users Page");
	@SuppressWarnings("rawtypes")
	List employees = externalUserService.findAll();
	modelAndView.addObject("employees", employees);
	return modelAndView;
}

@RequestMapping(value="/employee/customer-transaction", method = RequestMethod.POST)
public ModelAndView debit(ExternalUserTransactionResult t) {
	ModelAndView modelAndView = new ModelAndView("employeelist");
	System.out.println("Debiting the user with accNumber, userName, amount and acc_type"+ t.accNumber + t.userName + t.amount + t.acc_type);
	externalUserService.debit(t.accNumber, t.userName, t.amount, t.acc_type);
	return modelAndView;
}

@RequestMapping(value="/admin/employee-list/{accNumber}/{userName}/{amount}")
public ModelAndView credit(@PathVariable Integer accNumber, @PathVariable String userName, @PathVariable double amount) {
	ModelAndView modelAndView = new ModelAndView("employeelist");
	System.out.println("Crediting the user with accNumber, userName, amount"+ accNumber + userName + amount);
	externalUserService.credit(accNumber, userName, amount);
	return modelAndView;
}

@RequestMapping(value="/admin/employee-list/{transaction_id}")
public ModelAndView debit_final(@PathVariable Integer transaction_id) {
	ModelAndView modelAndView = new ModelAndView("employeelist");
	System.out.println("Debiting the user with transaction_id"+ transaction_id);
	externalUserService.debit_final(transaction_id);
	return modelAndView;
}

@RequestMapping(value="/admin/employee-list/{email_id}/{userName}/{amount}")
public ModelAndView transfer_email(@PathVariable String email_id, @PathVariable String userName, @PathVariable double amount) {
	ModelAndView modelAndView = new ModelAndView("employeelist");
	System.out.println("Transfer to user with email_id"+ email_id);
	externalUserService.transfer_email(email_id, userName, amount);
	return modelAndView;
}

@RequestMapping(value="/admin/employee-list/{phone}/{userName}/{amount}")
public ModelAndView transfer_message(@PathVariable Integer phone, @PathVariable String userName, @PathVariable double amount) {
	ModelAndView modelAndView = new ModelAndView("employeelist");
	System.out.println("Transfer to user with phone"+ phone);
	externalUserService.transfer_message(phone, userName, amount);
	return modelAndView;
}



}