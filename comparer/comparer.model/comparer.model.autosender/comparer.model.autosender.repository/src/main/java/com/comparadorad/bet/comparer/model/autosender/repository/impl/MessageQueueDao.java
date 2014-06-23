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

import com.comparadorad.bet.comparer.model.autosender.bean.MessageQueue;
import com.comparadorad.bet.comparer.model.autosender.repository.IMessageQueueDao;

/**
 * The Class MessageQueueDao.
 */
@Repository
class MessageQueueDao implements IMessageQueueDao {

	/** The hibernate template. */
	@Inject
	private HibernateTemplate hibernateTemplate;

	/** {@inheritDoc} */ 
	@Override
	public Integer save(MessageQueue t) {
		return (Integer) hibernateTemplate.save(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void update(MessageQueue t) {
		hibernateTemplate.update(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void delete(MessageQueue t) {
		hibernateTemplate.delete(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public MessageQueue findOne(Integer pId) {
		return hibernateTemplate.get(MessageQueue.class, pId);
	}

	/** {@inheritDoc} */ 
	@Override
	public List<MessageQueue> findAll() {
		return hibernateTemplate.loadAll(MessageQueue.class);
	}

}
