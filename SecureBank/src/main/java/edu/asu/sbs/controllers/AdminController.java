package edu.asu.sbs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.asu.sbs.model.SystemLog;
import edu.asu.sbs.services.SystemLogService;

@Controller
public class AdminController {

	@Autowired
	private SystemLogService systemLogService;
	
	
	/** Lists all the System logs */
	@RequestMapping(value="/admin/systemlogs",method=RequestMethod.GET)
	public String getSystemLogs(Model model) {
		System.out.println("Fetching System logs..");
		List<SystemLog> systemLogList = systemLogService.getSystemLog();
		for(SystemLog log : systemLogList) {
			System.out.println(log.getFirstName());
		}
		model.addAttribute("systemLog", new SystemLog());
		model.addAttribute("systemLogList", systemLogList);
		model.addAttribute("msg", " Welcome Santosh");
		return "systemLog";
	}
	
	/** Add new System Log to the DB 
	 *  call the system log method
	 *  where its required. 
	 *  This is just for testing purpose
	 * */
	public String addSystemLog(@ModelAttribute("systemLog") SystemLog systemLog) {
		return "redirect:/systemLog";
	}

}
