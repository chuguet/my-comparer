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

import com.comparadorad.bet.comparer.model.autosender.bean.PaypalAction;
import com.comparadorad.bet.comparer.model.autosender.repository.IPaypalActionDao;

/**
 * The Class PaypalActionDao.
 */
@Repository
public class PaypalActionDao implements IPaypalActionDao {
	
	/** The hibernate template. */
	@Inject
	private HibernateTemplate hibernateTemplate;

	/** {@inheritDoc} */ 
	@Override
	public Integer save(PaypalAction t) {
		return (Integer) hibernateTemplate.save(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void update(PaypalAction t) {
		hibernateTemplate.update(t);		
	}

	/** {@inheritDoc} */ 
	@Override
	public void delete(PaypalAction t) {
		hibernateTemplate.delete(t);		
	}

	/** {@inheritDoc} */ 
	@Override
	public PaypalAction findOne(Integer pId) {
		return hibernateTemplate.get(PaypalAction.class, pId);
	}

	/** {@inheritDoc} */ 
	@Override
	public List<PaypalAction> findAll() {
		return hibernateTemplate.loadAll(PaypalAction.class);
	}

	@SuppressWarnings("unchecked")
	public List<PaypalAction> findByToken(String tokenID){
		String query = "from PaypalAction p where p.token = :tokenID  ";
		
		return (List<PaypalAction>) hibernateTemplate.findByNamedParam(query, "tokenID", tokenID);
		
	}
}
