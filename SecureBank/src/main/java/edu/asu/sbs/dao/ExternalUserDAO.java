package edu.asu.sbs.dao;

import java.math.BigInteger;
import java.util.List;

import edu.asu.sbs.model.ExternalUser;
import edu.asu.sbs.model.InternalUser;
import edu.asu.sbs.model.ModifiedUser;

public interface ExternalUserDAO {
	
	ExternalUser findById(Integer Id);
	
	List<ExternalUser> findAll();
	
	void add(ExternalUser user);
	
	void update(ExternalUser user);
	void update(ModifiedUser user);
	
	void delete(Integer id);
	
	ExternalUser findByUserName(String userName);
	
	ExternalUser findByPhoneNumber(BigInteger phoneNumber);
	
	ExternalUser findByEmailId(String emailId);
}
