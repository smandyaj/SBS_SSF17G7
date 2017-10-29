package edu.asu.sbs.controllers;

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
import edu.asu.sbs.model.Transaction;
import edu.asu.sbs.services.AccountService;
import edu.asu.sbs.services.ExternalUserService;
import edu.asu.sbs.services.TransactionService;

@Controller
public class CreditCardController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private ExternalUserService externalUserService;
	
	
	
	/**************************External Users********************************/
	@RequestMapping(value="/customer/home",method= RequestMethod.GET)
	public ModelAndView getCreditHomePage() {
		return new ModelAndView("customer-home");
	}
	
	@RequestMapping(value="/customer/credit-home",method = RequestMethod.GET)
	public ModelAndView getCreditCardsSummary() {
		ModelAndView modelAndView = new ModelAndView("credit-home");
		ExternalUser customer = externalUserService.findByUserName();
		List<Account> accounts = this.accountService.getAccountByAccountType(customer.getCustomerId(), 2);
		modelAndView.addObject("accounts",accounts);
		return modelAndView;
	}
	
	@RequestMapping(value="/customer/creditcard/{accountId}",method = RequestMethod.GET)
	public ModelAndView getCreditCardInfo(@PathVariable("accountId") Integer accountId) {
		ModelAndView modelAndView = new ModelAndView("credit-info");
		Account account = this.accountService.getAccountByAccountId(accountId);
		if (account.getAccountType()!=2){
				System.out.println("This is not a credit card!");
				return modelAndView;
		}
		
		double latefee=0.0;
		int accountDue = account.getAccountDue();
		int today = Calendar.getInstance().get(Calendar.DATE);
		if(today > accountDue)
			latefee = 35.0;
		
		double interest = account.getAccountBalance()*0.01;
		
		List<Transaction> transactions = this.transactionService.getOrderedTransactionsByPayerOrReceiverId(accountId);
		
		modelAndView.addObject("account",account);
		modelAndView.addObject("latefee",latefee);
		modelAndView.addObject("interest",interest);
		modelAndView.addObject("transactions",transactions);
					
		return modelAndView;
	}
	
	@RequestMapping(value="/customer/creditcard/{accountId}/payment",method= RequestMethod.GET)
	public ModelAndView getPaymentInfo(@PathVariable("accountId") Integer accountId) {
		ModelAndView modelAndView = new ModelAndView("credit-payment");
		modelAndView.addObject("accountId",accountId);
		modelAndView.addObject("paymentForm",new Transaction());
		return modelAndView;
	}

	
	@RequestMapping(value="/customer/creditcard/{accountId}/make-payment",method = RequestMethod.POST)
	public String payCreditCard(@PathVariable("accountId") Integer accountId,@ModelAttribute("transaction") Transaction transaction) {
		ModelAndView modelAndView = new ModelAndView("credit-payment");
		ExternalUser customer = externalUserService.findByUserName();
		Account account = this.accountService.getAccountByAccountId(transaction.getSenderAccNumber());
		if (account==null || account.getCustomerId()!= customer.getCustomerId() || account.getAccountType()==2) {
			System.out.println("Account information is wrong!");
			modelAndView.addObject("msg","Account information is wrong!");
			return "redirect:/customer/home";
		}
		if (account.getAccountBalance()<transaction.getTransactionAmount()) {
			System.out.println("Payment information is wrong!");
			modelAndView.addObject("msg","Payment information is wrong!");
			return "redirect:/customer/home";
		}
		
      
        Transaction t = new Transaction();
        t.setPayerId(customer.getCustomerId());
        t.setReceiverId(customer.getCustomerId());
        t.setReceiverAccNumber(accountId);
        t.setStatus_quo("PENDING");
        t.setTransactionType(2);
        t.setSenderAccNumber(transaction.getSenderAccNumber());
        t.setTransactionAmount(transaction.getTransactionAmount());
        

        this.transactionService.addTransaction(t);
		System.out.println("Payment schedule succeed! Waiting for approvement!");
		modelAndView.addObject("msg","Payment schedule succeed! Waiting for approvement!");
		return "redirect:/customer/home";
	}
	

}
