package edu.asu.sbs.model;

import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Sessions")
public class Sessions{
	
	@Id
	@Column(name = "session_id")
	private String sessionId;
	
	@Column(name = "expiry_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryTime;
	
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name = "login_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date loginTime;

	public String getSessionId(){
		return sessionId;
	}

	public void setSessionId(String sessionId){
		this.sessionId=sessionId;
	}

	public Date getExpiryTime(){
		return expiryTime;
	}

	public void setExpiry_time(Date expiryTtime){
		this.expiryTime=expiryTtime;
	}

	public int getCustomerId(){
		return customerId;
	}

	public void setCustomer_id(int customerId){
		this.customerId=customerId;
	}

	public Date getLoginTime(){
		return loginTime;
	}

	public void setLogin_time(Date loginTime){
		this.loginTime=loginTime;
	}
}
