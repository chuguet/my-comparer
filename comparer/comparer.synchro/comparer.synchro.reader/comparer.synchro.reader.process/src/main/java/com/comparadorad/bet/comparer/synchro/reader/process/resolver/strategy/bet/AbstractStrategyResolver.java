/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bet;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.bet.bean.AbstractRtAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.IMatchEvent;
import com.comparadorad.bet.comparer.model.bet.bean.MatchEvent;
import com.comparadorad.bet.comparer.model.bet.bean.MatchEventTypeWilliam;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.process.log.ISynchroErrorEvent;
import com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bean.StrategyData;

/**
 * The Class AbstractStrategyResolver.
 * 
 * @param <T>
 *            the generic type
 */
public abstract class AbstractStrategyResolver<T extends AbstractRtAttribute>
		implements IStrategyResolverBet<T> {

	/** The synchro error event. */
	@Inject
	private ISynchroErrorEvent synchroErrorEvent;

	/**
	 * Gets the synchro error event.
	 * 
	 * @return the synchro error event
	 */
	public ISynchroErrorEvent getSynchroErrorEvent() {
		return synchroErrorEvent;
	}

	/**
	 * Resolver abstract rt result.
	 * 
	 * @param pStrategyData
	 *            the strategy data
	 * @param pXmlData
	 *            the xml data
	 * @param rtBet
	 *            the rt bet
	 * @return the abstract rt attribute {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public T resolverAbstractRtResult(StrategyData pStrategyData,
			XmlMarketBet pXmlData, RtBet rtBet) {
		T attribute = null;
		attribute = (T) resolver(pStrategyData, pXmlData, rtBet);
		attribute.setBetName(pStrategyData.getXmlBetTypeName());
		return attribute;
	}

	/**
	 * Gets the match event.
	 * 
	 * @param pXmlData
	 *            the xml data
	 * @return the match event
	 */
	protected IMatchEvent getMatchEvent(XmlMarketBet pXmlData) {
		if (pXmlData.getParent() != null) {
			if (pXmlData.getParent().getXmlBetType().getName() != null) {
				if (pXmlData.getParent().getXmlBetType().getName()
						.indexOf("Half") != -1) {
					if (pXmlData.getParent().getXmlBetType().getName()
							.indexOf("1st") != -1) {
						return MatchEventTypeWilliam.FIRST_TIME;
					} else if (pXmlData.getParent().getXmlBetType().getName()
							.indexOf("2nd") != -1) {
						return MatchEventTypeWilliam.SECOND_TIME;
					} else {
						return MatchEventTypeWilliam.HALF_TIME;
					}
				} else if (pXmlData.getParent().getXmlBetType().getName()
						.indexOf("First") != -1
						|| pXmlData.getParent().getXmlBetType().getName()
								.indexOf("1st") != -1) {
					return MatchEventTypeWilliam.FIRST_TIME;
				} else if (pXmlData.getParent().getXmlBetType().getName()
						.indexOf("Second") != -1
						|| pXmlData.getParent().getXmlBetType().getName()
								.indexOf("2nd") != -1) {
					return MatchEventTypeWilliam.SECOND_TIME;
				} else {
					return MatchEventTypeWilliam.FINAL;
				}
			}
		}
		return null;
	}

	/**
	 * Resolver.
	 * 
	 * @param pStrategyData
	 *            the strategy data
	 * @param pXmlData
	 *            the xml data
	 * @param rtBet
	 *            the rt bet
	 * @return the abstract rt attribute
	 */
	protected abstract AbstractRtAttribute resolver(StrategyData pStrategyData,
			XmlMarketBet pXmlData, RtBet rtBet);

}
