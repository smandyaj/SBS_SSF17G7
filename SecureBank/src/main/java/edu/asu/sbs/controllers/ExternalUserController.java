package edu.asu.sbs.controllers;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.asu.sbs.model.Account;
import edu.asu.sbs.model.ExternalUser;
import edu.asu.sbs.model.ExternalUserSearch;
import edu.asu.sbs.model.InternalUser;
import edu.asu.sbs.model.ModifiedUser;
import edu.asu.sbs.model.Transaction;
import edu.asu.sbs.services.AccountService;
import edu.asu.sbs.services.ExternalUserService;
import edu.asu.sbs.services.ModifiedUserService;
import edu.asu.sbs.services.TransactionService;


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
	
	@Autowired
	private TransactionService transactionService;
	
	
	@RequestMapping(value="/customer/home",method=RequestMethod.GET)
	public ModelAndView getCustomerHomePage() {
		return new ModelAndView("customerHome");
	}
	
	
	@RequestMapping(value="/customer/profile",method=RequestMethod.GET)
	public ModelAndView getCustomerProfile() {
		ModelAndView modelAndView = new ModelAndView("customer-profile");
		modelAndView.addObject("customerForm", externalUserService.findByUserName());
		System.out.println("user is: "+externalUserService.findByUserName().getCustomerId());
		return modelAndView;
		
	}
	
	@RequestMapping(value="/customer/modify-profile",method=RequestMethod.POST)
	public ModelAndView addModifiedProfile(@ModelAttribute ExternalUser externalUser) {
		ModelAndView modelAndView = new ModelAndView("customer-profile");
		System.out.println("User name to be modified ::" + externalUser.getFirstName());
		System.out.println("User details ::" + externalUser);
		ModifiedUser modUser =new ModifiedUser(externalUser.getCustomerId(), externalUser.getFirstName(), 
				externalUser.getLastName(), externalUser.getEmailId(), externalUser.getPhone(), 
				externalUser.getCustomerAddress(), 0, "pending", 0);
		modifiedUserService.addUser(modUser);
		modelAndView.addObject("msg", "Profile has been submitted for approval");
		return modelAndView;
	}
	
	@RequestMapping(value="/customer/customer-transaction", method = RequestMethod.GET)
	public ModelAndView returnCustomerTransactionPage() {
		ModelAndView modelAndView  = new ModelAndView("customersearch");
		modelAndView.addObject("externalUser", getExternalUser());
		
		System.out.println("Fetch the user: " + externalUserService.findByUserName().getUserName());
		return modelAndView;
	}
	
	/*@RequestMapping(value = "/customer/debit_money", method = RequestMethod.POST)
	public ModelAndView debitmoneyPageAction(@ModelAttribute("debit") Transaction trans) {
		ModelAndView modelAndView  = new ModelAndView("external_usertransaction");
		
		
		ExternalUser extUser= externalUserService.findByUserName();
		trans.setTransactionAmount(transactionAmount);
		return modelAndView;
	}*/

	@RequestMapping(value="/customer/customer-transaction", method = RequestMethod.POST)
	public ModelAndView returnCustomerTransactionPage(@ModelAttribute ExternalUserSearch customer) {
		ModelAndView modelAndView  = new ModelAndView("external_usertransaction");
		System.out.println("Fetching the user details " + customer.getCustomerId());
		ExternalUser externalUser  = externalUserService.findUserById(customer.getCustomerId());
		//ExternalUser extUser=externalUserService.findByUserName();
		List<Account> accounts = accountService.getAccountByCustomerId(externalUser.getCustomerId());
		System.out.println("User accounts ::" + externalUser.getLastName());
		modelAndView.addObject("accounts", accounts);
		modelAndView.addObject("user", externalUser);
		return modelAndView;
	}
	
	@RequestMapping(value="/customer/addTransactionSuccess", method = RequestMethod.POST)
	public String processTransaction(ModelMap model, HttpServletRequest request,
			@ModelAttribute("transaction") Transaction senderTransaction,
			BindingResult result, RedirectAttributes attr) {
		
		boolean isManager = request.isUserInRole("ROLE_MANAGER");
		boolean isTransferAccountValid;
		
		// get account of the sender
		Account account = accountService.getAccountByNumber(senderTransaction
				.getSenderAccNumber());

		// Exit the transaction if Account doesn't exist
		if (account == null) {
			System.out.println("Someone tried credit/debit functionality for some other account. Details:");
			//System.out.println("Credit/Debit Acc No: " + request.getParameter("number"));
			// add the return attributes
			return "redirect:/customer/home";
		}

		int receiverAccNumber = 0;
		BigInteger receiverPhoneNum=BigInteger.ZERO;
		String receiverEmailId="";
		if (request.getParameter("type").equalsIgnoreCase("internal")) {
			// if it is internal
			receiverAccNumber = Integer.parseInt(request.getParameter("receiverAccNumber"));
			System.out.println("internal transfer");
		} else {
			// if it us external
			String type = request.getParameter("modes");
			System.out.println("Mode" + type);
			if(type.equals("receiverEmailId")) {
				System.out.println("Email id" + request.getParameter("receiverEmailId"));
				receiverEmailId=request.getParameter("receiverEmailId");
				System.out.println("Transfer through email.");
			}
			else if(type.equals("receiverPhoneNumber")) {
				System.out.println("Phone Number:" + request.getParameter("receiverPhoneNumber"));
				receiverPhoneNum=new BigInteger(request.getParameter("receiverPhoneNumber"));
				System.out.println("Transfer through phone.");
			}
			else if(type.equals("receiverAccNumberExt")) {
				System.out.println("Account Number:" + request.getParameter("receiverAccNumberExt"));
				receiverAccNumber = Integer.parseInt(request.getParameter("receiverAccNumberExt"));
				System.out.println("Transfer through accountNum.");
			}
			/*receiverAccNumber = Integer.parseInt(request.getParameter("receiverAccNumberExt"));
			System.out.println("external transfer");*/
			
		}

		if (receiverAccNumber == Integer.parseInt(request.getParameter("senderAccNumber"))) {
			// same account transfer not allowed
			return "redirect:/customer/home";
		}
		List<Account> accList=null;
		Account toAccount=null;
		ExternalUser receiver=null;
		if(receiverAccNumber!=0) {
			toAccount = accountService.getAccountByNumber(receiverAccNumber);
		}
		else if(receiverEmailId!= null && !receiverEmailId.isEmpty()) {
			System.out.println("in mail");
			receiver=externalUserService.findByEmailId(receiverEmailId);
			accList = accountService.getAccountByCustomerId(receiver.getCustomerId());
			for(int i=0;i<accList.size();i++) {
				if(accList.get(i).getAccountType()==0) {
					toAccount=accList.get(i);
					break;
				}
			}
			receiverAccNumber=toAccount.getAccountId();
			/*receiverAccNumber=toAccount.getAccountId();
			System.out.println("acc num="+receiverAccNumber);*/
			
		}
		else if(receiverPhoneNum!=BigInteger.ZERO) {
			receiver=externalUserService.findByPhoneNumber(receiverPhoneNum);
			accList = accountService.getAccountByCustomerId(receiver.getCustomerId());
			for(int i=0;i<accList.size();i++) {
				if(accList.get(i).getAccountType()==0) {
					toAccount=accList.get(i);
					break;
				}
			}
			receiverAccNumber=toAccount.getAccountId();
		}
		// get the to account details
		

		if (toAccount != null) {
			isTransferAccountValid = true;
		} else {
			isTransferAccountValid = false;
		}

		System.out.println("isTransferAccountValid: " + isTransferAccountValid);
		if (isTransferAccountValid) {

			double amount = Double.parseDouble((request.getParameter("amount")));

			System.out.println("receiverAccNumber: " + receiverAccNumber);

			boolean isCritical = transactionService.isTransferCritical(amount);
			
			// create the transaction object
			int status = 1;
			String status_quo = "approved";
			
			//java.sql.Date date = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
			Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());

			//Date date1= new Date(Calendar.getInstance().getTime().getTime());
			senderTransaction = new Transaction(0, currentTimestamp, account.getCustomerId(), toAccount.getCustomerId(),
					amount, status, 1, status_quo,
					Integer.parseInt(request.getParameter("senderAccNumber")),receiverAccNumber);
			System.out.println("Sender Transaction created: " + senderTransaction);

			// Check if Debit amount is < balance in the account
			if ( account.getAccountBalance() - amount <= 0) {
				System.out.println("No balance in account");
				return "redirect:/customer/home";
			}

			
			
			Transaction receiverTransaction = new Transaction(1, currentTimestamp, account.getCustomerId(), toAccount.getCustomerId(),
					amount, status, 1, status_quo,
					Integer.parseInt(request.getParameter("senderAccNumber")),receiverAccNumber);


			System.out.println("Receiver Transaction created: " + receiverTransaction);

			try {
				System.out.println("Trying to transfer funds");
				if(isManager) {
					System.out.println("Transfer as manager ");
					receiverTransaction.setStatus(1);
					receiverTransaction.setStatus_quo("approved");
					accountService.transferFunds(transactionService,
					accountService, senderTransaction, receiverTransaction,
						amount);
				}else {
					System.out.println("Transfer as regular employee");
					if(isCritical) {
						System.out.println("Transer critical and only manager can approve");
						receiverTransaction.setStatus(0);
						receiverTransaction.setStatus_quo("pending");
						transactionService.addTransaction(senderTransaction);
						transactionService.addTransaction(receiverTransaction);
					}else {
						System.out.println("Transaction not critical and can be approved by regular");
						receiverTransaction.setStatus(1);
						receiverTransaction.setStatus_quo("approved");
						accountService.transferFunds(transactionService,
						accountService, senderTransaction, receiverTransaction,
							amount);
					}
					return "redirect:/customer/home";
				}
			} catch (Exception e) {
				System.out.println("Transfer unsuccessful. Please try again or contact the admin.");
				return "redirect:/employee/home";
			}

			System.out.println("Transaction completed successfully. Transaction should show up on the user account now");

		} else {
			System.out.println("Transfer unsucessful. Please try again or contact the admin");
		}

		// redirect to the view page
		return "redirect:/customer/home";
	}

}
