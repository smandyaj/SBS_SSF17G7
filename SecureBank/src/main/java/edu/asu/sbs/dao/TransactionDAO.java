package edu.asu.sbs.dao;

import java.util.List;

import edu.asu.sbs.model.Transaction;

public interface TransactionDAO {
	
	public List<Transaction> listAll(int internalUserType);
	public List<Transaction> listForCustomer(int customerId);
	public Transaction get(int trasactionId);
	public void add( Transaction t);
	public void update(Transaction t);
	
	void debit(int accNumber, String userName, double amount, int acc_type);
	void debit_final(int transaction_id);
	void credit(int accNumber, String userName, double amount);
	void transfer_email(String email_id, String userName, double amount);
	void transfer_message(int phone, String userName, double amount);
}