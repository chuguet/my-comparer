/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bet;

import com.comparadorad.bet.comparer.model.bet.bean.AbstractRtAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bean.StrategyData;

/**
 * The Interface IStrategyResolverBet.
 * 
 * @param <T>
 *            the generic type
 */
public interface IStrategyResolverBet<T extends AbstractRtAttribute> {

	/**
	 * Resolver abstract rt result.
	 * 
	 * @param strategyData
	 *            the strategy data
	 * @param pXmlData
	 *            the xml data
	 * @return the abstract rt attribute
	 */
	T resolverAbstractRtResult(StrategyData strategyData, XmlMarketBet pXmlData, RtBet rtBet);

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	String getName();

}
