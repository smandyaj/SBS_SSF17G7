package edu.asu.sbs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.asu.sbs.dao.TransactionDAO;
import edu.asu.sbs.model.Account;
import edu.asu.sbs.model.Transaction;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionDAO transactionDAO;
	
	@Autowired
	AccountService accountService;
	
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
	
	@Override
	public boolean approveTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		System.out.println("inside approve transaction");

		if (transaction.getStatus() != 0) {
			return false;
		}

		System.out.println("Transaction is pending");

		Account senderAcc = accountService.findByAccountNumber(transaction
				.getSenderAccNumber());
		Account recieverAcc = accountService.findByAccountNumber(transaction
				.getReceiverAccNumber());

		System.out.println("Accounts retreived");

		double amount = transaction.getTransactionAmount();

		// Means credit debit type of transactions
		if (senderAcc.getAccountId() == recieverAcc.getAccountId()) {
			if (transaction.getTransactionType() == 1) {
				senderAcc.setAccountBalance(senderAcc.getAccountBalance() + amount);
				transaction.setStatus(1);
				transaction.setStatus_quo("approved");
				transactionDAO.update(transaction);
			} else {
				return false;
			}
			return true;
		}else {
			System.out.println("updating the account balances for sender/reciever");
			senderAcc.setAccountBalance(senderAcc.getAccountBalance() - amount);
			recieverAcc.setAccountBalance(recieverAcc.getAccountBalance() + amount);
			accountService.updateAccount(senderAcc);
			accountService.updateAccount(recieverAcc);
			transaction.setStatus(1);
			transaction.setStatus_quo("approved");
			transactionDAO.update(transaction);
			System.out.println("updating is done");
			return true;

		}
	}

	@Override
	public boolean isTransferCritical(double amount) {
		// TODO Auto-generated method stub
		if( amount >= 500) {
			return true;
		}
		return false;
	}

}