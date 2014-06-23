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

import com.comparadorad.bet.comparer.model.autosender.bean.Event;
import com.comparadorad.bet.comparer.model.autosender.repository.IEventDao;

/**
 * The Class EventDao.
 */
@Repository
class EventDao implements IEventDao {

	/** The hibernate template. */
	@Inject
	private HibernateTemplate hibernateTemplate;

	/** {@inheritDoc} */ 
	@Override
	public Integer save(Event t) {
		return (Integer) hibernateTemplate.save(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void update(Event t) {
		hibernateTemplate.update(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void delete(Event t) {
		hibernateTemplate.delete(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public Event findOne(Integer pId) {
		return hibernateTemplate.get(Event.class, pId);
	}

	/** {@inheritDoc} */ 
	@Override
	public List<Event> findAll() {
		return hibernateTemplate.loadAll(Event.class);
	}

}
