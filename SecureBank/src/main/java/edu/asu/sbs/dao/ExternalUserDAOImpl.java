package edu.asu.sbs.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.asu.sbs.model.ExternalUser;
import edu.asu.sbs.model.InternalUser;
import edu.asu.sbs.model.ModifiedUser;
import edu.asu.sbs.model.Role;
import edu.asu.sbs.model.Users;
import edu.asu.sbs.services.BCryptHashService;

@Repository
public class ExternalUserDAOImpl implements ExternalUserDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	RoleDAO roleDAO;
	
	@Autowired
	BCryptHashService bCryptHashService;
	
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
	public void add(ExternalUser externalUser) {
		// TODO Auto-generated method stub
		String encodedPwd = bCryptHashService.getBCryptHash(externalUser.getPasswordHash());
		getCurrentSession().save(externalUser);
		// add to users table
		System.out.println("Adding to users table");
		Users user = new Users(externalUser.getUserName(),encodedPwd,1);
		userDAO.add(user);
		// add to user_roles table with appropriate role
		System.out.println("Adding to roles table");
		String userRole = externalUser.getCustomerType() == 0 ? "ROLE_CUSTOMER" : "ROLE_MERCHANT";
		Role role = new Role(externalUser.getUserName(),userRole);
		roleDAO.add(role);
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

	@Override
	public void update(ModifiedUser user) {
		// TODO Auto-generated method stub
		System.out.println("Updating the values with modified user for external user");
		ExternalUser externalUser = findById(user.getUserId());
		externalUser.setFirstName(user.getFirstName());
		externalUser.setLast_name(user.getLastName());
		externalUser.setPhone(user.getPhoneNumber());
		getCurrentSession().update(externalUser);
	}

	@Override
	public ExternalUser findByUserName(String userName) {
		// TODO Auto-generated method stub
		Criteria criteria = getCurrentSession().createCriteria(ExternalUser.class);
		ExternalUser externalUser = (ExternalUser) criteria.add(Restrictions.eq("userName", userName)).uniqueResult();
		return externalUser;
	}
	
}
