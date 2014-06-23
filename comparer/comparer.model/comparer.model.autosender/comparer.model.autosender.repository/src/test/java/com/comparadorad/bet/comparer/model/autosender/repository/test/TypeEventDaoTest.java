package com.comparadorad.bet.comparer.model.autosender.repository.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.TypeEvent;
import com.comparadorad.bet.comparer.model.autosender.repository.ITypeEventDao;

public class TypeEventDaoTest extends AbstractDaoTest<TypeEvent, ITypeEventDao> {

	@Inject
	private ITypeEventDao typeEventDao;

	@Override
	public TypeEvent getObject() {
		return new TypeEvent();
	}

	@Override
	public ITypeEventDao getDao() {
		return typeEventDao;
	}

}
