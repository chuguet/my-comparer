package com.comparadorad.bet.comparer.web.server.mvc.payment.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PaymentData implements Serializable{

	private Integer option;

	public Integer getOption() {
		return option;
	}

	public void setOption(Integer option) {
		this.option = option;
	}

	public PaymentData() {
		super();
	}
	
	public PaymentData(Integer option) {
		super();
		this.option = option;
	}
	
	
}
