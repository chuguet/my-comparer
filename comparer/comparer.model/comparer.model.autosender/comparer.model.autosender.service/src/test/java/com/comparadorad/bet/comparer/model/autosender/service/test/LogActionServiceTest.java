package com.comparadorad.bet.comparer.model.autosender.service.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.LogAction;
import com.comparadorad.bet.comparer.model.autosender.service.ILogActionService;

public class LogActionServiceTest extends
		AbstractServiceTest<LogAction, ILogActionService> {

	@Inject
	private ILogActionService logActionService;

	@Override
	public ILogActionService getService() {
		return logActionService;
	}

	@Override
	public LogAction getObject() {
		return new LogAction();
	}

}