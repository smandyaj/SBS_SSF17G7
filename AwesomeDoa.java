@SuppressWarnings("unchecked")
	public User findInternalUserByID(String ID) {

		List<User> users = new ArrayList<User>();
		
		
		logger.info("findInternalUserByID called");
		

		users = getSession()
				.createQuery("from User where CustomerID=? and UserType in (?,?)")
				.setParameter(0, ID)
				.setParameter(1,"Regular")
				.setParameter(2,"Manager")
				.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}
	
	// void updatePassword(String email, String password);
	
	// put in service
	public void updatePassword(String email, String password) {

		password = hashService.getBCryptHash(password);
		dao.updatePassword(email, password);

	}