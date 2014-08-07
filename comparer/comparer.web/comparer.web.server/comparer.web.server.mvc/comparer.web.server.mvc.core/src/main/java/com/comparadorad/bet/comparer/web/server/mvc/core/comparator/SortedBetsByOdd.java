/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.core.comparator;

import java.util.Comparator;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;

/**
 * The Class SortedBetsByOdd.
 */
public class SortedBetsByOdd implements Comparator<RtBet> {

	/** {@inheritDoc} */
	@Override
	public int compare(RtBet o1, RtBet o2) {
		return Double.valueOf(o1.getBetOdd().getOdds()).compareTo(
				Double.valueOf(o2.getBetOdd().getOdds()));
	}

}
