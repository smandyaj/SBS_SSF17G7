package edu.asu.sbs.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.asu.sbs.dao.TranscationDAO;
import edu.asu.sbs.model.Transaction;
@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionDAO transactionDAO;
	
	
	@Override
	public void updateTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		transactionDAO.updateTransaction(transaction);
		
	}


}