package edu.asu.sbs.model;

public class UpdatePassword {
	private String email;
    private String password;
    private String Otp;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getOTP() {
		return Otp;
	}

	public void setOTP(String Otp) {
		this.Otp = Otp;
	}

	
}