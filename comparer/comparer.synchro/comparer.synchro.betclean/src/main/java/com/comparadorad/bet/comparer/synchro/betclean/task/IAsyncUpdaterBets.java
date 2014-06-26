/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.betclean.task;

import com.comparadorad.bet.comparer.integration.core.beans.UpdaterBetsTO;

/**
 * The Interface IUpdaterBets.
 */
public interface IAsyncUpdaterBets {

	/**
	 * Update bets from msg queue.
	 * 
	 * @param msg
	 *            the msg
	 * @param idThreadLauncher
	 *            the id thread launcher
	 */
	void updateBetsFromMsgQueue(UpdaterBetsTO msg, String idThreadLauncher);
}
