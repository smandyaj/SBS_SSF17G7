package edu.asu.sbs.dao;

import java.util.List;

import edu.asu.sbs.model.InternalUser;
import edu.asu.sbs.model.Role;
import edu.asu.sbs.model.Users;

public interface RoleDAO {
	
	void add(Role role);
	Role findRoleByUserName(String userName);
	public void deleteRole(int id);
	public Role findById(Integer Id);
}
