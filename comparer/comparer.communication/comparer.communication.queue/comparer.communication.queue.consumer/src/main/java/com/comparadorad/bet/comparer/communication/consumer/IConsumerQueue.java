/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.consumer;


/**
 * The Interface IConsumerQueue.
 */
public interface IConsumerQueue<T> {
	
	/**
	 * Receive.
	 *
	 * @return the value bet queue
	 */
	public T receive();

}
