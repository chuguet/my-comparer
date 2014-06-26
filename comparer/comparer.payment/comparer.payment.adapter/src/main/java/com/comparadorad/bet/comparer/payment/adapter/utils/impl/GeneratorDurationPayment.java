package com.comparadorad.bet.comparer.payment.adapter.utils.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.autosender.bean.DurationPayment;
import com.comparadorad.bet.comparer.model.autosender.bean.DurationPayment.TypeDuration;
import com.comparadorad.bet.comparer.payment.adapter.utils.IGeneratorDurationPayment;
import com.comparadorad.bet.comparer.payment.enums.PaymentDuration;

@Component
public class GeneratorDurationPayment implements IGeneratorDurationPayment {

	/** The Constant ONE_MONTH_MILIS. */
	private final static int ONE_MONTH = 30;

	private final static int THREE_MONTH = 90;

	/** The Constant SIX_MONTHS_MILIS. */
	private final static int SIX_MONTHS = 180;

	/** The Constant ONE_YEAR_MILIS. */
	private final static int ONE_YEAR = 365;


	@Override
	public DurationPayment generateDurationPayment(
			PaymentDuration pPaymentDuration, Date startDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		Date expected;
		
		DurationPayment durationPayment = new DurationPayment();

		durationPayment.setStartDate(startDate);
		durationPayment.setTypeDuration(TypeDuration.ACTIVE);

		if (pPaymentDuration.name().equals(PaymentDuration.UN_ANYO.name())) {
			calendar.add(Calendar.DATE, ONE_YEAR);
			expected = calendar.getTime();
			durationPayment.setExpectedDate(expected);
		} else if (pPaymentDuration.name().equals(
				PaymentDuration.SEIS_MESES.name())) {
			calendar.add(Calendar.DATE, SIX_MONTHS);
			expected = calendar.getTime();
			durationPayment.setExpectedDate(expected);
		} else if (pPaymentDuration.name()
				.equals(PaymentDuration.UN_MES.name())) {
			calendar.add(Calendar.DATE, ONE_MONTH);
			expected = calendar.getTime();
			durationPayment.setExpectedDate(expected);
		}else if (pPaymentDuration.name()
				.equals(PaymentDuration.TRES_MESES.name())) {
			calendar.add(Calendar.DATE, THREE_MONTH);
			expected = calendar.getTime();
			durationPayment.setExpectedDate(expected);
		}
		return durationPayment;
	}

}
