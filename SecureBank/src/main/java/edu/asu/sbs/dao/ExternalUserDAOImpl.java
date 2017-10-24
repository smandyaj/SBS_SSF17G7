package edu.asu.sbs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.asu.sbs.model.ExternalUser;

@Repository
public class ExternalUserDAOImpl implements ExternalUserDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public ExternalUser findById(Integer Id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		ExternalUser externalUser = (ExternalUser) session.get(ExternalUser.class, Id);
		return externalUser;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExternalUser> findAll() {
		// TODO Auto-generated method stub
		return getCurrentSession().createQuery("from ExternalUser").list();
	}

	@Override
	public void add(ExternalUser user) {
		// TODO Auto-generated method stub
		getCurrentSession().save(user);
		
	}

	@Override
	public void update(ExternalUser user) {
		// TODO Auto-generated method stub
		ExternalUser externalUser = findById(user.getCustomerId());
		externalUser.setCustomer_address(user.getCustomerAddress());
		externalUser.setEmail_id(user.getEmailId());
		externalUser.setPhone(user.getPhone());
		getCurrentSession().update(externalUser);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ExternalUser externalUser = findById(id);
		System.out.println("External user "+ externalUser.getEmailId());
		if( externalUser != null) getCurrentSession().delete(externalUser);		
	}
	
}
