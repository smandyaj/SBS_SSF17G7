package edu.asu.sbs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.asu.sbs.model.ExternalUser;
import edu.asu.sbs.model.InternalUser;

public class ExternalUserDAOImpl implements ExternalUserDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public ExternalUser findById(Integer Id) {
		// TODO Auto-generated method stub
		ExternalUser externalUser = (ExternalUser) getCurrentSession().get(ExternalUser.class, Id);
		return externalUser;
	}

}
