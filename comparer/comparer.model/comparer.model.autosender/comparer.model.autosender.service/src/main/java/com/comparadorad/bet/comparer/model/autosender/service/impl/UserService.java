/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.service.impl;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comparadorad.bet.comparer.model.autosender.bean.User;
import com.comparadorad.bet.comparer.model.autosender.repository.IUserDao;
import com.comparadorad.bet.comparer.model.autosender.service.IUserService;

/**
 * The Class UserService.
 */
@Service
class UserService implements IUserService {

	/** The user dao. */
	@Inject
	private IUserDao userDao;

	@Override
	public Integer save(User t) {
		return userDao.save(t);
	}

	@Override
	public void update(User t) {
		userDao.update(t);
	}

	@Override
	public void delete(User t) {
		userDao.delete(t);
	}

	@Override
	@Transactional
	public User findOne(Integer pId) {
		return userDao.findOne(pId);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User findByLiferayId(Integer pId) {
		return userDao.findByLiferayId(pId);
	}

	@Override
	@Transactional
	public Collection<User> findActiveUsers() {
		return userDao.findActiveUsers();
	}

	@Override
	public void deleteByLiferayId(Integer liferayId) {
		User user = userDao.findByLiferayId(liferayId);
		userDao.delete(user);
	}

}
