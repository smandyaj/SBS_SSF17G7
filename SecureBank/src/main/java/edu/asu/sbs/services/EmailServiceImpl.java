package edu.asu.sbs.services;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailServiceImpl {
	private String senderEmailID = "cse545g7@gmail.com";
	private String senderPassword = "QAZ?@963";
	private String emailSMTPserver = "smtp.gmail.com";
	private String emailServerPort = "465";
/*	
	public static void main(String args[]) {
		 new SendEmail("santosh.mandyajayaram@gmail.com", "Test Email", "Test Email");
	}*/

	public EmailServiceImpl(String receiverEmailID, String emailSubject, String emailBody) {

		Properties properties = new Properties();
		properties.put("mail.smtp.user", senderEmailID);
		properties.put("mail.smtp.host", emailSMTPserver);
		properties.put("mail.smtp.port", emailServerPort);
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.socketFactory.port", emailServerPort);
		properties.put("mail.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.socketFactory.fallback", "false");
		SecurityManager security = System.getSecurityManager();

		try {
			SMTPAuthenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(properties, auth);
			MimeMessage msg = new MimeMessage(session);
			msg.setText(emailBody);
			msg.setSubject(emailSubject);
			msg.setFrom(new InternetAddress(senderEmailID));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmailID));
			Transport transport = session.getTransport("smtps");
            transport.connect(emailSMTPserver, Integer.valueOf(emailServerPort), senderEmailID, senderPassword);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
			System.out.println("Message Send");

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	private class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			String username = emailSMTPserver;
			String password = senderPassword;
			return new PasswordAuthentication(username, password);
		}
	}

}