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

import com.comparadorad.bet.comparer.model.autosender.bean.EventAttribute;
import com.comparadorad.bet.comparer.model.autosender.repository.IEventAttributeDao;

/**
 * The Class EventAttributeDao.
 */
@Repository
class EventAttributeDao implements IEventAttributeDao {

	/** The hibernate template. */
	@Inject
	private HibernateTemplate hibernateTemplate;

	/** {@inheritDoc} */ 
	@Override
	public Integer save(EventAttribute t) {
		return (Integer) hibernateTemplate.save(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void update(EventAttribute t) {
		hibernateTemplate.update(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void delete(EventAttribute t) {
		hibernateTemplate.delete(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public EventAttribute findOne(Integer pId) {
		return hibernateTemplate.get(EventAttribute.class, pId);
	}

	/** {@inheritDoc} */ 
	@Override
	public List<EventAttribute> findAll() {
		return hibernateTemplate.loadAll(EventAttribute.class);
	}

}
