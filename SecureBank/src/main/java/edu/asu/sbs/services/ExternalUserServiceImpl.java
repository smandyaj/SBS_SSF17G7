package edu.asu.sbs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.asu.sbs.dao.ExternalUserDAO;
import edu.asu.sbs.model.ExternalUser;
import edu.asu.sbs.model.ModifiedUser;

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
		return externalUserDAO.findAll();
	}

	@Override
	public void addUser(ExternalUser user) {
		// TODO Auto-generated method stub
		 externalUserDAO.add(user);
	}

	@Override
	public void updateUser(ExternalUser user) {
		// TODO Auto-generated method stub
		externalUserDAO.update(user);
		
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(ModifiedUser user) {
		// TODO Auto-generated method stub
		externalUserDAO.update(user);
	}

	@Override
	public ExternalUser findByUserName() {
		// TODO Auto-generated method stub
		String currentUserName = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    currentUserName = authentication.getName();
		    System.out.println("Current logged in user" + currentUserName);
		}
		
		return externalUserDAO.findByUserName(currentUserName);
	}

}
