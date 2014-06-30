/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.filter;

import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;

/**
 * The Interface IFilterValueBet.
 */
public interface IFilterValueBet {

	/**
	 * Match filter.
	 * 
	 * @param matchs
	 *            the matchs
	 * @return the list
	 */
	List<RtMatch> matchFilter(List<RtMatch> matchs);

}
