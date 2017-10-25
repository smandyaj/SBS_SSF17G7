package edu.asu.sbs.dao;

import java.util.List;

import edu.asu.sbs.model.Transaction;

public interface TransactionDAO {

	public Transaction getById(int Id);
	
	public List<Transaction> getByPayerId(int Id);
	
	public List<Transaction> getByReceiverId(int Id);
	
	public List<Transaction> getByPayerOrReceiverId(int Id);
	
	public List<Transaction> getByPayerOrReceiverIdOrderedByTime(int Id);
	
	public void add(Transaction t);
	
	public void update(Transaction t);
	
}
