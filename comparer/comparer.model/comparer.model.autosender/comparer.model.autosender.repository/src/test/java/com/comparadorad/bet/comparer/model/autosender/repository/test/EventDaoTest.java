package com.comparadorad.bet.comparer.model.autosender.repository.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.Event;
import com.comparadorad.bet.comparer.model.autosender.repository.IEventDao;

public class EventDaoTest extends AbstractDaoTest<Event, IEventDao> {

	@Inject
	private IEventDao eventDao;

	@Override
	public Event getObject() {
		return new Event();
	}

	@Override
	public IEventDao getDao() {
		return eventDao;
	}

}
