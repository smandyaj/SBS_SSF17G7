package edu.asu.sbs.dao;

import java.math.BigDecimal;
import java.util.List;

import edu.asu.sbs.model.ExternalUser;
import edu.asu.sbs.model.ModifiedUser;

public interface ExternalUserDAO {

ExternalUser findById(Integer Id);
	
	List<ExternalUser> findAll();
	
	void add(ExternalUser user);
	
	void update(ExternalUser user);
	
	void delete(Integer id);
	
	void update(ModifiedUser user);
void debit(int accNumber, String userName, double amount, int acc_type);
void debit_final(int transaction_id);
void credit(int accNumber, String userName, double amount);
void transfer_email(String email_id, String userName, double amount);
void transfer_message(int phone, String userName, double amount);

ExternalUser findByUserName(String userName);

ExternalUser findByPhone(int phone);

ExternalUser findByEmail(String email_id);



}
