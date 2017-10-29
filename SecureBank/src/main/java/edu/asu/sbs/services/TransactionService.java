package edu.asu.sbs.services;

import java.util.List;

import edu.asu.sbs.model.Transaction;

public interface TransactionService {

	public void addTransaction(Transaction t);
	public void updateTransaction(Transaction t);
	public List<Transaction> getAllTransaction(Integer type);
	public List<Transaction> getTransactions(Integer customerId);
	public Transaction get(int transactionId);
	public boolean approveTransaction(Transaction transaction);
	public boolean isTransferCritical(double amount);
	

	public Transaction getTransactionById(int Id);
	
	public List<Transaction> getTransactionsByPayerId(int Id);
	
	public List<Transaction> getTransactionsByReceiverId(int Id);
	
	public List<Transaction> getTransactionsByPayerOrReceiverId(int Id);
	
	public List<Transaction> getOrderedTransactionsByPayerOrReceiverId(int Id);

}
