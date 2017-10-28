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
	public Double getBalance(int accountNumber) {
		// TODO Auto-generated method stub
		return accountDAO.getBalance(accountNumber);
	}

	@Override
	public void transferFunds(Transaction sender, Transaction receiver, BigDecimal amount) {
		// TODO Auto-generated method stub
		
	}

}
