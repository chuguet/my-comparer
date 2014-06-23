/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.repository.impl;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.comparadorad.bet.comparer.model.autosender.bean.User;
import com.comparadorad.bet.comparer.model.autosender.repository.IUserDao;

/**
 * The Class UserDao.
 */
@Repository
class UserDao implements IUserDao {

	/** The QUER y_ lifera y_ id. */
	private final String QUERY_LIFERAY_ID = "from User where liferayUserId = ?";
	
	/** The QUER y_ active. */
	private final String QUERY_ACTIVE = "from User where active = ?";

	/** The hibernate template. */
	@Inject
	private HibernateTemplate hibernateTemplate;

	/** {@inheritDoc} */ 
	@Override
	public Integer save(User t) {
		return (Integer) hibernateTemplate.save(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void update(User t) {
		hibernateTemplate.update(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void delete(User t) {
		hibernateTemplate.delete(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public User findOne(Integer pId) {
		return hibernateTemplate.get(User.class, pId);
	}

	/** {@inheritDoc} */ 
	@Override
	public List<User> findAll() {
		return hibernateTemplate.loadAll(User.class);
	}

	/** {@inheritDoc} */ 
	@Override
	public User findByLiferayId(Integer pId) {
		User user = null;
		List<User> users = hibernateTemplate.find(QUERY_LIFERAY_ID, pId);
		if (users != null) {
			user = users.get(0);
		}
		return user;
	}

	/** {@inheritDoc} */ 
	@Override
	public Collection<User> findActiveUsers() {
		return hibernateTemplate.find(QUERY_ACTIVE, Boolean.TRUE);
	}

}
