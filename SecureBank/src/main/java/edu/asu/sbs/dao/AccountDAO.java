package edu.asu.sbs.dao;

import java.util.List;

import edu.asu.sbs.model.Account;

public interface AccountDAO{

	Account findByAccountId(Integer Id);
	
	List<Account> findByCustomerId(Integer Id);
	
	List<Account> findByAccountType(Integer customerId, Integer type);
	
	void add(Account account);
	
	void update(Account account);
	
	void delete(Integer accountId);
	
	
	
}
