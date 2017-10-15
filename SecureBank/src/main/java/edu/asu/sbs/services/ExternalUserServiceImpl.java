package edu.asu.sbs.services;

import java.io.Externalizable;

import org.springframework.beans.factory.annotation.Autowired;

import edu.asu.sbs.dao.ExternalUserDAO;
import edu.asu.sbs.model.ExternalUser;

public class ExternalUserServiceImpl implements ExternalUserService{
	
	
	@Autowired
	ExternalUserDAO externalUserDAO;
	
	@Override
	public ExternalUser findUserById(Integer Id) {
		// TODO Auto-generated method stub
		return externalUserDAO.findById(Id);
	}
}
