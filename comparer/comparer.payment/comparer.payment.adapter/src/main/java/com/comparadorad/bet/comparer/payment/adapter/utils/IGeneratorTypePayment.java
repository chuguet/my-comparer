/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.payment.adapter.utils;

import com.comparadorad.bet.comparer.model.autosender.bean.TypePayment;
import com.comparadorad.bet.comparer.payment.enums.PaymentDuration;
import com.comparadorad.bet.comparer.payment.enums.PaymentType;

/**
 * The Interface IGeneratorTypePayment.
 */
public interface IGeneratorTypePayment {

	/**
	 * Creates the type payment.
	 * 
	 * @param pPaymentType
	 *            the payment type
	 * @param pPaymentDuration
	 *            the payment duration
	 * @return the type payment
	 */
	TypePayment generateTypePayment(final PaymentType pPaymentType,
			final PaymentDuration pPaymentDuration);
}
