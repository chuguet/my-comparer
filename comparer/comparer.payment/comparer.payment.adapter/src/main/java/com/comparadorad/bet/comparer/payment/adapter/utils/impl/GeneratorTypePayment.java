package com.comparadorad.bet.comparer.payment.adapter.utils.impl;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.autosender.bean.TypePayment;
import com.comparadorad.bet.comparer.payment.adapter.utils.IGeneratorTypePayment;
import com.comparadorad.bet.comparer.payment.enums.PaymentDuration;
import com.comparadorad.bet.comparer.payment.enums.PaymentType;

@Component
public class GeneratorTypePayment implements IGeneratorTypePayment {

	/** The Constant ONE_MONTH_MILIS. */
	private final static Integer ONE_MONTH_DAYS = 30;
	
	private final static Integer THREE_MONTH_DAYS = 90;
	/** The Constant ONE_MONTH_MILIS. */
	private final static Integer SIX_MONTHS_DAYS = 180;
	/** The Constant ONE_MONTH_MILIS. */
	private final static Integer ONE_YEAR_DAYS = 365;

	@Override
	public TypePayment generateTypePayment(PaymentType pPaymentType,
			PaymentDuration pPaymentDuration) {
		TypePayment typePayment = new TypePayment();

		Integer duration = calculateDaysDurationPayment(pPaymentDuration);
		typePayment.setDuration(duration);

		if (pPaymentType.name().equals(PaymentType.NIVEL_1.name())) {
			typePayment.setTypePaymentName(TypePayment.TypePaymentName.NIVEL_1);
		} else if (pPaymentType.name().equals(PaymentType.NIVEL_2.name())) {
			typePayment.setTypePaymentName(TypePayment.TypePaymentName.NIVEL_2);
		} else if (pPaymentType.name().equals(PaymentType.NIVEL_3.name())) {
			typePayment.setTypePaymentName(TypePayment.TypePaymentName.NIVEL_3);
		}else if(pPaymentType.name().equals(PaymentType.PROMOTION.name())){
			typePayment.setTypePaymentName(TypePayment.TypePaymentName.PROMOTION);
		}

		return typePayment;
	}

	/**
	 * Calculate duration.
	 * 
	 * @param pPaymentDuration
	 *            the payment duration
	 * @return the integer
	 */
	private Integer calculateDaysDurationPayment(
			final PaymentDuration pPaymentDuration) {
		Integer result = null;
		if (pPaymentDuration.name().equals(PaymentDuration.UN_MES.name())) {
			result = ONE_MONTH_DAYS;
		} else if (pPaymentDuration.name().equals(
				PaymentDuration.SEIS_MESES.name())) {
			result = SIX_MONTHS_DAYS;
		} else if (pPaymentDuration.name().equals(
				PaymentDuration.UN_ANYO.name())) {
			result = ONE_YEAR_DAYS;
		}else if (pPaymentDuration.name().equals(
				PaymentDuration.TRES_MESES.name())) {
			result = THREE_MONTH_DAYS;
		}
		return result;
	}
}
