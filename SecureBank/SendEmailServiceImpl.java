package edu.asu.sbs.services;

import java.util.List;

import edu.asu.sbs.model.ExternalUser;
import edu.asu.sbs.dao.ExternalUserDAO;
import edu.asu.sbs.services.SENDEMAIL;
import edu.asu.sbs.services.OTP;

public class SendEmailServiceImpl {
	ExternalUserDAO externaluser;
	String temp= OTP.generateOTP;
	public ExternalUser findbyemail(String username){
	return externaluser.findByUserName(username);
	}
	
	public 	void sendemail(externaluser.findbyemail)
	
	SENDEMAIL newmail=newmail.SENDEMAIL(findbyemail(username),"Authentacation email","temp");
	
	
	
}
