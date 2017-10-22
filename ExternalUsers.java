
	@RequestMapping(value="/admin/employee-add-modify")
	public ModelAndView addingInternalUser(@ModelAttribute InternalUser internalUser) {
		System.out.println("Adding new user and redirecting" + internalUser.getPasswordHash());
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		internalUser.setCreationDate(date);
		internalUser.setLastLogin(date);
		
		if( internalUser.getEmployeeId() == 0) {
			System.out.println("Add User" + internalUser.getEmployeeId());
			internalUserService.addUser(internalUser);	
		}else {
			System.out.println("Modify User" + internalUser.getEmployeeId());
			internalUserService.updateUser(internalUser);
		}
		ModelAndView modelAndView = new ModelAndView("employeelist");
		System.out.println("All Users Page");
		@SuppressWarnings("rawtypes")
		List employees = internalUserService.findAllUsers();
		modelAndView.addObject("employees", employees);
		return modelAndView;
	}