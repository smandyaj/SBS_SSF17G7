package edu.asu.sbs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.asu.sbs.model.Role;

@Repository
public class RoleDAOImpl implements RoleDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void add(Role role) {
		// TODO Auto-generated method stub
		getCurrentSession().save(role);
	}

	@Override
	public Role findRoleByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}