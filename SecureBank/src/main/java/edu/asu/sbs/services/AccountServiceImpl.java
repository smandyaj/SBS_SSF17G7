package edu.asu.sbs.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.asu.sbs.dao.AccountDAO;
import edu.asu.sbs.model.Account;
import edu.asu.sbs.model.Transaction;
@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountDAO accountDAO;
	
	@Override
	public List<Account> getAccountByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		return accountDAO.findByCustomerID(customerId);
	}

	@Override
	public Account getAccountByNumber(int accountNumber) {
		// TODO Auto-generated method stub
		return accountDAO.findByAccountNumber(accountNumber);
	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		accountDAO.updateAccount(account);
		
	}

	@Override
	public BigDecimal getBalance(int accountNumber) {
		// TODO Auto-generated method stub
		return accountDAO.getBalance(accountNumber);
	}

	@Override
	public void transferFunds(Transaction sender, Transaction receiver, BigDecimal amount) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public boolean approveTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
/*		System.out.println("inside approve transaction");

		if (transaction.getStatus() != 0) {
			return false;
		}

		System.out.println("Transaction is pending");

		Account senderAcc = accountDAO.findByAccountNumber(transaction
				.getSenderAccNumber());
		Account recieverAcc = accountDAO.findByAccountNumber(transaction
				.getReceiverAccNumber());

		System.out.println("Accounts retreived");

		double amount = transaction.getTransactionAmount();

		// Means credit debit type of transactions
		if (senderAcc.getNumber().equals(recieverAcc.getNumber())) {
			if (transaction.getType().equalsIgnoreCase("credit")) {
				senderAcc.setBalance(senderAcc.getBalance().add(amount));
			} else if(amount.compareTo(zero) == 1 && senderAcc.getBalance().compareTo(
					amount) == 1) {
				senderAcc.setBalance(senderAcc.getBalance().subtract(amount));
			
			} else {
				return false;
			}
			
			transaction.setBalance(senderAcc.getBalance());
			transaction.setStatus("approved");
			senderAcc.setUpdatedAt(now);
			transaction.setUpdatedAt(now);
			updateTransaction(transaction);

			return true;

		}

		// For other transactions
		if ((amount.compareTo(zero) == 1 && senderAcc.getBalance().compareTo(
				amount) == 1)) {

			senderAcc.setBalance(senderAcc.getBalance().subtract(amount));
			senderAcc.setUpdatedAt(now);
			recieverAcc.setBalance(recieverAcc.getBalance().add(amount));
			recieverAcc.setUpdatedAt(now);

			if (transaction.getType().equalsIgnoreCase("credit")) {
				transaction.setBalance(recieverAcc.getBalance());
				updateTransactionPair(transaction, "approved",
						senderAcc.getBalance());
			} else {
				transaction.setBalance(senderAcc.getBalance());
				updateTransactionPair(transaction, "approved",
						recieverAcc.getBalance());
			}

			transaction.setStatus("approved");
			transaction.setUpdatedAt(now);
			updateTransaction(transaction);
			accountService.updateAccount(senderAcc);
			accountService.updateAccount(recieverAcc);

			return true;

		}*/

		return false;
	}

}
