package edu.asu.sbs.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private int transactionId;
	
	@Column(name = "transaction_type")
	private int transactionType;
	
	@Column(name = "transaction_create_time")
	//@Temporal(TemporalType.TIMESTAMP)
	private Date transactionCreateTime;
	
	@Column(name = "payer_id")
	private int payerId;
	
	@Column(name = "receiver_id")
	private int receiverId;
	
	@Column(name = "transaction_amount")
	private double transactionAmount;
	
	@Column(name="status")
	private int status;
	
	@Column(name="auth")
	private int auth;
	
	@Column(name="status_quo")
	private String status_quo;
	
	@Column(name="senderAccNumber")
	private int senderAccNumber;
	
	@Column(name="receiverAccNumber")
	private int receiverAccNumber;
	
	@Column(name = "transaction_type_quo")
	private String transactionTypeQuo;
	
	public String getTransactionTypeQuo() {
		return transactionTypeQuo;
	}

	public void setTransactionTypeQuo(String transactionTypeQuo) {
		this.transactionTypeQuo = transactionTypeQuo;
	}

	public int getSenderAccNumber() {
		return senderAccNumber;
	}

	public void setSenderAccNumber(int senderAccNumber) {
		this.senderAccNumber = senderAccNumber;
	}

	public int getReceiverAccNumber() {
		return receiverAccNumber;
	}

	public void setReceiverAccNumber(int receiverAccNumber) {
		this.receiverAccNumber = receiverAccNumber;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	public String getStatus_quo() {
		return status_quo;
	}

	public void setStatus_quo(String status_quo) {
		this.status_quo = status_quo;
	}

	public int getTransactionId(){
		return transactionId;
	}

	public void setTransactionId(int transactionId){
		this.transactionId=transactionId;
	}

	public int getTransactionType(){
		return transactionType;
	}

	public void setTransactionType(int transactionType){
		this.transactionType=transactionType;
	}

	public Date getTransactionCreateTime(){
		return transactionCreateTime;
	}

	public void setTransactionCreateTime(Date transactionCreateTime){
		this.transactionCreateTime=transactionCreateTime;
	}

	public int getPayerId(){
		return payerId;
	}

	public void setPayerId(int payerId){
		this.payerId=payerId;
	}

	public int getReceiverId(){
		return receiverId;
	}

	public void setReceiverId(int receiverId){
		this.receiverId=receiverId;
	}

	public double getTransactionAmount(){
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount){
		this.transactionAmount=transactionAmount;
	}

	
	public Transaction(int transactionType, Date transactionCreateTime, int payerId, int receiverId,
			double transactionAmount, int status, int auth, String status_quo, int senderAccNumber,
			int receiverAccNumber) {
		super();
		this.transactionType = transactionType;
		this.transactionCreateTime = transactionCreateTime;
		this.payerId = payerId;
		this.receiverId = receiverId;
		this.transactionAmount = transactionAmount;
		this.status = status;
		this.auth = auth;
		this.status_quo = status_quo;
		this.senderAccNumber = senderAccNumber;
		this.receiverAccNumber = receiverAccNumber;
	}

	public Transaction(int transactionType, Date transactionCreateTime, int payerId, int receiverId,
			double transactionAmount, int status, int auth, String status_quo, int senderAccNumber,
			int receiverAccNumber, String transactionTypeQuo) {
		super();
		this.transactionType = transactionType;
		this.transactionCreateTime = transactionCreateTime;
		this.payerId = payerId;
		this.receiverId = receiverId;
		this.transactionAmount = transactionAmount;
		this.status = status;
		this.auth = auth;
		this.status_quo = status_quo;
		this.senderAccNumber = senderAccNumber;
		this.receiverAccNumber = receiverAccNumber;
		this.transactionTypeQuo = transactionTypeQuo;
	}

	public Transaction() {
		
	}
}
