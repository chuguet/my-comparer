package com.comparadorad.bet.comparer.model.autosender.service.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.UserPayment;
import com.comparadorad.bet.comparer.model.autosender.service.IUserPaymentService;

public class UserPaymentServiceTest extends
		AbstractServiceTest<UserPayment, IUserPaymentService> {

	@Inject
	private IUserPaymentService userPaymentService;

	@Override
	public IUserPaymentService getService() {
		return userPaymentService;
	}

	@Override
	public UserPayment getObject() {
		return new UserPayment();
	}

}