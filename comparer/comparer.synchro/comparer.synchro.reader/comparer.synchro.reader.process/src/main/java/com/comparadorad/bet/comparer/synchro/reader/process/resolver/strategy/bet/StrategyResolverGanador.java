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
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtGanadorAttribute;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerBetTypeStrategyGanador;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bean.StrategyData;

/**
 * The Class StrategyResolverGanadorPartido.
 */
@Component
public class StrategyResolverGanador extends AbstractStrategyResolver {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(StrategyResolverGanador.class);

	/** The Constant NAME. */
	private static final String NAME = CfgBetTypeId.GANADOR.nameId();

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

		RtGanadorAttribute atributo = new RtGanadorAttribute();

		CfgBookmakerBetTypeStrategyGanador outrightWinnerStrategyConfig = (CfgBookmakerBetTypeStrategyGanador) pStrategyData
				.getBookmaker().getBookmakerConfiguration()
				.getBookmakerBetTypeStrategies()
				.get(CfgBookmakerBetTypeStrategyGanador.STRATEGY_ID);

		if (outrightWinnerStrategyConfig != null) {
			if (outrightWinnerStrategyConfig.isOutRightWinner()) {
				atributo = outRightWinnerPatternStrategy(pXmlData,
						outrightWinnerStrategyConfig);
			}

		} else {
			LOG.error("No ha sido posible determina la estrategia necesaria para resolver la apuesta");
		}

		return atributo;
	}

	/**
	 * One two pattern strategy.
	 * 
	 * @param pXmlData
	 *            the xml data
	 * @param pOutrightWinnerStrategyConfig
	 *            the win win strategy config
	 * @return the rt win win attribute
	 */
	private RtGanadorAttribute outRightWinnerPatternStrategy(
			XmlMarketBet pXmlData,
			CfgBookmakerBetTypeStrategyGanador pOutrightWinnerStrategyConfig) {
		RtGanadorAttribute result = new RtGanadorAttribute();

		//result.setWinnerName(pXmlData.getName());

		return result;
	}

}
