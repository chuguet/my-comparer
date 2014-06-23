/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.repository.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.comparadorad.bet.comparer.model.autosender.bean.UserAction;
import com.comparadorad.bet.comparer.model.autosender.repository.IUserActionDao;

/**
 * The Class UserActionDao.
 */
@Repository
class UserActionDao implements IUserActionDao {

	/** The hibernate template. */
	@Inject
	private HibernateTemplate hibernateTemplate;

	/** {@inheritDoc} */ 
	@Override
	public Integer save(UserAction t) {
		return (Integer)hibernateTemplate.save(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void update(UserAction t) {
		hibernateTemplate.update(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void delete(UserAction t) {
		hibernateTemplate.delete(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public UserAction findOne(Integer pId) {
		return hibernateTemplate.get(UserAction.class, pId);
	}

	/** {@inheritDoc} */ 
	@Override
	public List<UserAction> findAll() {
		return hibernateTemplate.loadAll(UserAction.class);
	}

}
