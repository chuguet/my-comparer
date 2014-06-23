/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.requestbean;

import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * The Class PaymentListResquestBeanGetResponse.
 */
public class PaymentListResquestBeanGetResponse extends AbstractRequestBeanGetResponse implements IRequestBeanGetResponse{
	
	/** The email. */
	@Email
	@NotEmpty
	private String email;

	/** The payment list. */
	private List<String> paymentList;
	
	/**
	 * Gets the payment list.
	 *
	 * @return the payment list
	 */
	public List<String> getPaymentList() {
		return paymentList;
	}

	/**
	 * Sets the payment list.
	 *
	 * @param paymentList the new payment list
	 */
	public void setPaymentList(List<String> paymentList) {
		this.paymentList = paymentList;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
