/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.process.combination;

import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;

/**
 * The Interface ICombination.
 *
 * @param <T> the generic type
 */
public interface IRtBetCombination {
	
	/**
	 * Gets the combinations.
	 *
	 * @return the combinations
	 */
	List<List<RtBet>> getCombinations();

	/**
	 * Gets the combinations.
	 *
	 * @param size the size
	 * @return the combinations
	 */
	List<List<RtBet>> getCombinations(Integer size);

}
