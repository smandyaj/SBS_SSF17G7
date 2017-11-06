package edu.asu.sbs.utilities;

import java.util.Random;

public class SecretKey {

	private final String char_list = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXUZ1234567890";
	private final int Random_length = 15;
	private final int min = 0;
	private final int max = 61;

	public String generateRandomString() {

		StringBuffer randStr=new StringBuffer();
		for (int i = 0; i < Random_length; i++) {
			Random random = new Random();
			int number = random.nextInt(max - min + 1) + min;
					char ch=char_list.charAt(number);
			randStr.append(ch);
		}
		return randStr.toString(); 	 
	}
}
