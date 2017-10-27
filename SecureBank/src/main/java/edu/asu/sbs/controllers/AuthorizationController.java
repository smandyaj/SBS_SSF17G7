package edu.asu.sbs.controllers;

import java.util.Collection;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.asu.sbs.model.Users;
import edu.asu.sbs.services.InternalUserService;

@Controller
public class AuthorizationController {
	
	
	
	@Autowired
	InternalUserService internalUserService;	

	@Autowired
	SendEmailService sendEmailService;	

	
	@ModelAttribute("user")
	public Users getUserObject() {
		return new Users();
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
    public String getLogin(ModelMap model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		// if already authenticated, redirect to logged in page
		if (!(auth instanceof AnonymousAuthenticationToken)) {

			Collection<? extends GrantedAuthority> authorities = auth
					.getAuthorities();
			for (GrantedAuthority grantedAuthority : authorities) {
				
				// customer
				if (grantedAuthority.getAuthority().equalsIgnoreCase("ROLE_CUSTOMER") || 
						grantedAuthority.getAuthority().equalsIgnoreCase("ROLE_MERCHANT")) {
					return "redirect:/customer/home/";
				} 
				
				// Manager
				if (grantedAuthority.getAuthority().equalsIgnoreCase("ROLE_CLERK")) {
					return "redirect:/employee/home";
				}
				
				// Admin
				if (grantedAuthority.getAuthority().equalsIgnoreCase("ROLE_ADMIN")) {
					System.out.println("*******ADMIN REDIRECT***********");
					return "redirect:/admin/home";
				}
				
				// Manager
				if (grantedAuthority.getAuthority().equalsIgnoreCase("ROLE_MANAGER")) {
					return "redirect:/manager/home";
				}
				
			}
			
		}
		
		model.addAttribute("title", "Welcome! Please Login");
        return "login";
    }
	
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String getLoginRedirect (HttpServletRequest request, HttpServletResponse response) {
        return "redirect:/";
    }
    
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String getLogout (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/?logout";
    }
    
    
    
    
    @RequestMapping(value="/expired", method = RequestMethod.GET)
    public String getExpired(ModelMap model) {
    	model.addAttribute("error", "Your session has expired due to access from another device or browser.");
    	return "auth/login";
    }
    
    @RequestMapping(value="/forgotpass", method = RequestMethod.GET)
    public String getForgotPassword(ModelMap model) {
    	model.addAttribute("title", "Forgot Password");
        return "auth/forgotpassword";
    }
	public Long generateRandomNumberOfLength(int length) {
		// TODO Auto-generated method stub
		Random ran = new Random();
		char[] digits = new char[length];
		digits[0] = (char) (ran.nextInt(9) + '1');
		for (int i = 1; i < length; i++) {
			digits[i] = (char) (ran.nextInt(10) + '0');
		}
		return Long.parseLong(new String(digits));
	}
	
    //
    @RequestMapping(value="/OTPforgotpassword", method = RequestMethod.POST)
    public String postSecurityQuestions(ModelMap model,@ModelAttribute("emailSearch") 
    EmailSearch emailSearch,BindingResult result,RedirectAttributes attr){
    	model.addAttribute("title", "Forgot Password");
    	System.out.println(emailSearch.getEmail());
    	User user = internalUserService.findUserByEmail(emailSearch.getEmail());
    	if(user == null)
    	{
    			attr.addFlashAttribute("failureMsg",
    					"Not a Valid User");
    			return "redirect:/OTPforgotpassword";
    		
    	}
String tempPassword = "" + generateRandomNumberOfLength(9);
		
    	internalUserService.updatePassword(user.getEmail(), tempPassword);
		sendEmailService.sendEmail(user.getEmail(), "Temporary Password Reset", "Your Temporary password is"+tempPassword);

		attr.addFlashAttribute("successMsg",
				"A temporary  password is generated and sent to you.Please use it to login");
		return "redirect:/";
    }
    
    	
}
