/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.payment.beans;

import java.util.Collection;

import com.comparadorad.bet.comparer.model.autosender.bean.UserPayment;

/**
 * The Class PaymentsUpdated.
 */
public class PaymentsUpdated {

	/** The payments. */
	private Collection<UserPayment> payments;

	/** The first payment. */
	private Boolean firstPayment;

	/**
	 * Gets the payments.
	 * 
	 * @return the payments
	 */
	public Collection<UserPayment> getPayments() {
		return payments;
	}

	/**
	 * Sets the payments.
	 * 
	 * @param payments
	 *            the new payments
	 */
	public void setPayments(Collection<UserPayment> payments) {
		this.payments = payments;
	}

	/**
	 * Gets the first payment.
	 * 
	 * @return the first payment
	 */
	public Boolean getFirstPayment() {
		return firstPayment;
	}

	/**
	 * Sets the first payment.
	 * 
	 * @param firstPayment
	 *            the new first payment
	 */
	public void setFirstPayment(Boolean firstPayment) {
		this.firstPayment = firstPayment;
	}
}
