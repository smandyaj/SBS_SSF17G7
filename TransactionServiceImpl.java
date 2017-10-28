package edu.asu.sbs.services;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.asu.sbs.dao.TransactionDAO;
import edu.asu.sbs.model.Transaction;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{

@Autowired
TransactionDAO transactionDAO;
@Override
public void addTransaction(Transaction t) {
// TODO Auto-generated method stub
transactionDAO.add(t);
}

@Override
public void updateTransaction(Transaction t) {
// TODO Auto-generated method stub
transactionDAO.update(t);
}

@Override
public List<Transaction> getAllTransaction(Integer type) {
// TODO Auto-generated method stub
return transactionDAO.listAll(type);
}

@Override
public List<Transaction> getTransactions(Integer customerId) {
// TODO Auto-generated method stub
return transactionDAO.listForCustomer(customerId);
}

@Override
public Transaction get(int transactionId) {
// TODO Auto-generated method stub
return transactionDAO.get(transactionId);
}

@Override
public Transaction getTransactionById(int transaction_id) {
// TODO Auto-generated method stub
return null;
}

@Override
public void debit(int accNumber, String userName, double amount, int acc_type) {
// TODO Auto-generated method stub
	transactionDAO.debit(accNumber,  userName,  amount,  acc_type);
}

@Override
public void debit_final(int transaction_id) {
// TODO Auto-generated method stub
	transactionDAO.debit_final(transaction_id);
}

@Override
public void credit(int accNumber, String userName, double amount) {
// TODO Auto-generated method stub
	transactionDAO.credit(accNumber,  userName,  amount);
}

@Override
public void transfer_email(String email_id, String userName, double amount) {
// TODO Auto-generated method stub
	transactionDAO.transfer_email(email_id,  userName,  amount);
	
}

@Override
public void transfer_message(BigInteger phone, String userName, double amount) {
// TODO Auto-generated method stub
	transactionDAO.transfer_message(phone,  userName,  amount);
}


}
