/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.process.factory;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.synchro.valuebet.process.calculate.ICalculateValueBet;

/**
 * The Interface IFactoryCalculateValueBet.
 */
public interface IFactoryCalculateValueBet {

	/**
	 * Calculate value bet.
	 * 
	 * @param betType
	 *            the bet type
	 * @return the i calculate value bet
	 */
	ICalculateValueBet calculateValueBet(CfgBetType betType);
}
