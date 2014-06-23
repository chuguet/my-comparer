package com.comparadorad.bet.comparer.model.autosender.repository.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.DurationPayment;
import com.comparadorad.bet.comparer.model.autosender.repository.IDurationPaymentDao;

public class DurationPaymentDaoTest extends
		AbstractDaoTest<DurationPayment, IDurationPaymentDao> {

	@Inject
	private IDurationPaymentDao durationPaymentDao;

	@Override
	public DurationPayment getObject() {
		return new DurationPayment();
	}

	@Override
	public IDurationPaymentDao getDao() {
		return durationPaymentDao;
	}

}
