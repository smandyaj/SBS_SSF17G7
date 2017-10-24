package edu.asu.sbs.services;

import java.util.List;

import edu.asu.sbs.model.ExternalUser;

public interface ExternalUserService {

	ExternalUser findUserById(Integer Id);
	
	List<ExternalUser> findAllUsers();
	
	void addUser(ExternalUser user);
	
	void updateUser(ExternalUser user);
	
	void deleteUser(Integer id);
	
	ExternalUser findByUserName();
}
