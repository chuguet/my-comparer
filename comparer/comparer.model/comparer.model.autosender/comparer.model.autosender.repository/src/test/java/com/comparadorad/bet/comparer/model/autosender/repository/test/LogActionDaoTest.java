package com.comparadorad.bet.comparer.model.autosender.repository.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.LogAction;
import com.comparadorad.bet.comparer.model.autosender.repository.ILogActionDao;

public class LogActionDaoTest extends AbstractDaoTest<LogAction, ILogActionDao> {

	@Inject
	private ILogActionDao logActionDao;

	@Override
	public LogAction getObject() {
		return new LogAction();
	}

	@Override
	public ILogActionDao getDao() {
		return logActionDao;
	}

}
