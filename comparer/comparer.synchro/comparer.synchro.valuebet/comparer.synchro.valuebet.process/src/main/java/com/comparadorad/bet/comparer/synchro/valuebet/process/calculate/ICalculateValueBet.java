/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.process.calculate;

import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.synchro.valuebet.process.bean.CalculateValueBetData;

/**
 * The Interface ICalculateValueBet.
 */
public interface ICalculateValueBet {

	/**
	 * Calculate value bet.
	 * 
	 * @param rtbets
	 *            the rtbets
	 * @return the result value bet
	 */
	List<CalculateValueBetData> calculateValueBet(List<RtBet> rtbets);

	/**
	 * Gets the bet type id.
	 * 
	 * @return the bet type id
	 */
	CfgBetType.CfgBetTypeId getBetTypeId();

}
