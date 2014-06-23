package com.comparadorad.bet.comparer.model.autosender.repository.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.ActionType;
import com.comparadorad.bet.comparer.model.autosender.repository.IActionTypeDao;

public class ActionTypeDaoTest extends
		AbstractDaoTest<ActionType, IActionTypeDao> {

	@Inject
	private IActionTypeDao actionTypeDao;

	@Override
	public ActionType getObject() {
		return new ActionType();
	}

	@Override
	public IActionTypeDao getDao() {
		return actionTypeDao;
	}

}
