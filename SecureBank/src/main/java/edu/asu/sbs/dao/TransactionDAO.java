package edu.asu.sbs.dao;

import java.util.List;

import edu.asu.sbs.model.Transaction;

public interface TransactionDAO {
	
	public List<Transaction> listAll(int internalUserType);
	public List<Transaction> listForCustomer(int customerId);
	public Transaction get(int trasactionId);
	public void add( Transaction t);
	public void update(Transaction t);
}
