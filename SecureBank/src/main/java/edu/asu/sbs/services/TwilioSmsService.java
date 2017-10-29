package edu.asu.sbs.services;

import com.twilio.Twilio; 
import com.twilio.rest.api.v2010.account.Message; 
import com.twilio.rest.api.v2010.account.MessageCreator; 
import com.twilio.type.PhoneNumber; 

public class TwilioSmsService {
	  // Find your Account Sid and Token at twilio.com/user/account
	private final static String ACCOUNT_SID = "AC1d38d61b5cc513e9deec4654b8f4ad14"; 
    private final static String AUTH_TOKEN = "2647a6ac1bf8ad9df35d44b192d4f18a"; 
 
    public static void sendSms(String code) { 
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
         
        MessageCreator messageCreator = Message.creator(new PhoneNumber("+14803002224"),
        								new PhoneNumber("+14063186758"),code); 
        Message message = messageCreator.create(); 
        System.out.println(message.getSid()); 
    } 
}
