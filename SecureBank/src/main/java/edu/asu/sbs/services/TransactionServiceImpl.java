package edu.asu.sbs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.asu.sbs.dao.TransactionDAO;
import edu.asu.sbs.model.Transaction;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionDAO transactionDAO;
	
	@Override
	public void addTransaction(Transaction t) {
		// TODO Auto-generated method stub
		 transactionDAO.add(t);
	}

	@Override
	public void updateTransaction(Transaction t) {
		// TODO Auto-generated method stub
		transactionDAO.update(t);
	}

	@Override
	public List<Transaction> getAllTransaction(Integer type) {
		// TODO Auto-generated method stub
		return transactionDAO.listAll(type);
	}

	@Override
	public List<Transaction> getTransactions(Integer customerId) {
		// TODO Auto-generated method stub
		return transactionDAO.listForCustomer(customerId);
	}

	@Override
	public Transaction get(int transactionId) {
		// TODO Auto-generated method stub
		return transactionDAO.get(transactionId);
	}

}
