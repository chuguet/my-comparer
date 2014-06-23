package com.comparadorad.bet.comparer.model.autosender.repository.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.User;
import com.comparadorad.bet.comparer.model.autosender.repository.IUserDao;

public class UserDaoTest extends AbstractDaoTest<User, IUserDao> {

	@Inject
	private IUserDao userDao;

	@Override
	public User getObject() {
		User user = new User();
		user.setEmail("user@user.com");
		user.setLiferayUserId(123);
		user.setName("Usuario");
		return user;
	}

	@Override
	public IUserDao getDao() {
		return userDao;
	}
}
