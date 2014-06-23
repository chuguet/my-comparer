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

import com.comparadorad.bet.comparer.model.autosender.bean.LogAction;
import com.comparadorad.bet.comparer.model.autosender.repository.ILogActionDao;

/**
 * The Class LogActionDao.
 */
@Repository
class LogActionDao implements ILogActionDao {

	/** The hibernate template. */
	@Inject
	private HibernateTemplate hibernateTemplate;

	/** {@inheritDoc} */ 
	@Override
	public Integer save(LogAction t) {
		return (Integer) hibernateTemplate.save(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void update(LogAction t) {
		hibernateTemplate.update(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void delete(LogAction t) {
		hibernateTemplate.delete(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public LogAction findOne(Integer pId) {
		return hibernateTemplate.get(LogAction.class, pId);
	}

	/** {@inheritDoc} */ 
	@Override
	public List<LogAction> findAll() {
		return hibernateTemplate.loadAll(LogAction.class);
	}

}
