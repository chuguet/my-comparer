package com.comparadorad.bet.comparer.model.autosender.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.autosender.bean.UserContent;
import com.comparadorad.bet.comparer.model.autosender.repository.IUserContentDao;
import com.comparadorad.bet.comparer.model.autosender.service.IUserContentService;

@Service
class UserContentService implements IUserContentService {

	@Inject
	private IUserContentDao userContentDao;

	@Override
	public Integer save(UserContent t) {
		return userContentDao.save(t);
	}

	@Override
	public void update(UserContent t) {
		userContentDao.update(t);
	}

	@Override
	public void delete(UserContent t) {
		userContentDao.delete(t);
	}

	@Override
	public UserContent findOne(Integer pId) {
		return userContentDao.findOne(pId);
	}

	@Override
	public List<UserContent> findAll() {
		return userContentDao.findAll();
	}

}
