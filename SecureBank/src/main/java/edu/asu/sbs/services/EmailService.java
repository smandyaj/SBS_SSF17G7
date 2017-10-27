/**
 * 
 */
package edu.asu.sbs.services;

public interface EmailService {

	boolean sendEmail(String emailAddress, String subject, String content);

	boolean sendEmailWithAttachment(String emailAddress, String subject, String content);	
	
}