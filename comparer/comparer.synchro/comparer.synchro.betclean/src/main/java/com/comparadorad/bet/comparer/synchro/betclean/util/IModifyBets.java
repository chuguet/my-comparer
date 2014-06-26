/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.betclean.util;

import java.util.List;

import com.comparadorad.bet.comparer.integration.core.beans.UpdaterBetsTO;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.synchro.betclean.exception.RemoveBetsException;
import com.comparadorad.bet.comparer.synchro.betclean.exception.UpdateBetsException;

/**
 * The Interface IModifyBets.
 */
public interface IModifyBets {


	/**
	 * Removes the bets.
	 *
	 * @param matchs the matchs
	 * @return the list
	 * @throws RemoveBetsException the remove bets exception
	 */
	List<RtMatch> removeBets(List<RtMatch> matchs) throws RemoveBetsException;


	/**
	 * Update bets.
	 *
	 * @param msg the msg
	 * @return the rt match
	 * @throws UpdateBetsException the update bets exception
	 */
	List<RtMatch> updateBets(UpdaterBetsTO msg) throws UpdateBetsException;

}
