package com.comparadorad.bet.comparer.model.autosender.repository.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.UserAction;
import com.comparadorad.bet.comparer.model.autosender.repository.IUserActionDao;

public class UserActionDaoTest extends
		AbstractDaoTest<UserAction, IUserActionDao> {

	@Inject
	private IUserActionDao userActionDao;

	@Override
	public UserAction getObject() {
		return new UserAction();
	}

	@Override
	public IUserActionDao getDao() {
		return userActionDao;
	}

}
