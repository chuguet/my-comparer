/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.comparator;

import java.util.Comparator;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;

/**
 * The Class BetTypePriorityComparator.
 */
public class BetTypePriorityComparator implements Comparator<CfgBetType> {

	/** {@inheritDoc} */
	@Override
	public int compare(CfgBetType pO1, CfgBetType pO2) {
		return pO1.getOrder().getPriority()
				.compareTo(pO2.getOrder().getPriority());
	}

}
