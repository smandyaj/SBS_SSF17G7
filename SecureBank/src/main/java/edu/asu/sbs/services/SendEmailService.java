import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;


public class SENDEMAIL{
	final String senderEmailID="cse545g7@gmail.com";
	final String senderPassword="QAZ?@963";
	final String emailSMTPserver="smtp.gmail.com";
	final String emailServerPort="465";
	String receiverEmailID=null;
	static String emailSubject="testing mail";
	static String emailBody="testing g7 mail";
	
	public SENDEMAIL(String receiverEmailID, String emailSubject, String emailBody){
		
		this.receiverEmailID=receiverEmailID;
		this.emailBody=emailBody;
		this.emailSubject=emailSubject;
		Properties properties=new Properties();
		properties.put("mail.smtp.user", senderEmailID);
		properties.put("mail.smtp.host",emailSMTPserver);
		properties.put("mail.smtp.port",emailServerPort);
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.socketFactory.port", emailServerPort);
		properties.put("mail.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		SecurityManager security=System.getSecurityManager();
		
		try{
			Authenticator auth=new SMTPAuthenticator();
			Session Session =Session.getInstance(properties,auth);
			MimeMessage msg=new MimeMessage(session);
			msg.setText(emailBody);
			msg.setSubject(emailSubject);
			msg.setFrom(new InternetAddress(senderEmailID));
			msg.addRecipient(Message.RecipientType.TO , new InternetAddress(receiverEmailID);
			Transport.send(msg);
			System.out.println("Message Send");
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		public class SMTPAuthenticator extends javax.mail.Authenticator{
			publicPasswordAuthentication get PasswordAuthentication(){
				return new PasswordAuthentication(senderEmailID,senderPassword);
			}
		}
		
	}
	
	
	
	
}