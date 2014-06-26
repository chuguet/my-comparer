/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean;

import java.util.List;

/**
 * The Interface IHistoric.
 */
public interface IHistoric {

	/**
	 * Adds the.
	 *
	 * @param historicChange the historic change
	 * @return true, if successful
	 */
	public abstract boolean add(IHistoricChange historicChange);

	/**
	 * Gets the historic list.
	 * 
	 * @return the historic list
	 */
	public abstract List<IHistoricChange> getHistoricList();

}