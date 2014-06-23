package com.comparadorad.bet.comparer.model.autosender.service.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.UserReferer;
import com.comparadorad.bet.comparer.model.autosender.service.IUserRefererService;

public class UserRefererServiceTest extends
		AbstractServiceTest<UserReferer, IUserRefererService> {

	@Inject
	private IUserRefererService userRefererService;

	@Override
	public IUserRefererService getService() {
		return userRefererService;
	}

	@Override
	public UserReferer getObject() {
		return new UserReferer();
	}
}