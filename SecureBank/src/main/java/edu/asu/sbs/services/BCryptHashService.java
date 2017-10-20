package edu.asu.sbs.services;

public interface BCryptHashService {

	String getBCryptHash(String plaintext);
	
	boolean checkBCryptHash(String plaintext, String hash);
}
