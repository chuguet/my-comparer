/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.payment.adapter.facade;

import com.comparadorad.bet.comparer.payment.beans.PaymentInfo;
import com.comparadorad.bet.comparer.payment.beans.UserInfo;

/**
 * The Interface PaymentFacade.
 */
public interface IPaymentFacade {

	/**
	 * Adds the payment.
	 *
	 * @param userInfo the user info
	 * @param paymentInfo the payment info
	 */
	void addPayment(UserInfo userInfo, PaymentInfo paymentInfo);
	
}
