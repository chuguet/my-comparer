package com.comparadorad.bet.comparer.model.autosender.service.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.User;
import com.comparadorad.bet.comparer.model.autosender.service.IUserService;

public class UserServiceTest extends AbstractServiceTest<User, IUserService> {

	@Inject
	private IUserService userService;

	@Override
	public IUserService getService() {
		return userService;
	}

	@Override
	public User getObject() {
		return new User();
	}

}