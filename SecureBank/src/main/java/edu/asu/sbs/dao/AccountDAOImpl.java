package edu.asu.sbs.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.asu.sbs.model.Account;

@Repository
public class AccountDAOImpl implements AccountDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Account> findByCustomerID(int customerId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Account> accounts = new ArrayList<Account>();
		accounts = session.createQuery("from Account where customerId=?").setParameter(0, customerId).list();
		return accounts;
	}


	@Override
	public Account findByAccountNumber(int accNumber) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Account account = new Account();
		account = (Account) session.get(Account.class,accNumber);
		return account;
	}

	@Override
	public BigDecimal getBalance(int accNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().update(account);
	}

}