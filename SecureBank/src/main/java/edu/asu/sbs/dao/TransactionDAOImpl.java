package edu.asu.sbs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.asu.sbs.model.Transaction;

@Repository
public class TransactionDAOImpl implements TransactionDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> listAll(int internalUserType) {
		// TODO Auto-generated method stub
		// 0 - pending, 1 - approved, 2- declined
		if( internalUserType == 0) {
			return getCurrentSession().createQuery("from Transaction where auth=? and status=?")
					.setParameter(0, 1)
					.setParameter(0, 0).list();
		}
		
		return getCurrentSession().createQuery("from Transaction where status=?").setParameter(0, 0).list();
	}

	@Override
	public List<Transaction> listForCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction get(int transactionId) {
		// TODO Auto-generated method stub
		return (Transaction) getCurrentSession().get(Transaction.class, transactionId);
	}

	@Override
	public void add(Transaction t) {
		// TODO Auto-generated method stub
		getCurrentSession().save(t);	
		}

	@Override
	public void update(Transaction t) {
		// TODO Auto-generated method stub
		getCurrentSession().update(t);
	}

	@Override
	public List<Transaction> listForAccount(int accountId) {
		// TODO Auto-generated method stub
		return getCurrentSession().createQuery("from Transaction where auth=? and status=? "
				+ "and (senderAccNumber=? or receiverAccNumber=?)")
				.setParameter(0, 1)
				.setParameter(1, 1).setParameter(2, accountId).setParameter(3, accountId).list();
	}

	@Override
	public List<Transaction> listForPendingTransactions(int customerId) {
		// TODO Auto-generated method stub
		return getCurrentSession().createQuery("from Transaction where auth=? and status=? "
				+ "and payerId=? and receiverId!=? and transactionType=?")
				.setParameter(0, 1)
				.setParameter(1, 1).setParameter(2, customerId).setParameter(3, customerId).setParameter(4, 0).list();
	}

}