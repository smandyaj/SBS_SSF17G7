package edu.asu.sbs.dao;

import org.springframework.security.core.userdetails.User;

import edu.asu.sbs.model.Role;
import edu.asu.sbs.model.Users;

public interface UserDAO {

	void add(Users user);
	Users findRoleByUserName(String userName);
}
