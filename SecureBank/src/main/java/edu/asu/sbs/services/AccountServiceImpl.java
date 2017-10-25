package edu.asu.sbs.services;

import java.util.List;

import edu.asu.sbs.dao.AccountDAO;
import edu.asu.sbs.model.Account;

public class AccountServiceImpl implements AccountService{
	
	private AccountDAO accountDAO;
	

	@Override
	public Account getAccountByAccountId(Integer accountId) {
		// TODO Auto-generated method stub
		return this.accountDAO.findByAccountId(accountId);
	}

	@Override
	public List<Account> getAccountByCustomerId(Integer customerId) {
		// TODO Auto-generated method stub
		return this.accountDAO.findByCustomerId(customerId);
	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		this.accountDAO.update(account);
		
	}

	@Override
	public double getBalance(Integer accountId) {
		// TODO Auto-generated method stub
		Account account = this.accountDAO.findByAccountId(accountId);
		return account.getAccountBalance();
	}

	@Override
	public List<Account> getAccountByAccountType(Integer customerId, int type) {
		// TODO Auto-generated method stub
		return this.accountDAO.findByAccountType(customerId, type);
	}

}
