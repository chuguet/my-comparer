/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.payment.adapter.utils;

import java.util.Date;

import com.comparadorad.bet.comparer.model.autosender.bean.User;
import com.comparadorad.bet.comparer.model.autosender.bean.UserAction;
import com.comparadorad.bet.comparer.payment.enums.PaymentDuration;
import com.comparadorad.bet.comparer.payment.enums.PaymentType;

/**
 * The Interface IGeneratorAction.
 */
public interface IGeneratorAction {

	/**
	 * Creates the action payment.
	 * 
	 * @param user
	 *            el usuario que realiza la acción
	 * @param actualDate
	 *            la fecha en la que la acción es realizada
	 * @param pPaymentType
	 *            el tipo de pago de la acción
	 * @param pPaymentDuration
	 *            la duración del pago de la acción
	 * @param primerPago
	 *            Es la primera vez que se paga o no
	 * @return the collection
	 */
	UserAction createActionPayment(final User user, final Date creationDate,
			final PaymentType pPaymentType,
			final PaymentDuration pPaymentDuration, final Boolean primerPago);
}
