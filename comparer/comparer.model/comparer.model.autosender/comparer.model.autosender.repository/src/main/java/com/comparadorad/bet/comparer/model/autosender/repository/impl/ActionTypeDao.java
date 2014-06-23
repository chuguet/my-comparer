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

import com.comparadorad.bet.comparer.model.autosender.bean.ActionType;
import com.comparadorad.bet.comparer.model.autosender.repository.IActionTypeDao;

/**
 * The Class ActionTypeDao.
 */
@Repository
class ActionTypeDao implements IActionTypeDao {

	/** The hibernate template. */
	@Inject
	private HibernateTemplate hibernateTemplate;

	/** {@inheritDoc} */ 
	@Override
	public Integer save(ActionType t) {
		return (Integer) hibernateTemplate.save(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void update(ActionType t) {
		hibernateTemplate.update(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void delete(ActionType t) {
		hibernateTemplate.delete(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public ActionType findOne(Integer pId) {
		return hibernateTemplate.get(ActionType.class, pId);
	}

	/** {@inheritDoc} */ 
	@Override
	public List<ActionType> findAll() {
		return hibernateTemplate.loadAll(ActionType.class);
	}

}
