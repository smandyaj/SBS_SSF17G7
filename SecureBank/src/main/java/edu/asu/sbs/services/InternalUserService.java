package edu.asu.sbs.services;

import java.util.List;

import edu.asu.sbs.model.InternalUser;

public interface InternalUserService {

	InternalUser findUserById(Integer Id);
	
	List<InternalUser> findAllUsers();
	
	void addUser(InternalUser user);
	
	void updateUser(InternalUser user);
	
	void deleteUser(Integer id);
}
