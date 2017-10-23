package edu.asu.sbs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import edu.asu.sbs.dao.ExternalUserDAO;
import edu.asu.sbs.model.ExternalUser;


public class ExternalUserServiceImpl implements ExternalUserService{
@Autowired
ExternalUserDAO externalUserDAO;
@Override
public ExternalUser findById(Integer Id) {
// TODO Auto-generated method stub
return externalUserDAO.findById(Id);
}

@Override
public List<ExternalUser> findAll() {
// TODO Auto-generated method stub
return externalUserDAO.findAll();
}

@Override
public void add(ExternalUser user) {
// TODO Auto-generated method stub
externalUserDAO.add(user);
}

@Override
public void update(ExternalUser user) {
// TODO Auto-generated method stub
externalUserDAO.update(user);
}

@Override
public void delete(Integer id) {
// TODO Auto-generated method stub
externalUserDAO.delete(id);
}



@Override
public ExternalUser findByUserName(String currentUserName) {
// TODO Auto-generated method stub
Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
if (!(authentication instanceof AnonymousAuthenticationToken)) {
    currentUserName = authentication.getName();
    System.out.println("Current logged in user" + currentUserName);
}
        
        return externalUserDAO.findByUserName(currentUserName);
}


@Override
public void debit(int accNumber, String userName, double amount, int acc_type) {
	externalUserDAO.debit(accNumber, userName, amount, acc_type);
}

@Override
public void debit_final(int transaction_id) {
	externalUserDAO.debit_final(transaction_id);
}

@Override
public void credit(int accNumber, String userName, double amount) {
	externalUserDAO.credit(accNumber, userName, amount);
}

@Override
public void transfer_email(String email_id, String userName, double amount) {
	externalUserDAO.transfer_email(email_id, userName, amount);
}

@Override
public void transfer_message(int phone, String userName, double amount) {
	externalUserDAO.transfer_message(phone, userName, amount);
}

public ExternalUser findByPhone(int phone) {
	// TODO Auto-generated method stub
	        
	        return externalUserDAO.findByPhone(phone);
	}

public ExternalUser findByEmail(String email_id) {
	// TODO Auto-generated method stub
	
	        return externalUserDAO.findByEmail(email_id);
	}






}