package edu.asu.sbs.services;

import java.util.List;

import edu.asu.sbs.dao.TransactionDAO;
import edu.asu.sbs.model.Transaction;

public class TransactionServiceImpl implements TransactionService{
	private TransactionDAO transactionDAO;
	

	@Override
	public Transaction getTransactionById(int Id) {
		// TODO Auto-generated method stub
		return this.transactionDAO.getById(Id);
	}

	@Override
	public List<Transaction> getTransactionsByPayerId(int Id) {
		// TODO Auto-generated method stub
		return this.transactionDAO.getByPayerId(Id);
	}

	@Override
	public List<Transaction> getTransactionsByReceiverId(int Id) {
		// TODO Auto-generated method stub
		return this.transactionDAO.getByReceiverId(Id);
	}

	@Override
	public List<Transaction> getTransactionsByPayerOrReceiverId(int Id) {
		// TODO Auto-generated method stub
		return this.transactionDAO.getByPayerOrReceiverId(Id);
	}

	@Override
	public List<Transaction> getOrderedTransactionsByPayerOrReceiverId(int Id) {
		// TODO Auto-generated method stub
		return this.transactionDAO.getByPayerOrReceiverIdOrderedByTime(Id);
	}

	@Override
	public void addTransaction(Transaction t) {
		// TODO Auto-generated method stub
		this.transactionDAO.add(t);
	}

	@Override
	public void updateTransaction(Transaction t) {
		// TODO Auto-generated method stub
		this.transactionDAO.update(t);
	}

}
