/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.payment.adapter.utils;

import java.util.Collection;
import java.util.Date;

import com.comparadorad.bet.comparer.model.autosender.bean.UserPayment;
import com.comparadorad.bet.comparer.payment.beans.PaymentsUpdated;

/**
 * The Interface IUpdaterPayments.
 */
public interface IUpdaterPayments {

	/**
	 * Se actualiza el pago activo para pararlo y poder crear uno nuevo.
	 * 
	 * @param payments
	 *            toods los pagos del usuario
	 * @param actualDate
	 *            fecha actual
	 * @return true, si es la primera vez que se realiza un pago
	 */
	PaymentsUpdated updateActivePayment(final Collection<UserPayment> payments,
			final Date finishDate);
}
