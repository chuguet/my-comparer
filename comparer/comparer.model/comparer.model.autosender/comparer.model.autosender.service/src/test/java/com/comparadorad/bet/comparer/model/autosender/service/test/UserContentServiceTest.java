package com.comparadorad.bet.comparer.model.autosender.service.test;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.autosender.bean.UserContent;
import com.comparadorad.bet.comparer.model.autosender.bean.UserContent.UserContentName;
import com.comparadorad.bet.comparer.model.autosender.service.IUserContentService;

public class UserContentServiceTest extends
		AbstractServiceTest<UserContent, IUserContentService> {

	@Inject
	private IUserContentService userContentService;

	@Override
	public IUserContentService getService() {
		return userContentService;
	}

	@Override
	public UserContent getObject() {
		UserContent content = new UserContent();
		content.setName(UserContentName.BLOG);
		return content;
	}

}