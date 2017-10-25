package edu.asu.sbs.services;

import java.util.List;

import edu.asu.sbs.model.Account;

public interface AccountService {
	
	public Account getAccountByAccountId(Integer accountId);
	
	public List<Account> getAccountByCustomerId(Integer customerId);
	
	public void updateAccount(Account account);
	
	public double getBalance(Integer accountId);
	
	public List<Account> getAccountByAccountType(Integer customerId, int type);

}
