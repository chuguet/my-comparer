package com.comparadorad.bet.comparer.model.autosender.repository.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.UserReferer;
import com.comparadorad.bet.comparer.model.autosender.repository.IUserRefererDao;

public class UserRefererDaoTest extends
		AbstractDaoTest<UserReferer, IUserRefererDao> {

	@Inject
	private IUserRefererDao userRefererDao;

	@Override
	public UserReferer getObject() {
		return new UserReferer();
	}

	@Override
	public IUserRefererDao getDao() {
		return userRefererDao;
	}

}
