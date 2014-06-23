/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.service;

import java.util.List;

import com.comparadorad.bet.comparer.model.autosender.bean.PaypalAction;

/**
 * The Interface IPaypalActionService.
 * 
 * @param <T>
 *            the generic type
 * @param <I>
 *            the generic type
 */
public interface IPaypalActionService extends
		IModelService<PaypalAction, Integer> {

	public List<PaypalAction> findByToken(String tokenID);
}
