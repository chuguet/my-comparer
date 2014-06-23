package com.comparadorad.bet.comparer.model.autosender.service.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.Event;
import com.comparadorad.bet.comparer.model.autosender.service.IEventService;

public class EventServiceTest extends AbstractServiceTest<Event, IEventService> {

	@Inject
	private IEventService eventService;

	@Override
	public IEventService getService() {
		return eventService;
	}

	@Override
	public Event getObject() {
		return new Event();
	}

}