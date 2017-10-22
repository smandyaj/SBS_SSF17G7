
	  public List<Account> findAll() {
		// TODO Auto-generated method stub
		return getCurrentSession().createQuery("from account where account_status = 0").list();
	

     @Override
	public void approve_accountstatus(Account acc) {
		// TODO Auto-generated method stub
		System.out.println("updating the status to approved");
		Account a = findById(acc.getaccountnumber());
		a.setStatus(acc.getStatus());
		a.setStatus_quo(acc.getStatus_quo());
		getCurrentSession().update(modUser);
	}
	