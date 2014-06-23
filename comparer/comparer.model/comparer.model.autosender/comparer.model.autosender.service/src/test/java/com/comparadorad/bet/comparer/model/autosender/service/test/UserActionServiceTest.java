package com.comparadorad.bet.comparer.model.autosender.service.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.UserAction;
import com.comparadorad.bet.comparer.model.autosender.service.IUserActionService;

public class UserActionServiceTest extends
		AbstractServiceTest<UserAction, IUserActionService> {

	@Inject
	private IUserActionService userActionService;

	@Override
	public IUserActionService getService() {
		return userActionService;
	}

	@Override
	public UserAction getObject() {
		return new UserAction();
	}

}