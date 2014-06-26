/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.payment.adapter.facade.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.autosender.bean.DurationPayment;
import com.comparadorad.bet.comparer.model.autosender.bean.TypePayment;
import com.comparadorad.bet.comparer.model.autosender.bean.User;
import com.comparadorad.bet.comparer.model.autosender.bean.UserAction;
import com.comparadorad.bet.comparer.model.autosender.bean.UserPayment;
import com.comparadorad.bet.comparer.model.autosender.bean.UserPayment.StatePayment;
import com.comparadorad.bet.comparer.model.autosender.service.IUserService;
import com.comparadorad.bet.comparer.payment.adapter.facade.IPaymentFacade;
import com.comparadorad.bet.comparer.payment.adapter.utils.IGeneratorAction;
import com.comparadorad.bet.comparer.payment.adapter.utils.IGeneratorDurationPayment;
import com.comparadorad.bet.comparer.payment.adapter.utils.IGeneratorTypePayment;
import com.comparadorad.bet.comparer.payment.adapter.utils.IUpdaterPayments;
import com.comparadorad.bet.comparer.payment.beans.PaymentInfo;
import com.comparadorad.bet.comparer.payment.beans.PaymentsUpdated;
import com.comparadorad.bet.comparer.payment.beans.UserInfo;
import com.comparadorad.bet.comparer.payment.enums.PaymentDuration;
import com.comparadorad.bet.comparer.payment.enums.PaymentType;

/**
 * The Class PaymentFacade.
 */
@Component
public class PaymentFacade implements IPaymentFacade {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(PaymentFacade.class);

	/** The user service. */
	@Inject
	private IUserService userService;

	@Inject
	private IGeneratorAction generatorAction;

	@Inject
	private IUpdaterPayments updaterPayments;

	@Inject
	private IGeneratorTypePayment generatorTypePayment;

	@Inject
	private IGeneratorDurationPayment generatorDurationPayment;

	/**
	 * Adds the payment.
	 * 
	 * @param user
	 *            the user
	 * @param pPaymentType
	 *            the payment type
	 * @param pPaymentDuration
	 *            the payment duration
	 */
	private void addPayment(final User user, final PaymentType pPaymentType,
			final PaymentDuration pPaymentDuration) {
		DurationPayment durationPayment;
		TypePayment typePayment;
		UserPayment userPayment;
		Date actualDate = Calendar.getInstance().getTime();

		PaymentsUpdated paymentsUpdated = updaterPayments.updateActivePayment(
				user.getUserPayments(), actualDate);
		LOG.info("Se actualiza el pago activo anterior para desactivarlo si existiese.");

		durationPayment = generatorDurationPayment.generateDurationPayment(
				pPaymentDuration, actualDate);
		LOG.info("Se crea una duración de pago.");

		typePayment = generatorTypePayment.generateTypePayment(pPaymentType,
				pPaymentDuration);
		LOG.info("Se crea un tipo de pago.");

		userPayment = createUserPayment(durationPayment, typePayment,
				actualDate, StatePayment.ACTIVE);
		LOG.info("Se crea un usuario de pago.");

		paymentsUpdated.getPayments().add(userPayment);
		user.setUserPayments(paymentsUpdated.getPayments());

		UserAction action = generatorAction.createActionPayment(user,
				actualDate, pPaymentType, pPaymentDuration,
				paymentsUpdated.getFirstPayment());
		LOG.info(new StringBuffer("Se genera la acción ").append(action
				.getActionType().getName()));
		if (user.getActions() == null) {
			user.setActions(new ArrayList<UserAction>());
		}
//		user.getActions().add(action);

		userService.update(user);
		LOG.info("Se persiste todo en base de datos.");
	}

	/**
	 * Adds a specified user a new UserPayment in BBDD.
	 * 
	 * @param userInfo
	 *            the user info
	 * @param paymentInfo
	 *            the payment info {@inheritDoc}
	 */
	@Override
	public void addPayment(final UserInfo userInfo,
			final PaymentInfo paymentInfo) {
		User user = userService.findByLiferayId(userInfo.getLiferayUserId());
		addPayment(user, paymentInfo.getPaymentType(),
				paymentInfo.getPaymentDuration());

	}

	/**
	 * Creates the user payment.
	 * 
	 * @param durationPayment
	 *            the duration payment
	 * @param typePayment
	 *            the type payment
	 * @param actualDate
	 *            the actual date
	 * @param active
	 *            the active
	 * @return the user payment
	 */
	private UserPayment createUserPayment(
			final DurationPayment durationPayment,
			final TypePayment typePayment, final Date creationDate,
			final StatePayment active) {
		UserPayment userPayment = new UserPayment();

		Collection<DurationPayment> durationPayments = new ArrayList<DurationPayment>();
		durationPayments.add(durationPayment);

		userPayment.setDurationPayment(durationPayments);
		userPayment.setTypePayment(typePayment);
		userPayment.setPaymentDate(creationDate);
		userPayment.setStatePayment(active);

		return userPayment;
	}

}
