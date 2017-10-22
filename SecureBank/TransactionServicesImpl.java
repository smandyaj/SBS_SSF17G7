package edu.asu.sbs.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.asu.sbs.dao.TranscationDAO;
import edu.asu.sbs.model.Transaction;
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactioDAO transactionDAO;
	
	@Override
	public List<Transaction> getTransactionByTransactionId(int transactionId) {
		// TODO Auto-generated method stub
		return transactionDAO.findByTransactionID(transactionId);
	}

	@Override
	public Transaction getTransactionAmount(int TransactionAmount) {
		// TODO Auto-generated method stub
		return transactionDAO.findByTransactionAmount(TransactionAmount);
	}

	@Override
	public void updateTransactionStatus(Transaction transaction) {
		
		transaction.updateTransactionStatus(transaction);
		
	}


	@Override
	public void transferFunds(Transaction sender, Transaction receiver, BigDecimal amount) {
		// TODO Auto-generated method stub
		
	}

}