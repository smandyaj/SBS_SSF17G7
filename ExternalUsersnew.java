

	
	@RequestMapping(value="/admin/externaluser-add-modify")
	public ModelAndView addingExternalUser(@ModelAttribute ExternalUser externalUser) {
		System.out.println("Adding new Externaluser and redirecting" + externalUser.getPasswordHash());
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		externalUser.setCreationDate(date);
		externalUser.setLastLogin(date);
		
		if( externalUser.customerId() == 0) {
			System.out.println("Add User" + externalUser.getEmployeeId());
			externalUserService.addUser(externalUser);	
		}else {
			System.out.println("Modify User" + externalUser.getcustomerId());
			externalUserService.updateUser(externalUser);
		}
		ModelAndView modelAndView = new ModelAndView("customer list");
		System.out.println("All Users Page");
		@SuppressWarnings("rawtypes")
		List customers = externalUserService.findAllUsers();
		modelAndView.addObject("customers", customers);
		return modelAndView;
	}