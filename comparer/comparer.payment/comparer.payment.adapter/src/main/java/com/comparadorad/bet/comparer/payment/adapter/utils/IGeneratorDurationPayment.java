/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.payment.adapter.utils;

import java.util.Date;

import com.comparadorad.bet.comparer.model.autosender.bean.DurationPayment;
import com.comparadorad.bet.comparer.payment.enums.PaymentDuration;

/**
 * The Interface IGeneratorDurationPayment.
 */
public interface IGeneratorDurationPayment {

	/**
	 * Generate duration payment.
	 * 
	 * @param pPaymentDuration
	 *            the payment duration
	 * @param actualDate
	 *            the actual date
	 * @return the duration payment
	 */
	DurationPayment generateDurationPayment(
			final PaymentDuration pPaymentDuration, final Date startDate);
}
