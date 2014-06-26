package com.comparadorad.bet.comparer.payment.adapter.utils.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.autosender.bean.DurationPayment;
import com.comparadorad.bet.comparer.model.autosender.bean.DurationPayment.TypeDuration;
import com.comparadorad.bet.comparer.model.autosender.bean.UserPayment;
import com.comparadorad.bet.comparer.model.autosender.bean.UserPayment.StatePayment;
import com.comparadorad.bet.comparer.payment.adapter.utils.IUpdaterPayments;
import com.comparadorad.bet.comparer.payment.beans.PaymentsUpdated;

@Component
public class UpdaterPayments implements IUpdaterPayments {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(UpdaterPayments.class);

	@Override
	public PaymentsUpdated updateActivePayment(
			Collection<UserPayment> payments, Date finishDate) {
		PaymentsUpdated result = new PaymentsUpdated();

		if (payments != null && !payments.isEmpty()) {
			// Se añaden todos los pagos no activos
			Collection<UserPayment> paymentsUpdated = new ArrayList<UserPayment>();
			paymentsUpdated.addAll(getNonActiveUserPayment(payments));

			// Se recupera el pago activo para desactivarlo
			UserPayment userPayment = getActiveUserPayment(payments);

			// Se recupera la duración del pago que este activa y se finaliza
			// con la fecha actual
			DurationPayment activeDurationPayment = getActiveDurationPayment(userPayment
					.getDurationPayment());
			finalizeDurationPayment(activeDurationPayment, finishDate);
			LOG.info("Se finaliza la duración del pago");

			// Se calculan los dias restantes que le quedan al pago
			Integer daysRemaining = calculateDaysRemainingFromActiveDurationPayment(
					activeDurationPayment.getExpectedDate().getTime(),
					finishDate.getTime());
			LOG.info(new StringBuffer("Se encuentra un pago con ")
					.append(daysRemaining)
					.append(" días restantes disponibles.").toString());

			// Se desactiva el pago
			userPayment.setStatePayment(StatePayment.DESACTIVE);

			// Se crea un pago un nuevo parado, para ser reanudado cuando se
			// acabe el que este activo
			DurationPayment durationPayment = createExtendedPaymentDuration(daysRemaining);
			userPayment.getDurationPayment().add(durationPayment);
			paymentsUpdated.add(userPayment);
			LOG.info("Se añade un pago nuevo en un estado parado con los días restantes disponibles.");

			result.setFirstPayment(Boolean.FALSE);
			result.setPayments(paymentsUpdated);
		} else {
			result.setPayments(new ArrayList<UserPayment>());
			result.setFirstPayment(Boolean.TRUE);
		}

		return result;
	}

	private Collection<UserPayment> getNonActiveUserPayment(
			Collection<UserPayment> payments) {
		Collection<UserPayment> result = new ArrayList<UserPayment>();
		for (UserPayment payment : payments) {
			if (!payment.getStatePayment().equals(StatePayment.ACTIVE)) {
				result.add(payment);
			}
		}
		return result;
	}

	/**
	 * Gets the active user payment.
	 * 
	 * @param userPayments
	 *            the user payments
	 * @return the active user payment
	 */
	private UserPayment getActiveUserPayment(
			final Collection<UserPayment> userPayments) {
		UserPayment result = null;
		for (UserPayment userPayment : userPayments) {
			if (userPayment.getStatePayment().name()
					.equals(StatePayment.ACTIVE.name())) {
				result = userPayment;
				break;
			}
		}
		return result;
	}

	/**
	 * Gets the days remaining from active duration payment.
	 * 
	 * @param durationPayment
	 *            the duration payment
	 * @param fechaActual
	 *            the fecha actual
	 * @return the days remaining from active duration payment
	 */
	private Integer calculateDaysRemainingFromActiveDurationPayment(
			final long fechaEsperadaFinActiveDurationPayment,
			final long fechaActual) {
		return (int) milisToDays(fechaEsperadaFinActiveDurationPayment
				- fechaActual);
	}

	/**
	 * Milis to days.
	 * 
	 * @param time
	 *            the time
	 * @return the long
	 */
	private long milisToDays(final long time) {
		return time / 1000 / 60 / 60 / 24;
	}

	/**
	 * Finalize duration payment.
	 * 
	 * @param durationPayments
	 *            the duration payments
	 * @param dateFinish
	 *            the date finish
	 */
	private void finalizeDurationPayment(final DurationPayment durationPayment,
			final Date dateFinish) {
		durationPayment.setTypeDuration(TypeDuration.FINISHED);
		durationPayment.setFinishDate(dateFinish);
	}

	/**
	 * Gets the active duration payment.
	 * 
	 * @param durationPayments
	 *            the duration payments
	 * @return the active duration payment
	 */
	private DurationPayment getActiveDurationPayment(
			final Collection<DurationPayment> durationPayments) {
		DurationPayment result = null;
		for (DurationPayment durationPayment : durationPayments) {
			if (durationPayment.getTypeDuration().name()
					.equals(TypeDuration.ACTIVE.name())) {
				result = durationPayment;
				break;
			}
		}
		return result;
	}

	/**
	 * Creates the extended payment duration.
	 * 
	 * @param daysRemaining
	 *            the days remaining
	 * @return the duration payment
	 */
	private DurationPayment createExtendedPaymentDuration(
			final Integer daysRemaining) {
		DurationPayment durationPayment = new DurationPayment();
		durationPayment.setDaysRemaining(daysRemaining);
		durationPayment.setTypeDuration(TypeDuration.STOPPED);
		return durationPayment;
	}

}
