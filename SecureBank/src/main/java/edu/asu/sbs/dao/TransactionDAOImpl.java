package edu.asu.sbs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.asu.sbs.model.Transaction;

public class TransactionDAOImpl implements TransactionDAO{
	
	private SessionFactory sessionFactory;
	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public Transaction getById(int Id) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().get(Transaction.class, Id);
	}

	@Override
	public List<Transaction> getByPayerId(int Id) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().createQuery("from Transaction t where t.payerId = ?").setParameter(0, Id).list();
	}

	@Override
	public List<Transaction> getByReceiverId(int Id) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().createQuery("from Transaction t where t.receiverId = ?").setParameter(0, Id).list();
	}

	@Override
	public List<Transaction> getByPayerOrReceiverId(int Id) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().createQuery("from Transaction t where t.payerId = ? or t.receiverId = ?")
				.setParameter(0, Id)
				.setParameter(1, Id)
				.list();
	}

	@Override
	public List<Transaction> getByPayerOrReceiverIdOrderedByTime(int Id) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().createQuery("from Transaction t where t.payerId = ? or t.receiverId = ? order by t.transactionCreateTime")
				.setParameter(0, Id)
				.setParameter(1, Id)
				.list();
	}

	@Override
	public void add(Transaction t) {
		// TODO Auto-generated method stub
		this.getCurrentSession().save(t);
	}

	@Override
	public void update(Transaction t) {
		// TODO Auto-generated method stub
		this.getCurrentSession().update(t);
	}

}
