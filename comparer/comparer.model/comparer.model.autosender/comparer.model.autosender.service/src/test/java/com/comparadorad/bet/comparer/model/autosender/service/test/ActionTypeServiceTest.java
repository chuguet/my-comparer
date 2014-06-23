package com.comparadorad.bet.comparer.model.autosender.service.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.ActionType;
import com.comparadorad.bet.comparer.model.autosender.service.IActionTypeService;

public class ActionTypeServiceTest extends
		AbstractServiceTest<ActionType, IActionTypeService> {

	@Inject
	private IActionTypeService actionTypeService;

	@Override
	public IActionTypeService getService() {
		return actionTypeService;
	}

	@Override
	public ActionType getObject() {
		return new ActionType();
	}

}