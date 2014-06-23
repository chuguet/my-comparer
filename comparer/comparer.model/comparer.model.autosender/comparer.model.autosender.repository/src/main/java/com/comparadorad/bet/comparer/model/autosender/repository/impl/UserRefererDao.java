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

import com.comparadorad.bet.comparer.model.autosender.bean.UserReferer;
import com.comparadorad.bet.comparer.model.autosender.repository.IUserRefererDao;

/**
 * The Class UserRefererDao.
 */
@Repository
class UserRefererDao implements IUserRefererDao {

	/** The hibernate template. */
	@Inject
	private HibernateTemplate hibernateTemplate;

	/** {@inheritDoc} */ 
	@Override
	public Integer save(UserReferer t) {
		return (Integer) hibernateTemplate.save(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void update(UserReferer t) {
		hibernateTemplate.update(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void delete(UserReferer t) {
		hibernateTemplate.delete(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public UserReferer findOne(Integer pId) {
		return hibernateTemplate.get(UserReferer.class, pId);
	}

	/** {@inheritDoc} */ 
	@Override
	public List<UserReferer> findAll() {
		return hibernateTemplate.loadAll(UserReferer.class);
	}

}
