/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.integration.producer.service;

import org.springframework.integration.annotation.Gateway;

import com.comparadorad.bet.comparer.integration.core.beans.ITransferObject;

/**
 * The Interface IProducer.
 * 
 * @param <T>
 *            the generic type
 */
public interface IProducer<T extends ITransferObject> {

	/**
	 * Send.
	 * 
	 * @param t
	 *            the t
	 */
	@Gateway
	void send(T t);
}
