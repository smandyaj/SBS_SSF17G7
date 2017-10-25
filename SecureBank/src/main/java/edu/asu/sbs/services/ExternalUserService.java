package edu.asu.sbs.services;

import java.util.List;

import edu.asu.sbs.model.ExternalUser;
import edu.asu.sbs.model.ModifiedUser;

public interface ExternalUserService {

	ExternalUser findUserById(Integer Id);
	
	List<ExternalUser> findAllUsers();
	
	void addUser(ExternalUser user);
	
	void updateUser(ExternalUser user);
	
	void updateUser(ModifiedUser user);
	
	void deleteUser(Integer id);
}
