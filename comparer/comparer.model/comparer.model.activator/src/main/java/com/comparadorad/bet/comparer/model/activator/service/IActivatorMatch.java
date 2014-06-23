/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.activator.service;

import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;

/**
 * The Interface IActivatorMatch.
 */
public interface IActivatorMatch {
	
	/**
	 * Execute.
	 *
	 * @param match the match
	 * @return the rt match
	 */
	RtMatch execute(RtMatch match, Boolean isNew);
	
	/**
	 * Execute.
	 *
	 * @param matchs the matchs
	 * @return the list
	 */
	List<RtMatch> execute(List<RtMatch> matchs,Boolean isNew);

}
