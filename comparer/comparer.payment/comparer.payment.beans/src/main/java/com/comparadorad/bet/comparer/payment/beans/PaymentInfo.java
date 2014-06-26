/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.payment.beans;

import com.comparadorad.bet.comparer.payment.enums.PaymentDuration;
import com.comparadorad.bet.comparer.payment.enums.PaymentType;

/**
 * The Class PaymentInfo.
 */
public class PaymentInfo {

	/** The payment type. */
	private PaymentType paymentType;

	/** The payment duration. */
	private PaymentDuration paymentDuration;

	/**
	 * Gets the payment duration.
	 * 
	 * @return the payment duration
	 */
	public PaymentDuration getPaymentDuration() {
		return paymentDuration;
	}

	/**
	 * Sets the payment duration.
	 * 
	 * @param paymentDuration
	 *            the new payment duration
	 */
	public void setPaymentDuration(PaymentDuration paymentDuration) {
		this.paymentDuration = paymentDuration;
	}

	/**
	 * Gets the payment type.
	 * 
	 * @return the payment type
	 */
	public PaymentType getPaymentType() {
		return paymentType;
	}

	/**
	 * Sets the payment type.
	 * 
	 * @param paymentType
	 *            the new payment type
	 */
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

}
