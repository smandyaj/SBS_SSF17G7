package edu.asu.sbs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.asu.sbs.dao.ExternalUserDAO;
import edu.asu.sbs.model.ExternalUser;

@Service
@Transactional
public class ExternalUserServiceImpl implements ExternalUserService{
	
	@Autowired
	ExternalUserDAO externalUserDAO;
	
	@Override
	public ExternalUser findUserById(Integer Id) {
		// TODO Auto-generated method stub
		return externalUserDAO.findById(Id);
	}

	@Override
	public List<ExternalUser> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(ExternalUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(ExternalUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
