package edu.asu.sbs.controllers;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;

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
import edu.asu.sbs.model.ExternalUserTransactionResult;
import edu.asu.sbs.model.InternalUser;
import edu.asu.sbs.model.ModifiedUser;
import edu.asu.sbs.services.AccountService;
import edu.asu.sbs.services.ExternalUserService;
import edu.asu.sbs.services.ModifiedUserService;

@Controller
public class ExternalUserController {
@Autowired
private ExternalUserService externalUserService;

@Autowired
private ModifiedUserService modifiedUserService;
@ModelAttribute
public ExternalUserSearch getExternalUser() {
return new ExternalUserSearch();
}

@Autowired
private AccountService accountService;

/*
@RequestMapping(value="/customer/merchant-add-modify")
public ModelAndView addingExternalUser(@ModelAttribute ModifiedUser externalUser) {
//System.out.println("Adding new user and redirecting" + externalUser.getPasswordHash());
java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
java.text.SimpleDateFormat sdf = 
     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
if( externalUser.getUserId() == 0) {
System.out.println("Add User" + externalUser.getUserId());
externalUserService.add(externalUser); 
}else {
System.out.println("Modify User" + externalUser.getUserId());
externalUserService.update(externalUser);
}
ModelAndView modelAndView = new ModelAndView("employeelist");
System.out.println("All Users Page");
@SuppressWarnings("rawtypes")
List employees = externalUserService.findAllUsers();
modelAndView.addObject("employees", employees);
return modelAndView;
}



@RequestMapping(value="/customer/employee-delete/{id}", method=RequestMethod.POST)
public ModelAndView deleteExternalUser(@PathVariable Integer id) {
System.out.println("Deleting the user with id"+ id);
externalUserService.delete(id);
ModelAndView modelAndView = new ModelAndView("employeelist");
System.out.println("All Users Page");
@SuppressWarnings("rawtypes")
List employees = externalUserService.findAllUsers();
modelAndView.addObject("employees", employees);
return modelAndView;
}

@RequestMapping(value="/customer/employee-list")
public ModelAndView listOfEmployees() {
ModelAndView modelAndView = new ModelAndView("employeelist"); // Change as per views
System.out.println("All Users Page");
@SuppressWarnings("rawtypes")
List employees = externalUserService.findAll();
modelAndView.addObject("employees", employees);
return modelAndView;
}

@RequestMapping(value="/customer/customer-transaction", method = RequestMethod.GET)
public ModelAndView debit(ExternalUserTransactionResult t) {
ModelAndView modelAndView = new ModelAndView("employeelist");
System.out.println("Debiting the user with accNumber, userName, amount and acc_type"+ t.accNumber + t.userName + t.amount + t.acc_type);
externalUserService.debit(t.accNumber, t.userName, t.amount, t.acc_type);
return modelAndView;
}

@RequestMapping(value="/customer/employee-list/{accNumber}/{userName}/{amount}")
public ModelAndView credit(@PathVariable Integer accNumber, @PathVariable String userName, @PathVariable double amount) {
ModelAndView modelAndView = new ModelAndView("employeelist");
System.out.println("Crediting the user with accNumber, userName, amount"+ accNumber + userName + amount);
externalUserService.credit(accNumber, userName, amount);
return modelAndView;
}

@RequestMapping(value="/customer/employee-list/{transaction_id}")
public ModelAndView debit_final(@PathVariable Integer transaction_id) {
ModelAndView modelAndView = new ModelAndView("employeelist");
System.out.println("Debiting the user with transaction_id"+ transaction_id);
externalUserService.debit_final(transaction_id);
return modelAndView;
}

@RequestMapping(value="/customer/employee-list/{email_id}/{userName}/{amount}")
public ModelAndView transfer_email(@PathVariable String email_id, @PathVariable String userName, @PathVariable double amount) {
ModelAndView modelAndView = new ModelAndView("employeelist");
System.out.println("Transfer to user with email_id"+ email_id);
externalUserService.transfer_email(email_id, userName, amount);
return modelAndView;
}

@RequestMapping(value="/customer/employee-list/{phone}/{userName}/{amount}")
public ModelAndView transfer_message(@PathVariable Integer phone, @PathVariable String userName, @PathVariable double amount) {
ModelAndView modelAndView = new ModelAndView("employeelist");
System.out.println("Transfer to user with phone"+ phone);
externalUserService.transfer_message(phone, userName, amount);
return modelAndView;
}*/

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
public ModelAndView processCutomerTransaction() {
	System.out.println("In the GET Request");
ModelAndView modelAndView  = new ModelAndView("external_usertransaction");
modelAndView.addObject("externalUser", getExternalUser());
/*System.out.println("Fetching the user details " + customer.getCustomerId());
ExternalUser externalUser  = externalUserService.findUserById(customer.getCustomerId()); 
List<Account> accounts = accountService.getAccountByCustomerId(externalUser.getCustomerId());
modelAndView.addObject("accounts", accounts);
modelAndView.addObject("user", externalUser);*/
return modelAndView;
}


@RequestMapping(value="/customer/customer-transaction", method = RequestMethod.POST)
public String returnCustomerTransactionPage(@ModelAttribute ExternalUserTransactionResult customer) {
System.out.println("In the POST request");
System.out.println(customer.getAmount());
//externalUserService.debit(1, "smandyaj2", 400, 1);
//externalUserService.debit_final(4);
//externalUserService.credit(1, "smandyaj2", 200);
//externalUserService.transfer_email("1@asu.edu", "smandyaj2", 500);
BigInteger b = new BigInteger(48030021+"");
externalUserService.transfer_message(b, "smandyaj2", 650);
return "redirect:/customer/home";
}



}