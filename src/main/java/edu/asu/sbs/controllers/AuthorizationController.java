package edu.asu.sbs.controllers;

import java.util.Collection;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.asu.sbs.services.BCryptHashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.asu.sbs.model.Email;
import edu.asu.sbs.model.EmailSearch;
import edu.asu.sbs.model.OTPForPassword;
import edu.asu.sbs.model.UpdatePassword;
import edu.asu.sbs.model.Users;
import edu.asu.sbs.services.EmailService;
import edu.asu.sbs.services.UserService;

@Controller
public class AuthorizationController {

	@Autowired
	UserService userService;
	
	@Autowired
	EmailService sendEmailService;
	
	@Autowired
	BCryptHashService bCryptHashService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getLogin(ModelMap model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		// if already authenticated, redirect to logged in page
		if (!(auth instanceof AnonymousAuthenticationToken)) {

			Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
			for (GrantedAuthority grantedAuthority : authorities) {

				// customer
				if (grantedAuthority.getAuthority().equalsIgnoreCase("ROLE_CUSTOMER")
						|| grantedAuthority.getAuthority().equalsIgnoreCase("ROLE_MERCHANT")) {
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

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginRedirect(HttpServletRequest request, HttpServletResponse response) {
		return "redirect:/";
	}

	@RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
	public ModelAndView getForgotPassowordPage() {
		return new ModelAndView("forgotPassword");
	}

	@RequestMapping(value = "/OTPforgotpassword", method = RequestMethod.POST)
	public String OTPforgotpassword(ModelMap model, @ModelAttribute("EmailSearch") EmailSearch emailSearch,
			BindingResult result, RedirectAttributes attr) {
		System.out.println("Something" + emailSearch.getEmail());
		model.addAttribute("title", "Forgot Password");
		
		Users user = userService.findByEmail(emailSearch.getEmail());
		
		if (user == null) {
			attr.addFlashAttribute("failureMsg", "Not a Valid User");
			return "redirect:/OTPforgotpassword";

		}

		String tempPassword = "" + generateRandomNumberOfLength(9);
		System.out.println("Generated the OTP" + tempPassword);
		userService.updatePassword(userService,emailSearch.getEmail(), tempPassword);
		System.out.println("updated the password");
		Email email = new Email(emailSearch.getEmail(), "Temporary Password Reset",
				"Your Temporary password is" + tempPassword);
		sendEmailService.sendEmail(email);
		model.addAttribute("email", email);
		model.addAttribute("otp", tempPassword);
		model.addAttribute("password", "");
		System.out.println("Email sent successfully");
		attr.addFlashAttribute("successMsg",
				"A temporary  password is generated and sent to you.Please use it to login");
		return "enterOTP";
	}		
	
/*	@RequestMapping(value = "/enterOTP", method = RequestMethod.POST)
	public String sendOTP(ModelMap model, @ModelAttribute("UpdatePassword") UpdatePassword npassword, BindingResult result,
			RedirectAttributes attr) {
		System.out.println("inside enterOTP" + npassword.getOTP());
		model.put("UpdatePassword", new UpdatePassword());
		System.out.println("Something" + npassword.getEmail());
		model.addAttribute("title", "Forgot Password");
		
		Users user = userService.findByEmail(npassword.getEmail());
		
		if (user == null) 
		{
			attr.addFlashAttribute("failureMsg", "Not a Valid User");
			return "redirect:/updatePasswordNow";
		}
 
		if(!(npassword.getOTP()).equals(user.getPassword()))
		{
			System.out.println("wrong OTP");
		}
		userService.updatePassword(userService,npassword.getEmail(), npassword.getPassword());
		
		return "redirect:/login";
				
	}*/
	
	@RequestMapping(value = "/enterOTP", method = RequestMethod.POST)
	public String sendOTP(ModelMap model, HttpServletRequest request) {
		
		System.out.println("User email >> " + request.getParameter("email"));
		System.out.println("User otp >> " + request.getParameter("otp"));
		System.out.println("User password >> " + request.getParameter("password"));
		
		model.addAttribute("title", "Forgot Password");
		
		Users user = userService.findByEmail(request.getParameter("email"));
		
		if (user == null) 
		{
			return "redirect:/updatePasswordNow";
		}
 
	if(!bCryptHashService.checkBCryptHash(request.getParameter("otp"), user.getPassword()))
		{
		System.out.println("wrong OTP");
		return "redirect:/enterOTP";
       	}
		System.out.println("User otp1 >> " + request.getParameter("otp"));
		System.out.println("User password1 >> " + request.getParameter("password"));
		userService.updatePassword(userService,request.getParameter("email"),request.getParameter("password") );
		
		return "redirect:/login";
				
	}

	@RequestMapping(value = "/enterOTP", method = RequestMethod.GET)
	public String getenterOTPPage() {
		return "enterOTP";
	}

	@RequestMapping(value = "/updatePassword", method = RequestMethod.GET)
	public String getUpdateForgotPassowordPage() {
		return "updatePassword";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String getLogout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/?logout";
	}

	@RequestMapping(value = "/expired", method = RequestMethod.GET)
	public String getExpired(ModelMap model) {
		model.addAttribute("error", "Your session has expired due to access from another device or browser.");
		return "auth/login";
	}

	@RequestMapping(value = "/forgotpass", method = RequestMethod.GET)
	public String getForgotPassword(ModelMap model) {
		model.addAttribute("title", "Forgot Password");
		return "auth/forgotpassword";
	}
	
/*
	@RequestMapping(value = "/updatePasswordNow", method = RequestMethod.POST)
	public String updatepassword(ModelMap model, @ModelAttribute("UpdatePassword") UpdatePassword npassword,
			BindingResult result, RedirectAttributfes attr) {
		System.out.println("Something" + npassword.getEmail());
		model.addAttribute("title", "Forgot Password");
		
		Users user = userService.findByEmail(npassword.getEmail());
		
		if (user == null) 
		{
			attr.addFlashAttribute("failureMsg", "Not a Valid User");
			return "redirect:/updatePasswordNow";
		}
		System.out.println("The original entered otp >>"+ npassword.getOTP());
		String hashedPwd = bCryptHashService.getBCryptHash(npassword.getOTP());
		System.out.println("The entered OTP now >>" + hashedPwd);
		
		if((bCryptHashService.getBCryptHash(npassword.getOTP()).equals(user.getPassword())))
		{
			System.out.println("loveyou");
			userService.updatePassword(userService,npassword.getEmail(), npassword.getPassword());
		return "redirect:/login";
		}

		return "redirect:/updatePasswordNow";
				
	}
*/	
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

}
