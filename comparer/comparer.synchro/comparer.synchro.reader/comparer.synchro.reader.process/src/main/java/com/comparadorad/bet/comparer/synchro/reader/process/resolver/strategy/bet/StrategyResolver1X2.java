/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.AbstractRtAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.MatchEvent;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2Attribute;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerBetTypeStrategy1x2;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bean.StrategyData;

/**
 * The Class StrategyResolverBetClick.
 */
@Component
public class StrategyResolver1X2 extends AbstractStrategyResolver {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(StrategyResolver1X2.class);
	
	/** The Constant NAME. */
	private static final String NAME = CfgBetTypeId.UNO_X_DOS.nameId();

	/** {@inheritDoc} */

	@Override
	public String getName() {
		return NAME;
	}

	/** {@inheritDoc} */

	@Override
	protected AbstractRtAttribute resolver(StrategyData pStrategyData,
			XmlMarketBet pXmlData, RtBet rtBet) {
		Rt1X2Attribute atributo = new Rt1X2Attribute();
		CfgBookmakerBetTypeStrategy1x2 matchResultStrategyConfig = (CfgBookmakerBetTypeStrategy1x2) pStrategyData
				.getBookmaker().getBookmakerConfiguration()
				.getBookmakerBetTypeStrategies()
				.get(CfgBookmakerBetTypeStrategy1x2.STRATEGY_ID);

		if (matchResultStrategyConfig != null) {
			if (matchResultStrategyConfig.isDrawPatternStrategy()) {
				atributo = drawPatternStrategy(pXmlData, matchResultStrategyConfig, rtBet);
			}
		} else{
			 LOG.error("No ha sido posible determina la estrategia necesaria para resolver la apuesta");
		 }

		return atributo;
	}

	/**
	 * Draw pattern strategy.
	 * 
	 * @param pXmlData
	 *            the xml data
	 * @return the rt match result attribute
	 */
	private Rt1X2Attribute drawPatternStrategy(XmlMarketBet pXmlData,
			CfgBookmakerBetTypeStrategy1x2 matchResultStrategyConfig, RtBet rtBet) {
		Rt1X2Attribute result = new Rt1X2Attribute();

		result.setEvent(getMatchEvent(pXmlData));
		
		
		if (matchResultStrategyConfig.getDrawPatternStrategyData()
				.getDrawString().equals(pXmlData.getName())) {
			result.setResult(Result.DRAW);
		} else if (matchResultStrategyConfig.getDrawPatternStrategyData()
				.getOneString().equals(pXmlData.getName())) {
			result.setResult(Result.ONE);
		} else if (matchResultStrategyConfig.getDrawPatternStrategyData()
				.getTwoString().equals(pXmlData.getName())) {
			result.setResult(Result.TWO);
		} else {
			if (matchResultStrategyConfig.getDrawPatternStrategyData().getOneString().equals("") && rtBet.getParticipant() != null) {
				if (rtBet.getParticipant().isHomeParticipant()) {
					result.setResult(Result.ONE);
				} else if (rtBet.getParticipant().isAwayParticipant()){
					result.setResult(Result.TWO);	
				}
			}
			
		}

		return result;
	}
}
