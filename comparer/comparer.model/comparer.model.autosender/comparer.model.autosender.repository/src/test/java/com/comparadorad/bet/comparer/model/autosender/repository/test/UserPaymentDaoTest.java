package com.comparadorad.bet.comparer.model.autosender.repository.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.UserPayment;
import com.comparadorad.bet.comparer.model.autosender.repository.IUserPaymentDao;

public class UserPaymentDaoTest extends
		AbstractDaoTest<UserPayment, IUserPaymentDao> {

	@Inject
	private IUserPaymentDao userPaymentDao;

	@Override
	public UserPayment getObject() {
		return new UserPayment();
	}

	@Override
	public IUserPaymentDao getDao() {
		return userPaymentDao;
	}

}
