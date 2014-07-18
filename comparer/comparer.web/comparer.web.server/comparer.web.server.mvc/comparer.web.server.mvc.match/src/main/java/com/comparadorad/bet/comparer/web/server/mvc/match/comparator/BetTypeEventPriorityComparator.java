/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.comparator;

import java.util.Comparator;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;

/**
 * The Class BetTypeEventPriorityComparator.
 */
public class BetTypeEventPriorityComparator implements
		Comparator<CfgBetTypeEvent> {

	/** {@inheritDoc} */
	@Override
	public int compare(CfgBetTypeEvent pO1, CfgBetTypeEvent pO2) {
		return pO1.getOrder().getPriority()
				.compareTo(pO2.getOrder().getPriority());
	}

}
