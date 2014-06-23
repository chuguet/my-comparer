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

import com.comparadorad.bet.comparer.model.autosender.bean.UserContent;
import com.comparadorad.bet.comparer.model.autosender.repository.IUserContentDao;

/**
 * The Class UserContentDao.
 */
@Repository
class UserContentDao implements IUserContentDao {

	/** The hibernate template. */
	@Inject
	private HibernateTemplate hibernateTemplate;

	/** {@inheritDoc} */ 
	@Override
	public Integer save(UserContent t) {
		return (Integer) hibernateTemplate.save(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void update(UserContent t) {
		hibernateTemplate.update(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void delete(UserContent t) {
		hibernateTemplate.delete(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public UserContent findOne(Integer pId) {
		return hibernateTemplate.get(UserContent.class, pId);
	}

	/** {@inheritDoc} */ 
	@Override
	public List<UserContent> findAll() {
		return hibernateTemplate.loadAll(UserContent.class);
	}

}
