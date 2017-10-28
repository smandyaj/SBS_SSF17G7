package edu.asu.sbs.services;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import edu.asu.sbs.model.Email;

@Service
public class EmailServiceImpl implements EmailService{
	
	private static String senderEmailID = "cse545g7@gmail.com";
	private static String senderPassword = "QAZ?@963";
	private static String emailSMTPserver = "smtp.gmail.com";
	private static String emailServerPort = "465";
	
	@Override
	public void sendEmail(Email email) {
		
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
			msg.setText(email.getBody());
			msg.setSubject(email.getSubject());
			msg.setFrom(new InternetAddress(senderEmailID));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getEmailId()));
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
			return new PasswordAuthentication(senderEmailID, senderPassword);
		}
	}

}
