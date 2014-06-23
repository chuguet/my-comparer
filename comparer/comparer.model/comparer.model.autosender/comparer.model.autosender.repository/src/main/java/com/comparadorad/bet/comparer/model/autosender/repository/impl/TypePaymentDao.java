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

import com.comparadorad.bet.comparer.model.autosender.bean.TypePayment;
import com.comparadorad.bet.comparer.model.autosender.repository.ITypePaymentDao;

/**
 * The Class TypePaymentDao.
 */
@Repository
class TypePaymentDao implements ITypePaymentDao {

	/** The hibernate template. */
	@Inject
	private HibernateTemplate hibernateTemplate;

	/** {@inheritDoc} */ 
	@Override
	public Integer save(TypePayment t) {
		return (Integer) hibernateTemplate.save(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void update(TypePayment t) {
		hibernateTemplate.update(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void delete(TypePayment t) {
		hibernateTemplate.delete(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public TypePayment findOne(Integer pId) {
		return hibernateTemplate.get(TypePayment.class, pId);
	}

	/** {@inheritDoc} */ 
	@Override
	public List<TypePayment> findAll() {
		return hibernateTemplate.loadAll(TypePayment.class);
	}

}
