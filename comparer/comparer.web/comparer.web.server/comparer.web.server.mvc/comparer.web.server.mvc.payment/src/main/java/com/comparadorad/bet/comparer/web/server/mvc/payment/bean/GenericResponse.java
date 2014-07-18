package com.comparadorad.bet.comparer.web.server.mvc.payment.bean;

import java.io.Serializable;

public class GenericResponse implements Serializable{

	
	public enum Status {
		OK,
		KO;
	}
	
	private static final long serialVersionUID = -6112965334532325674L;
	
	private Status status;
	
	private String value;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public GenericResponse() {
		super();
	}
	
	public GenericResponse(Status status, String value) {
		super();
		this.status = status;
		this.value = value;
	}
	
}
