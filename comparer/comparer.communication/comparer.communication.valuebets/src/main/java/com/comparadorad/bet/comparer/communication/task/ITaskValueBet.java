/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.task;

import com.comparadorad.bet.comparer.communication.core.bean.ValueBetQueue;


/**
 * The Interface ITaskValueBet.
 */
public interface ITaskValueBet {

	/**
	 * Gets the num days.
	 * 
	 * @return the num days
	 */
	Integer getNumDays();

	/**
	 * Process.
	 */
	void process();

	/**
	 * Gets the value bet queue.
	 *
	 * @return the value bet queue
	 */
	ValueBetQueue getValueBetQueue();

}
