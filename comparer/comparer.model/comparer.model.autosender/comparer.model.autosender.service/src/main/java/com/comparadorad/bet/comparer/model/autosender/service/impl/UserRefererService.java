package com.comparadorad.bet.comparer.model.autosender.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.autosender.bean.UserReferer;
import com.comparadorad.bet.comparer.model.autosender.repository.IUserRefererDao;
import com.comparadorad.bet.comparer.model.autosender.service.IUserRefererService;

@Service
class UserRefererService implements IUserRefererService {

	@Inject
	private IUserRefererDao userRefererDao;

	@Override
	public Integer save(UserReferer t) {
		return userRefererDao.save(t);
	}

	@Override
	public void update(UserReferer t) {
		userRefererDao.update(t);
	}

	@Override
	public void delete(UserReferer t) {
		userRefererDao.delete(t);
	}

	@Override
	public UserReferer findOne(Integer pId) {
		return userRefererDao.findOne(pId);
	}

	@Override
	public List<UserReferer> findAll() {
		return userRefererDao.findAll();
	}

}
