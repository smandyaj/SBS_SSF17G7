package edu.asu.sbs.dao;

import java.util.List;

import edu.asu.sbs.model.InternalUser;

public interface InternalUserDAO {

	InternalUser findById(Integer Id);
	
	List<InternalUser> findAll();
	
	void add(InternalUser user);
	
	void update(InternalUser user);
	
	void delete(Integer id);
}
