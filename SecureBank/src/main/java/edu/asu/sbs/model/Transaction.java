package edu.asu.sbs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "transaction")
public class Transaction {
	
	@Id
	@Column(name = "transaction_id")
	private int transactionId;
	
	@Column(name = "transaction_type")
	private int transactionType;
	
	@Column(name = "transaction_create_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionCreateTime;
	
	@Column(name = "transaction_status")
	private String transactionStatus;
	
	@Column(name = "payer_id")
	private int payerId;
	
	@Column(name = "receiver_id")
	private int receiverId;
	
	@Column(name = "transaction_amount")
	private double transactionAmount;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransactionCreateTime() {
		return transactionCreateTime;
	}

	public void setTransactionCreateTime(Date transactionCreateTime) {
		this.transactionCreateTime = transactionCreateTime;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public int getPayerId() {
		return payerId;
	}

	public void setPayerId(int payerId) {
		this.payerId = payerId;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	
	
	

}
