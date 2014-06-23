package com.comparadorad.bet.comparer.model.autosender.service.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.TypeEvent;
import com.comparadorad.bet.comparer.model.autosender.service.ITypeEventService;

public class TypeEventServiceTest extends
		AbstractServiceTest<TypeEvent, ITypeEventService> {

	@Inject
	private ITypeEventService typeEventService;

	@Override
	public ITypeEventService getService() {
		return typeEventService;
	}

	@Override
	public TypeEvent getObject() {
		return new TypeEvent();
	}

}