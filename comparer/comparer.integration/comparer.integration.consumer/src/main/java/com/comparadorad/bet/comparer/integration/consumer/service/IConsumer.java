/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.integration.consumer.service;

import com.comparadorad.bet.comparer.integration.core.beans.ITransferObject;

/**
 * The Interface IConsumer.
 * 
 * @param <T>
 *            the generic type
 */
public interface IConsumer<T extends ITransferObject> {

	/**
	 * Receive.
	 * 
	 * @param t
	 *            the t
	 */
	void receive(T t);
}
