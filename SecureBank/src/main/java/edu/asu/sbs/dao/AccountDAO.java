package edu.asu.sbs.dao;

import java.math.BigDecimal;
import java.util.List;

import edu.asu.sbs.model.Account;

public interface AccountDAO {
	List<Account> findByCustomerID(int customerId);
	Account findByAccountNumber(int accNumber);
	public Double getBalance(int accNumber);
	public void updateAccount(Account account);
	
}
