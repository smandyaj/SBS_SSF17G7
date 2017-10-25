package edu.asu.sbs.controllers;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.asu.sbs.model.Account;
import edu.asu.sbs.model.ExternalUser;
import edu.asu.sbs.model.Transaction;
import edu.asu.sbs.services.AccountService;
import edu.asu.sbs.services.TransactionService;

@Controller
public class AccountController {
	
	private AccountService accountService;
	private TransactionService transactionService;
	
	
	/**************************External Users********************************/
	
	@RequestMapping(value="/customer/creditcards",method = RequestMethod.POST)
	public ModelAndView getCreditCardsSummary(@ModelAttribute ExternalUser customer) {
		ModelAndView modelAndView = new ModelAndView("creditcardssummary");
		List<Account> accounts = this.accountService.getAccountByAccountType(customer.getCustomerId(), 2);
		modelAndView.addObject("accounts",accounts);
		return modelAndView;
	}
	
	@RequestMapping(value="/customer/creditcard/{accountId}",method = RequestMethod.POST)
	public ModelAndView getCreditCardInfo(@PathVariable("accountId") Integer accountId) {
		ModelAndView modelAndView = new ModelAndView("creditcardinfo");
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
		
		modelAndView.addObject("account",account);
		modelAndView.addObject("latefee",latefee);
		modelAndView.addObject("interest",interest);
					
		return modelAndView;
	}
	
	@RequestMapping(value="/customer/creditcard/{accountId}/payment/{transaction}",method = RequestMethod.GET)
	public String payCreditCard(@PathVariable("accountId") Integer accountId, @PathVariable("transaction") Transaction transaction) {
		if(accountId != transaction.getReceiverId()) {
			System.out.println("Payment information is wrong!");
			return "redirect:/customer/creditcard/{accountId}";
		}
		this.transactionService.addTransaction(transaction);
		System.out.println("Payment schedule succeed! Waiting for approvement!");
		return "redirect:/customer/creditcard/{accountId}";		
	}
	

}
