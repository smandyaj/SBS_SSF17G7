package edu.asu.sbs.controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AuthorizationController {
	
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
					return "redirect:/home/";
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
}
