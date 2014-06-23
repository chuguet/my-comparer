/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.repository;

import java.util.List;

import com.comparadorad.bet.comparer.model.autosender.bean.PaypalAction;

/**
 * The Interface IPaypalActionDao.
 */
public interface IPaypalActionDao extends IRepositoryDAO<PaypalAction, Integer> {

	
	public List<PaypalAction> findByToken(String tokenID);
}
