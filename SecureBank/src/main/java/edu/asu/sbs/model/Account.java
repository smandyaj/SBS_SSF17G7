package edu.asu.sbs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private int accountId;

	@Column(name = "account_type")
	private int accountType;
	
	@Column(name = "account_balance")
	private double accountBalance;

	public int getAccountId(){
		return accountId;
	}

	public void setAccountId(int accountId){
		this.accountId=accountId;
	}

	public int getAccountType(){
		return accountType;
	}

	public void setAccountType(int accountType){
		this.accountType=accountType;
	}

	public double getAccountBalance(){
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance){
		this.accountBalance=accountBalance;
	}
}
