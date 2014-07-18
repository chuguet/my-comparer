package com.comparadorad.bet.comparer.web.server.mvc.payment.bean;

import java.io.Serializable;


public class TransactionData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8089182535152459638L;

	private String token;

	private String payerID;


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPayerID() {
		return payerID;
	}

	public void setPayerID(String payerID) {
		this.payerID = payerID;
	}

	public TransactionData() {
		super();
	}
	
	public TransactionData(String token, String payerID) {
		super();
		this.token = token;
		this.payerID = payerID;
	}




}
