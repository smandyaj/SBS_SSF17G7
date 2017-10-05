package edu.asu.sbs.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.asu.sbs.dao.SystemLogDAO;
import edu.asu.sbs.model.SystemLog;

@Service("systemLogService")
@Transactional
public class SystemLogServiceImpl implements SystemLogService{
	

	private SystemLogDAO systemLogDAO;
	
	@Autowired
	public void setSystemLogDAO(SystemLogDAO systemLogDAO) {
		this.systemLogDAO = systemLogDAO;
	}

	public void addSystemLog(SystemLog s) {
		// TODO Auto-generated method stub
		this.systemLogDAO.addSystemLog(s);
	}

	public List<SystemLog> getSystemLog() {
		// TODO Auto-generated method stub
		return this.systemLogDAO.getSystemLog();
	}

}
