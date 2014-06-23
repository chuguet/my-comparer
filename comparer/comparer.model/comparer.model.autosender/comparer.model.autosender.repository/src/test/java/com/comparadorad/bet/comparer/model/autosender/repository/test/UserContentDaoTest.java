package com.comparadorad.bet.comparer.model.autosender.repository.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.UserContent;
import com.comparadorad.bet.comparer.model.autosender.bean.UserContent.UserContentName;
import com.comparadorad.bet.comparer.model.autosender.repository.IUserContentDao;

public class UserContentDaoTest extends
		AbstractDaoTest<UserContent, IUserContentDao> {

	@Inject
	private IUserContentDao userContentDao;

	@Override
	public UserContent getObject() {
		UserContent content = new UserContent();
		content.setName(UserContentName.BLOG);
		return content;
	}

	@Override
	public IUserContentDao getDao() {
		return userContentDao;
	}

}
