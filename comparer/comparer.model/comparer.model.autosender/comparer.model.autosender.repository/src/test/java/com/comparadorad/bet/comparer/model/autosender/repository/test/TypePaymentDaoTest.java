package com.comparadorad.bet.comparer.model.autosender.repository.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.TypePayment;
import com.comparadorad.bet.comparer.model.autosender.repository.ITypePaymentDao;

public class TypePaymentDaoTest extends
		AbstractDaoTest<TypePayment, ITypePaymentDao> {

	@Inject
	private ITypePaymentDao typePaymentDao;

	@Override
	public TypePayment getObject() {
		return new TypePayment();
	}

	@Override
	public ITypePaymentDao getDao() {
		return typePaymentDao;
	}

}
