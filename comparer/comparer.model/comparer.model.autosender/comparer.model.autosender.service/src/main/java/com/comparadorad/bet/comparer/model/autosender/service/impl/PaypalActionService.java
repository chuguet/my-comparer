/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.autosender.bean.PaypalAction;
import com.comparadorad.bet.comparer.model.autosender.repository.IPaypalActionDao;
import com.comparadorad.bet.comparer.model.autosender.service.IPaypalActionService;

/**
 * The Class PaypalActionService.
 */
@Service
public class PaypalActionService implements IPaypalActionService {
	
	/** The paypal action dao. */
	@Inject
	private IPaypalActionDao paypalActionDao;

	/** {@inheritDoc} */ 
	@Override
	public Integer save(PaypalAction t) {
		return paypalActionDao.save(t);
	}

	/** {@inheritDoc} */ 
	@Override
	public void update(PaypalAction t) {
		paypalActionDao.update(t);		
	}

	/** {@inheritDoc} */ 
	@Override
	public void delete(PaypalAction t) {
		paypalActionDao.delete(t);		
	}

	/** {@inheritDoc} */ 
	@Override
	public PaypalAction findOne(Integer pId) {
		return paypalActionDao.findOne(pId);
	}

	/** {@inheritDoc} */ 
	@Override
	public List<PaypalAction> findAll() {
		return paypalActionDao.findAll();
	}

	@Override
	public List<PaypalAction> findByToken(String tokenID) {
		return paypalActionDao.findByToken(tokenID);
	}
	
	

}
