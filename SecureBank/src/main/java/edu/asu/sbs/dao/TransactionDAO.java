package edu.asu.sbs.dao;

public interface TransactionDAO {

	void debit(int accNumber, String userName, double amount, int acc_type);
	
	void debit_final(int transaction_id);
	
	void credit(int accNumber, String userName, double amount);
	
	void transfer_email(String email_id, String userName, double amount);
	
	void transfer_message(int phone, String userName, double amount);
	
	
}
