/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class Historic.
 */
@SuppressWarnings("serial")
public class Historic implements IHistoric, Serializable {

	/** The historic list. */
	private List<IHistoricChange> historicList;

	/**
	 * Adds the.
	 * 
	 * @param historicChange
	 *            the historic change
	 * @return true, if successful {@inheritDoc}
	 */
	@Override
	public boolean add(IHistoricChange historicChange) {
		if (historicList == null) {
			historicList = new ArrayList<IHistoricChange>();
		}
		return historicList.add(historicChange);
	}

	/**
	 * Gets the historic list.
	 * 
	 * @return the historic list {@inheritDoc}
	 */
	@Override
	public List<IHistoricChange> getHistoricList() {
		return historicList;
	}
}
