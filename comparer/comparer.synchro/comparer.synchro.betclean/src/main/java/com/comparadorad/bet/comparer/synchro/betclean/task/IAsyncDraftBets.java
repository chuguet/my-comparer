/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.betclean.task;

import com.comparadorad.bet.comparer.synchro.betclean.beans.Range;

/**
 * The Interface IDraftBets.
 */
public interface IAsyncDraftBets {

	/**
	 * Removes the bets.
	 * 
	 * @param range
	 *            the range
	 * @param idThreadLauncher
	 *            the id thread launcher
	 */
	void removeBetsFromRangeMatchs(Range range, String idThreadLauncher);

}
