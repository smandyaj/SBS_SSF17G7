package edu.asu.sbs.services;

import java.util.List;

import edu.asu.sbs.model.Transaction;

public interface TransactionService {

	public Transaction getTransactionById(int Id);
	
	public List<Transaction> getTransactionsByPayerId(int Id);
	
	public List<Transaction> getTransactionsByReceiverId(int Id);
	
	public List<Transaction> getTransactionsByPayerOrReceiverId(int Id);
	
	public List<Transaction> getOrderedTransactionsByPayerOrReceiverId(int Id);
	
	public void addTransaction(Transaction t);
	
	public void updateTransaction(Transaction t);
}
