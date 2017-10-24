package edu.asu.sbs.dao;

import java.math.BigDecimal;
import java.util.List;

import edu.asu.sbs.model.Account;

public interface CreditCardDAO {
	public Account getBalance(String accountNumber);
	public double	getCreditLimit();
	public double LatePaymentFee();
}
