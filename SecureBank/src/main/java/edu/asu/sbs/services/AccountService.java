package edu.asu.sbs.services;

import java.math.BigDecimal;
import java.util.List;

import edu.asu.sbs.model.Account;
import edu.asu.sbs.model.Transaction;

public interface AccountService {

	List<Account> getAccountByCustomerId(int customerId);
	Account getAccountByNumber(int accountNumber);
	public void updateAccount(Account account);
	public BigDecimal getBalance(int accountNumber);
	void transferFunds(Transaction sender, Transaction receiver,BigDecimal amount);
	Account findByAccountNumber(int i);
	void transferFunds(TransactionService transactionService,
			AccountService accountService, Transaction senderTransaction,
			Transaction receiverTransaction, double amount);
	

	
	public Account getAccountByAccountId(Integer accountId);
	
	public List<Account> getAccountByCustomerId(Integer customerId);

	
	public double getBalance(Integer accountId);
	
	public List<Account> getAccountByAccountType(Integer customerId, int type);
	
	
	
	
	
	
	
}