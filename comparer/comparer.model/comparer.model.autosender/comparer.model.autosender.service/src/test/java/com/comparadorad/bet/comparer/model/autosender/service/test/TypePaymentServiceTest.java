package com.comparadorad.bet.comparer.model.autosender.service.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.TypePayment;
import com.comparadorad.bet.comparer.model.autosender.service.ITypePaymentService;

public class TypePaymentServiceTest extends
		AbstractServiceTest<TypePayment, ITypePaymentService> {

	@Inject
	private ITypePaymentService typePaymentService;

	@Override
	public ITypePaymentService getService() {
		return typePaymentService;
	}

	@Override
	public TypePayment getObject() {
		return new TypePayment();
	}

}