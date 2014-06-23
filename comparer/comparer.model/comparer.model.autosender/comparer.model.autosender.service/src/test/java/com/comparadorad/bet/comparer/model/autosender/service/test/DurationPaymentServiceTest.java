package com.comparadorad.bet.comparer.model.autosender.service.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.DurationPayment;
import com.comparadorad.bet.comparer.model.autosender.service.IDurationPaymentService;

public class DurationPaymentServiceTest extends
		AbstractServiceTest<DurationPayment, IDurationPaymentService> {

	@Inject
	private IDurationPaymentService durationPaymentService;

	@Override
	public IDurationPaymentService getService() {
		return durationPaymentService;
	}

	@Override
	public DurationPayment getObject() {
		return new DurationPayment();
	}

}