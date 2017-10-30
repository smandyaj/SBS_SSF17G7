package edu.asu.sbs.controllers;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.asu.sbs.model.Account;
import edu.asu.sbs.model.ExternalUser;
import edu.asu.sbs.model.ExternalUserSearch;
import edu.asu.sbs.model.InternalUser;
import edu.asu.sbs.model.ModifiedUser;
import edu.asu.sbs.model.Transaction;
import edu.asu.sbs.model.Users;
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
	
	
	@RequestMapping(value = "/customer/home", method = RequestMethod.GET)
	public String getHome(ModelMap model) {
		ExternalUser user = externalUserService.findByUserName();
		List<Account> accounts = accountService.getAccountByCustomerId(user
				.getCustomerId());
		model.addAttribute("title", "Welcome " + user.getFirstName());
		model.addAttribute("fullname",
				user.getFirstName() + " " + user.getLastName());
		model.addAttribute("accounts", accounts);
		model.addAttribute("customerId", user.getCustomerId());
		return "customerHome";
	}
	
	@RequestMapping(value="/customer/home/bankStatements",method=RequestMethod.GET)
	public String getBankStatements(ModelMap model) {
		ExternalUser user = externalUserService.findByUserName();
		List<Account> accounts = accountService.getAccountByCustomerId(user
				.getCustomerId());
		
		model.addAttribute("transactions");
		//modelAndView.addObject("customerForm", externalUserService.findByUserName());
		System.out.println("user is: "+externalUserService.findByUserName().getCustomerId());
		return "bankStatements";
		
	}
	
	/*@RequestMapping(value = "/customer/home/bankStatements", method = RequestMethod.GET)
	public String getStatements(ModelMap model, HttpServletRequest request) {
		ExternalUser user = externalUserService.findByUserName();
		List<Account> accounts = accountService.getAccountByCustomerId(user
				.getCustomerId());
		model.put("user", user);
		model.addAttribute("title", "Account Statements");
		model.addAttribute("accounts", accounts);

		return "bankStatements";
	}*/
	/*
	@RequestMapping(value = "/customer/home/bankStatements", method = RequestMethod.POST)
	public String postStatements(ModelMap model, HttpServletRequest request,
			RedirectAttributes attr) {
		ExternalUser user = externalUserService.findByUserName();
		model.put("user", user);

		List<Account> accounts = accountService.getAccountByCustomerId(user
				.getCustomerId());
		model.addAttribute("title", "Account Statements " + user.getFirstName());
		model.addAttribute("fullname",
				user.getFirstName() + " " + user.getLastName());
		model.addAttribute("accounts", accounts);

		// If account is empty or null, skip the account service check
		Account account = accountService.getValidAccountByNumber(request.getParameter("number"), accounts);
		// Exit the transaction if Account doesn't exist
		if (account == null) {
			System.out.println("Someone tried statements functionality for some other account. Details:");
			System.out.println("Acc No: " + request.getParameter("number"));
			System.out.println("Customer ID: " + user.getCustomerId());
			attr.addFlashAttribute("statementFailureMsg",
					"Could not process your request. Please try again or contact the bank.");
			return "redirect:/home/statements";
		}

		List<StatementMonthYear> statements = transactionService
				.getStatementMonths(request.getParameter("number"));
		if (statements.size() > 0) {
			logger.debug("Received statements: " + statements.get(0).getMonth());
		}
		model.addAttribute("statements", statements);
		model.addAttribute("accNumber", request.getParameter("number"));

		return "bankStatements";
	}
	
	
	@RequestMapping(value = "/customer/home/bankStatements/view", method = RequestMethod.POST)
	public String postViewStatement(ModelMap model, HttpServletRequest request,
			RedirectAttributes attr) {

		ExternalUser user = externalUserService.findByUserName();
		List<Account> accounts = accountService.getAccountByCustomerId(user
				.getCustomerId());
		model.put("user", user);
		
		Account account=null;
		for(int i=0;i<accounts.size();i++) {
			if(accounts.get(i).getAccountType()==Integer.parseInt(request.getParameter("number"))) {
				account=accounts.get(i);
				break;
			}
		}

		// If account is empty or null, skip the account service check
		

		if (account == null) {
			logger.warn("Someone tried view statement functionality for some other account. Details:");
			logger.warn("Acc No: " + request.getParameter("number"));
			logger.warn("Customer ID: " + user.getCustomerId());
			attr.addFlashAttribute("statementFailureMsg",
					"Could not process your request. Please try again or contact the bank.");
			return "redirect:/bankStatements";
		}

		List<Transaction> transactions = transactionService
				.getCompletedTransactionsByAccountNummber(
						request.getParameter("number"),
						request.getParameter("month"),
						Integer.parseInt(request.getParameter("year")));

		model.addAttribute("title", "Account Statements");
		model.addAttribute("user", user);
		model.addAttribute("account", account);
		model.addAttribute("transactions", transactions);
		model.addAttribute("statementName", request.getParameter("month") + " "
				+ request.getParameter("year"));

		return "bankStatements";
	}
	
	@RequestMapping(value = "/customer/home/bankStatements/download", method = RequestMethod.POST)
	public ModelAndView postDownloadStatement(ModelMap model,
			HttpServletRequest request, RedirectAttributes attr) {

		ExternalUser user = externalUserService.findByUserName();
		List<Account> accounts = accountService.getAccountByCustomerId(user
				.getCustomerId());
		model.put("user", user);

		// If account is empty or null, skip the account service check
		Account account = accountService.getValidAccountByNumber(
				request.getParameter("number"), accounts);

		if (account == null) {
			logger.warn("Someone tried view statement functionality for some other account. Details:");
			logger.warn("Acc No: " + request.getParameter("number"));
			logger.warn("Customer ID: " + user.getCustomerId());
			attr.addFlashAttribute("statementFailureMsg",
					"Could not process your request. Please try again or contact the bank.");
			return new ModelAndView("redirect:/bankStatements");
		}

		List<Transaction> transactions = transactionService
				.getCompletedTransactionsByAccountNummber(
						request.getParameter("number"),
						request.getParameter("month"),
						Integer.parseInt(request.getParameter("year")));

		model.addAttribute("title", "Account Statements");
		model.addAttribute("user", user);
		model.addAttribute("account", account);
		model.addAttribute("transactions", transactions);
		model.addAttribute("statementName", request.getParameter("month") + " "
				+ request.getParameter("year"));

		return new ModelAndView("pdfView", "model", model);
	}*/
	
	
	
	
	
	
	@RequestMapping(value="/customer/profile",method=RequestMethod.GET)
	public ModelAndView getCustomerProfile() {
		ModelAndView modelAndView = new ModelAndView("customer-profile");
		modelAndView.addObject("customerForm", externalUserService.findByUserName());
		System.out.println("user is: "+externalUserService.findByUserName().getCustomerId());
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/customer/credit-debit", method = RequestMethod.GET)
	public String getCreditDebit(ModelMap model) {
		ExternalUser user = externalUserService.findByUserName();
		model.put("user", user);



		List<Account> accounts = accountService.getAccountByCustomerId(user
				.getCustomerId());
		model.addAttribute("title", "Welcome " + user.getFirstName());
		model.addAttribute("fullname",
				user.getFirstName() + " " + user.getLastName());
		model.addAttribute("accounts", accounts);
		return "creditdebit";
	}
	
	
	@RequestMapping(value = "/customer/credit-debit", method = RequestMethod.POST)
	public String postCreditDebit(ModelMap model, HttpServletRequest request,
			@ModelAttribute("transaction") Transaction transaction,
			BindingResult result, RedirectAttributes attr) {

		// Get user details
		ExternalUser user = externalUserService.findByUserName();
		model.put("user", user);

		// Get user accounts and other data for display
		List<Account> accounts = accountService.getAccountByCustomerId(user.getCustomerId());
		model.addAttribute("fullname",
				user.getFirstName() + " " + user.getLastName());
		model.addAttribute("accounts", accounts);
		model.addAttribute("title", "Welcome " + user.getFirstName());

		double amount = Double.parseDouble(request.getParameter("amount"));

		boolean isCritical = transactionService.isTransferCritical(amount);

		// create the transaction object
		Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
		transaction = new Transaction(0, currentTimestamp, user.getCustomerId(), user.getCustomerId(), 
				amount,1, 0, "pending", Integer.parseInt(request.getParameter("number")), Integer.parseInt(request.getParameter("number")));
		
		// If account is empty or null, skip the account service check
		Account account = accountService.getAccountByNumber(Integer.parseInt(request.getParameter("number")));

		// Exit the transaction if Account doesn't exist
		if (account == null) {
			System.out.println("Someone tried credit/debit functionality for some other account. Details:");
			System.out.println("Credit/Debit Acc No: "
					+ request.getParameter("number"));
			System.out.println("Customer ID: " + user.getCustomerId());
			attr.addFlashAttribute("failureMsg",
					"Could not process your transaction. Please try again or contact the bank.");
			return "redirect:/customer/credit-debit";
		}

		// Check if Debit amount is < balance in the account
		if (request.getParameter("type").equalsIgnoreCase("debit") 
				&& ( account.getAccountBalance() < amount)) {
			attr.addFlashAttribute(
					"failureMsg",
					"Could not process your transaction. Debit amount cannot be higher than account balance");
			return "redirect:/customer/credit-debit";
		}

		// OTP only for critical transactions
		if (isCritical) {

			String sessionId = RequestContextHolder
					.currentRequestAttributes().getSessionId();
			System.out.println("Got session id: " + sessionId);
			Random range = new Random();
			int rand = range.nextInt(Integer.MAX_VALUE);
			//otp = otpService.generateOTP(sessionId.getBytes(), new Long(
					//rand), 8, false, rand);

			//Otp otpObj = new Otp(hashService.getBCryptHash(otp), date, 
							//user.getCustomerId(), transaction.getTransactionId(), "creditdebit");
			transaction.setStatus(3);
			transaction.setStatus_quo("otp");
			transactionService.addTransaction(transaction);

			String content = "You have made a new request to for Credit / Debit "
					+ "The payment request will expire in the next 10 minutes from now.\n\n"
					+ "Please use the following OTP to accept the payment: "
					+ "\n\n" + "You can accept the payment or cancel it.";


			return "redirect:/customer/credit-debit";

		}

		transactionService.addTransaction(transaction);
		System.out.println("the transaction is:"+transaction);

		attr.addFlashAttribute(
				"successMsg",
				"Transaction completed successfully. Transaction should show up on your account shortly after bank approval.");

		// redirect to the credit debit view page
		return "redirect:/customer/credit-debit";
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
	
	@RequestMapping(value="/customer/request-money", method = RequestMethod.GET)
	public String returnCustomerRequestMoney(ModelMap model) {
		System.out.println("Fetch the user: " + externalUserService.findByUserName().getUserName());
		
		ExternalUser user = externalUserService.findByUserName();
		model.put("user", user);
		List<Account> accounts = accountService.getAccountByCustomerId(user
				.getCustomerId());
		model.addAttribute("title", "Welcome " + user.getFirstName() + " " + user.getLastName());
		model.addAttribute("fullname",
				user.getFirstName() + " " + user.getLastName());
		model.addAttribute("accounts", accounts);
		model.addAttribute("customerId", user.getCustomerId());
		return "requestMoney";
	}
	
	@RequestMapping(value="/customer/requestMoneySuccess", method = RequestMethod.POST)
	public String processMoneyRequest(ModelMap model, HttpServletRequest request,
			@ModelAttribute("transaction") Transaction senderTransaction,
			BindingResult result, RedirectAttributes attr) {
		
		boolean isManager = request.isUserInRole("ROLE_MANAGER");
		boolean isTransferAccountValid;
		ExternalUser receiver=externalUserService.findByUserName();
		
		
		
		// get account of the sender
		Account senderAccount = accountService.getAccountByNumber(senderTransaction
				.getSenderAccNumber());
		
		List<Account> accList=null;
		Account receiverAcc=null;
		int receiverAccNumber=0;
		accList = accountService.getAccountByCustomerId(receiver.getCustomerId());
		for(int i=0;i<accList.size();i++) {
			if(accList.get(i).getAccountType()==0) {
				receiverAcc=accList.get(i);
				break;
			}
		}
		
		receiverAccNumber=receiverAcc.getAccountId();
		// Exit the transaction if Account doesn't exist

		int senderAccNumber = 0;

		    senderAccNumber = Integer.parseInt(request.getParameter("senderAccNumber"));
			

				System.out.println("Account Number:" + request.getParameter("senderAccNumber"));
				System.out.println("Request through accountNum.");

			
		

		if (receiverAccNumber == Integer.parseInt(request.getParameter("senderAccNumber"))) {
			// same account transfer not allowed
			return "redirect:/customer/home";
		}

		// get the to account details
		

		if (receiverAcc != null) {
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
			int sender_status = 0;
			int requester_status=1;
			String status_quo = "pending";
			
			//java.sql.Date date = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
			Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());

			//Date date1= new Date(Calendar.getInstance().getTime().getTime());
			senderTransaction = new Transaction(0, currentTimestamp, senderAccount.getCustomerId(), receiver.getCustomerId(),
					amount, sender_status, 0, status_quo,
					Integer.parseInt(request.getParameter("senderAccNumber")),receiverAccNumber);
			System.out.println("Sender Transaction created: " + senderTransaction);

			// Check if Debit amount is < balance in the account
			if ( senderAccount.getAccountBalance() - amount <= 0) {
				System.out.println("No balance in account");
				return "redirect:/customer/home";
			}

			
			
			Transaction requesterTransaction = new Transaction(1, currentTimestamp, senderAccount.getCustomerId(), receiver.getCustomerId(),
					amount, requester_status, 1, status_quo,
					Integer.parseInt(request.getParameter("senderAccNumber")),receiverAccNumber);
			System.out.println("Receiver Transaction created: " + requesterTransaction);
			try {
				System.out.println("Trying to request funds");
				
				transactionService.addTransaction(senderTransaction);
			
				requesterTransaction.setStatus_quo("approved");
			transactionService.addTransaction(requesterTransaction);
			System.out.println("Transaction requested successfully. Request should show up on the user account now");
					return "redirect:/customer/home";

			} catch (Exception e) {
				System.out.println("Request unsuccessful. Please try again or contact the admin.");
				return "redirect:/customer/home";
			}
		} else {
			System.out.println("Transfer unsucessful. Please try again or contact the admin");
		}
		// redirect to the view page
		return "redirect:/customer/home";
	}
	@RequestMapping(value="/customer/customer-transaction", method = RequestMethod.GET)
	public String returnCustomerTransactionPage(ModelMap model) {
		System.out.println("Fetch the user: " + externalUserService.findByUserName().getUserName());
		
		ExternalUser user = externalUserService.findByUserName();
		model.put("user", user);
		List<Account> accounts = accountService.getAccountByCustomerId(user
				.getCustomerId());
		model.addAttribute("title", "Welcome " + user.getFirstName());
		model.addAttribute("fullname",
				user.getFirstName() + " " + user.getLastName());
		model.addAttribute("accounts", accounts);
		model.addAttribute("customerId", user.getCustomerId());
		return "external_usertransaction";
		
	}


	@RequestMapping(value="/customer/customer-transaction", method = RequestMethod.POST)
	public ModelAndView returnCustomerTransactionPage(@ModelAttribute ExternalUser
 customer) {
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
