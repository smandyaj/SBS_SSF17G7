package edu.asu.sbs.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import edu.asu.sbs.model.InternalUser;
import edu.asu.sbs.model.ModifiedUser;

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

	@Override
	public void update(ModifiedUser user) {
		// TODO Auto-generated method stub
		System.out.println("Updating the values with modified user");
		InternalUser internalUser = findById(user.getUserId());
		internalUser.setFirstName(user.getFirstName());
		internalUser.setLastName(user.getLastName());
		internalUser.setPhoneNumber(user.getPhoneNumber());
		getCurrentSession().update(internalUser);
	}

	@Override
	public InternalUser findByUserName(String currentUserName){
		Criteria criteria = getCurrentSession().createCriteria(InternalUser.class);
		InternalUser internalUser = (InternalUser) criteria.add(Restrictions.eq("userName", currentUserName)).uniqueResult();
		return internalUser;
	}
	

}
