package edu.asu.sbs.dao;
import java.util.List;
import edu.asu.sbs.model.Account;
import edu.asu.sbs.model.CreditCard;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


@Repository
public class CreditCardImplDAO implements CreditCardDAO {

	@Autowired
	SessionFactory sessionFactory;
	boolean late = false;
	@Override
	public Account getBalance(String accountNumber) {
			Session session = this.sessionFactory.getCurrentSession();
	
		Query query = session.createQuery("From Account WHERE accountNumber = :accountNumber");
		query.setParameter("accountNumber", accountNumber);
			@SuppressWarnings("unchecked")
			List<Account> list = query.list();
			Account balance;
			if(list.size() != 0) {
				balance = list.get(0);
				System.out.println("The balance is:"+balance.getAccountBalance());
				session.close();
				return balance;
			}
		return null;
	}
	
	@Override
	public double getCreditLimit() {
		CreditCard c = new CreditCard();
	return	c.getCreditLimit();
		
	}
	
	@Override
	public double LatePaymentFee() {

	//"3% per month";
	if (late==true) {
		double lateFee = 20.0;
	CreditCard c = new CreditCard();
	return (c.getBalance() * 0.02) + (c.getBalance()* 0.03) + 20;}
	else 
		return 0.0;
	}

	
}
