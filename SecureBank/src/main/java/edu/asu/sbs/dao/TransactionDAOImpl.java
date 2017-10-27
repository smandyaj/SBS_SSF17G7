package edu.asu.sbs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.asu.sbs.model.Account;
import edu.asu.sbs.model.ExternalUser;
import edu.asu.sbs.model.Transaction;
import edu.asu.sbs.services.AccountService;
import edu.asu.sbs.services.ExternalUserService;
import edu.asu.sbs.services.TransactionService;

@Repository
public class TransactionDAOImpl implements TransactionDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	



	@Autowired
	AccountService as;
	@Autowired
	ExternalUserService ts;
	@Autowired
	TransactionService t1;
	private Session getCurrentSession() {
	return sessionFactory.getCurrentSession();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> listAll(int internalUserType) {
	// TODO Auto-generated method stub
	return getCurrentSession().createQuery("from Transaction where auth=?").setParameter(0, 1).list();
	}

	@Override
	public List<Transaction> listForCustomer(int customerId) {
	// TODO Auto-generated method stub
	return null;
	}

	@Override
	public Transaction get(int transactionId) {
	// TODO Auto-generated method stub
	return (Transaction) getCurrentSession().get(Transaction.class, transactionId);
	}

	@Override
	public void add(Transaction t) {
	// TODO Auto-generated method stub
	getCurrentSession().save(t); 
	}

	@Override
	public void update(Transaction t) {
	// TODO Auto-generated method stub
	getCurrentSession().update(t);
	}

	@Override
	public void debit(int accNumber, String userName, double amount, int acc_type){
	// TODO Auto-generated method stub
	ExternalUser e = ts.findByUserName();
	// Add userName to Account Table
	int customer_id = e.getCustomerId();
	// Account number and amount belongs to the person who is receiving the money 
	List<Account> merchantAccounts = as.getAccountByCustomerId(customer_id);
	Account merchantAcc = null;
	for(Account ai: merchantAccounts) {
	if(ai.getAccountType() == acc_type){
	merchantAcc = ai;
	break;
	}
	}
	if(merchantAcc == null) {
	return;
	}
	int merchantAccount = merchantAcc.getCustomerId();
	double merchantBalance = as.getBalance(merchantAccount + "").doubleValue();
	if(merchantBalance >= amount){
	Transaction t = new Transaction();
	t.setPayerId(merchantAccount + "");
	t.setReceiverId(accNumber + "");
	t.setTransactionAmount(amount);
	t1.addTransaction(t); // Need to add from SAM
	}
	}


	@Override
	public void debit_final(int transaction_id){
	Session session = this.sessionFactory.getCurrentSession();
	Transaction t =t1.getTransactionById(transaction_id); // the function is added by SAM
	String payer_id = t.getPayerId();
	String receiver_id = t.getReceiverId();
	double transaction_amount = t.getTransactionAmount();
	Account a = as.getAccountByNumber(payer_id);
	double balance = a.getAccountBalance();
	balance -= transaction_amount;
	Account a1 = as.getAccountByNumber(receiver_id);
	double rbalance = a1.getAccountBalance();
	rbalance += transaction_amount;
	a.setAccountBalance(balance);
	a1.setAccountBalance(rbalance);
	as.updateAccount(a1);
	as.updateAccount(a);
	}

	@Override
	public void credit(int accNumber, String userName, double amount){
	// TODO Auto-generated method stub
	Session session = this.sessionFactory.getCurrentSession();
	ExternalUser e = ts.findByUserName();
	// Add userName to Account Table
	int customer_id = e.getCustomerId();
	List<Account> accounts = as.getAccountByCustomerId(customer_id); 

	Account merchantAcc = null;
	for(Account ai: accounts) {
	if(ai.getAccountType() == 0){
	merchantAcc = ai;
	break;
	}
	}
	if(merchantAcc == null) {
	return;
	}
	int merchantAccount = merchantAcc.getCustomerId();
	double merchantBalance = as.getBalance(merchantAccount + "").doubleValue();
	// Assumption that transaction has been approved by Merchant - we are getting the above parameters using JSP 
	// accNumber & amount - user paying to merchant
	double payyeBalance = as.getBalance(accNumber + "").doubleValue();
	if(payyeBalance >= amount){
	merchantBalance += amount;
	payyeBalance = payyeBalance - amount;
	Account a1 = as.getAccountByNumber(accNumber + "");
	merchantAcc.setAccountBalance(merchantBalance);
	a1.setAccountBalance(payyeBalance);
	as.updateAccount(a1);
	as.updateAccount(merchantAcc);
	}
	} 

	// Create model for modified user
	// Transfer through email and message
	//Transfer through email
	@Override
	public void transfer_email(String email_id, String userName, double amount){
	// ADD ACCOUNT_NUMBER accNumber FIELD IN EXTERNAL USER TABLE
	ExternalUser e1 = ts.findByEmail(email_id);
	int customerId = e1.getCustomerId(); // Define Modifieduser model with getter and setter
	List<Account> accounts = as.getAccountByCustomerId(customerId); 

	Account a = null;
	for(Account ai: accounts) {
	if(ai.getAccountType() == 0){
	a = ai;
	break;
	}
	}
	if(a == null) {
	return;
	}
	int accountNo = a.getAccountId();
	debit(accountNo, userName, amount, 0);
	}
	//Transfer through message
	@Override
	public void transfer_message(int phone, String userName, double amount){
	ExternalUser e1 = ts.findByPhone(phone);
	int customerId = e1.getCustomerId(); // Define Modifieduser model with getter and setter
	List<Account> accounts = as.getAccountByCustomerId(customerId); 

	Account a = null;
	for(Account ai: accounts) {
	if(ai.getAccountType() == 0){
	a = ai;
	break;
	}
	}
	if(a == null) {
	return;
	}
	int accountNo = a.getAccountId();
	debit(accountNo, userName, amount, 0);
	}

}