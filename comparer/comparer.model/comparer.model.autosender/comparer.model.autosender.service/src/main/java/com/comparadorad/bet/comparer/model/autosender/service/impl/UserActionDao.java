package com.comparadorad.bet.comparer.model.autosender.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.autosender.bean.UserAction;
import com.comparadorad.bet.comparer.model.autosender.repository.IUserActionDao;
import com.comparadorad.bet.comparer.model.autosender.service.IUserActionService;

@Service
class UserActionService implements IUserActionService {

	@Inject
	private IUserActionDao userActionDao;

	@Override
	public Integer save(UserAction t) {
		return userActionDao.save(t);
	}

	@Override
	public void update(UserAction t) {
		userActionDao.update(t);
	}

	@Override
	public void delete(UserAction t) {
		userActionDao.delete(t);
	}

	@Override
	public UserAction findOne(Integer pId) {
		return userActionDao.findOne(pId);
	}

	@Override
	public List<UserAction> findAll() {
		return userActionDao.findAll();
	}

}
