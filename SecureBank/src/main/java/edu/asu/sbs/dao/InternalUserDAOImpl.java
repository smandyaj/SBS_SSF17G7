package edu.asu.sbs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.asu.sbs.model.InternalUser;

@Repository
public class InternalUserDAOImpl implements InternalUserDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public InternalUser findById(Integer Id) {
		// TODO Auto-generated method stub
		InternalUser internalUser = (InternalUser) getCurrentSession().get(InternalUser.class, Id);
		return internalUser;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InternalUser> findAll() {
		// TODO Auto-generated method stub
		return getCurrentSession().createQuery("from InternalUser").list();
	}

	@Override
	public void add(InternalUser user) {
		// TODO Auto-generated method stub
		getCurrentSession().save(user);
		
	}

	@Override
	public void update(InternalUser user) {
		// TODO Auto-generated method stub
		InternalUser internalUser = findById(user.getEmployeeId());
		internalUser.setAddress(user.getAddress());
		internalUser.setEmailId(user.getEmailId());
		internalUser.setPhoneNumber(user.getPhoneNumber());
		getCurrentSession().update(internalUser);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		InternalUser internalUser = findById(id);
		System.out.println("Internal user "+ internalUser.getEmailId());
		if( internalUser != null) getCurrentSession().delete(internalUser);		
	}
	

}
