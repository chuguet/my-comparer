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

import com.comparadorad.bet.comparer.model.autosender.bean.DurationPayment;
import com.comparadorad.bet.comparer.model.autosender.repository.IDurationPaymentDao;

/**
 * The Class DurationPaymentDao.
 */
@Repository
class DurationPaymentDao implements IDurationPaymentDao {

	/** The hibernate template. */
	@Inject
	private HibernateTemplate hibernateTemplate;

	/** {@inheritDoc} */ 
	@Override
	public Integer save(DurationPayment t) {
		return (Integer) hibernateTemplate.save(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void update(DurationPayment t) {
		hibernateTemplate.update(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void delete(DurationPayment t) {
		hibernateTemplate.delete(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public DurationPayment findOne(Integer pId) {
		return hibernateTemplate.get(DurationPayment.class, pId);
	}

	/** {@inheritDoc} */ 
	@Override
	public List<DurationPayment> findAll() {
		return hibernateTemplate.loadAll(DurationPayment.class);
	}

}
