package com.comparadorad.bet.comparer.model.autosender.service.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.EventAttribute;
import com.comparadorad.bet.comparer.model.autosender.service.IEventAttributeService;

public class EventAttributeServiceTest extends
		AbstractServiceTest<EventAttribute, IEventAttributeService> {

	@Inject
	private IEventAttributeService eventAttributeService;

	@Override
	public IEventAttributeService getService() {
		return eventAttributeService;
	}

	@Override
	public EventAttribute getObject() {
		return new EventAttribute();
	}

}