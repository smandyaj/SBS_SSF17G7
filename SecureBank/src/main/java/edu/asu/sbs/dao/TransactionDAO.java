package edu.asu.sbs.dao;

import java.util.List;

import edu.asu.sbs.model.Transaction;

public interface TransactionDAO {
	
	public List<Transaction> listAll(int internalUserType);
	public List<Transaction> listForCustomer(int customerId);
	public Transaction get(int trasactionId);
	public void add( Transaction t);
	public void update(Transaction t);
	
	public Transaction getById(int Id);
	
	public List<Transaction> getByPayerId(int Id);
	
	public List<Transaction> getByReceiverId(int Id);
	
	public List<Transaction> getByPayerOrReceiverId(int Id);
	
	public List<Transaction> getByPayerOrReceiverIdOrderedByTime(int Id);
	
	
}
