package edu.asu.sbs.services;

import java.util.List;

import edu.asu.sbs.model.Users;

public interface UserService {

	public void updatePassword(String email, String password);
}
