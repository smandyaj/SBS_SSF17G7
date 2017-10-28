package edu.asu.sbs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.asu.sbs.dao.UserDAO;
import edu.asu.sbs.model.Users;
import edu.asu.sbs.services.BCryptHashService;

public class UserServiceImpl implements UserService{
	
	@Autowired
	BCryptHashService bCryptHashService;
	
	@Autowired
	UserService userService;
	

 public void updatePassword(String email, String password) {

		password = bCryptHashService.getBCryptHash(password);
		userService.updatePassword(email, password);

	}
}