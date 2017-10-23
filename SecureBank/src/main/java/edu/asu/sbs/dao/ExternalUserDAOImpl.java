package edu.asu.sbs.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import edu.asu.sbs.model.ExternalUser;
import edu.asu.sbs.model.InternalUser;
import edu.asu.sbs.model.ModifiedUser;

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
		externalUser.setEmailId(user.getEmailId());
		externalUser.setPhone(user.getPhone());
		getCurrentSession().update(externalUser);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		ExternalUser externalUser = (ExternalUser) findById(id);
		System.out.println("Internal user "+ externalUser.getEmailId());
		if( externalUser != null) getCurrentSession().delete(externalUser);		
	}

	@Override
	public void update(ModifiedUser user) {
		// TODO Auto-generated method stub
		System.out.println("Updating the values with modified user");
		ExternalUser externalUser = findById(user.getUserId());
		externalUser.setFirstName(user.getFirstName());
		externalUser.setLastName(user.getLastName());
		externalUser.setPhone(user.getPhoneNumber());
		getCurrentSession().update(externalUser);
	}

	@Override
	public ExternalUser findByUserName(String currentUserName){
		Criteria criteria = getCurrentSession().createCriteria(InternalUser.class);
		ExternalUser externalUser = (ExternalUser) criteria.add(Restrictions.eq("userName", currentUserName)).uniqueResult();
		return externalUser;
	}
	
	

}
