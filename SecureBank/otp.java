package edu.asu.sbs.services;

public class otp{
	public static String generateOTP() {
		Integer randomPIN = (int)(Math.random()*9000)+1000;

        //Store integer in a string
        String pin=randomPIN.toString();
        return pin;
	}
}