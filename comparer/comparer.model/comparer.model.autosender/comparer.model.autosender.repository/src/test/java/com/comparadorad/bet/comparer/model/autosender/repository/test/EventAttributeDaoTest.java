package com.comparadorad.bet.comparer.model.autosender.repository.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.EventAttribute;
import com.comparadorad.bet.comparer.model.autosender.repository.IEventAttributeDao;

public class EventAttributeDaoTest extends
		AbstractDaoTest<EventAttribute, IEventAttributeDao> {

	@Inject
	private IEventAttributeDao eventAttributeDao;

	@Override
	public EventAttribute getObject() {
		return new EventAttribute();
	}

	@Override
	public IEventAttributeDao getDao() {
		return eventAttributeDao;
	}
}
