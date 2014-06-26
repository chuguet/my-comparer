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
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtGanadorPartidoAttribute;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerBetTypeStrategyGanadorPart;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bean.StrategyData;

/**
 * The Class StrategyResolverGanadorPartido.
 */
@Component
public class StrategyResolverGanadorPartido extends AbstractStrategyResolver {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(StrategyResolverGanadorPartido.class);
	
	/** The Constant NAME. */
	private static final String NAME = CfgBetTypeId.GANADOR_PARTIDO.nameId();

	/**
	 * Gets the name.
	 * 
	 * @return the name {@inheritDoc}
	 */

	@Override
	public String getName() {
		return NAME;
	}

	/**
	 * Resolver.
	 * 
	 * @param pStrategyData
	 *            the strategy data
	 * @param pResult
	 *            the result
	 * @param pXmlData
	 *            the xml data
	 * @return the abstract rt attribute {@inheritDoc}
	 */

	@Override
	protected AbstractRtAttribute resolver(StrategyData pStrategyData,
			XmlMarketBet pXmlData, RtBet rtBet) {

		RtGanadorPartidoAttribute atributo = new RtGanadorPartidoAttribute();

		CfgBookmakerBetTypeStrategyGanadorPart winWinStrategyConfig = (CfgBookmakerBetTypeStrategyGanadorPart) pStrategyData
				.getBookmaker().getBookmakerConfiguration()
				.getBookmakerBetTypeStrategies()
				.get(CfgBookmakerBetTypeStrategyGanadorPart.STRATEGY_ID);

		if (winWinStrategyConfig != null) {
			if (winWinStrategyConfig.isOneTwoPatternStrategy()) {
				atributo = oneTwoPatternStrategy(pXmlData, winWinStrategyConfig);
			}
		}else{
			 LOG.error("No ha sido posible determina la estrategia necesaria para resolver la apuesta");
		 }
		

		return atributo;
	}

	/**
	 * One two pattern strategy.
	 * 
	 * @param pXmlData
	 *            the xml data
	 * @param winWinStrategyConfig
	 *            the win win strategy config
	 * @return the rt win win attribute
	 */
	private RtGanadorPartidoAttribute oneTwoPatternStrategy(XmlMarketBet pXmlData,
			CfgBookmakerBetTypeStrategyGanadorPart winWinStrategyConfig) {
		RtGanadorPartidoAttribute result = new RtGanadorPartidoAttribute();

//		result.setWinnerName(pXmlData.getName());
		
		String[] array = pXmlData.getName().split(" ");
		if (winWinStrategyConfig.getOneTwoPatternStrategyData().getOneString().equals("")) {
			if (pXmlData.getXmlMatchParticipant() != null && pXmlData.getXmlMatchParticipant().isHomeParticipant()) {
//				result.setWinnerName(pXmlData.getXmlMatchParticipant().getName());
				result.setResult(Result.ONE);
			} else if (pXmlData.getXmlMatchParticipant() != null && pXmlData.getXmlMatchParticipant().isAwayParticipant()) {
//				result.setWinnerName(pXmlData.getXmlMatchParticipant().getName());
				result.setResult(Result.TWO);
			}
		} else if (array[0].equals(winWinStrategyConfig.getOneTwoPatternStrategyData()
				.getOneString())) {
			result.setResult(Result.ONE);
		} else if (array[0].equals(winWinStrategyConfig
				.getOneTwoPatternStrategyData().getTwoString())) {
			result.setResult(Result.TWO);
		}

		return result;
	}

}
