/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bet;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.AbstractRtAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.RtAsianHandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerBetTypeStrategyAsianHandicap;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bean.StrategyData;
import com.comparadorad.bet.comparer.util.commons.string.StringUtil;

/**
 * The Class StrategyResolverAsianHandicap.
 */
@Component
public class StrategyResolverAsianHandicap extends AbstractStrategyResolver {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(StrategyResolverAsianHandicap.class);

	/** The Constant NAME. */
	private static final String NAME = CfgBetTypeId.HANDICAP_ASIATICO.nameId();

	/** The Constant specialPositiveCaseHandicap. */
	private static final double specialPositiveCaseHandicap = 0.25;

	/** The Constant specialNegativeCaseHandicap. */
	private static final double specialNegativeCaseHandicap = -0.25;
	
	/** The string util. */
	@Inject
	private StringUtil stringUtil;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 * {@inheritDoc}
	 */

	@Override
	public String getName() {
		return NAME;
	}

	/**
	 * Resolver.
	 *
	 * @param pStrategyData the strategy data
	 * @param pXmlData the xml data
	 * @param rtBet the rt bet
	 * @return the abstract rt attribute
	 * {@inheritDoc}
	 */

	@Override
	protected AbstractRtAttribute resolver(StrategyData pStrategyData,
			XmlMarketBet pXmlData, RtBet rtBet) {
		RtAsianHandicapAttribute atributo = new RtAsianHandicapAttribute();
		CfgBookmakerBetTypeStrategyAsianHandicap asianHandicapStrategyConfig = (CfgBookmakerBetTypeStrategyAsianHandicap) pStrategyData
				.getBookmaker().getBookmakerConfiguration()
				.getBookmakerBetTypeStrategies()
				.get(CfgBookmakerBetTypeStrategyAsianHandicap.STRATEGY_ID);

		if (asianHandicapStrategyConfig != null) {
			if (asianHandicapStrategyConfig.isOneTwoPatternStrategy()) {
				atributo = oneTwoPatternStrategy(pXmlData,
						asianHandicapStrategyConfig);
			} else if (asianHandicapStrategyConfig
					.isLiteralTeamNamePatternStrategy()) {
				atributo = literalTeamNamePatternStrategy(pXmlData, rtBet);
			} else if (asianHandicapStrategyConfig.isHandicapMarketBetValuePatternStrategy()) {
				atributo = marketBetValuePatternStrategy(pXmlData, asianHandicapStrategyConfig, rtBet);
			}
		} else {
			LOG.error("No ha sido posible determina la estrategia necesaria para resolver la apuesta");
		}

		return atributo;
	}
	
	/**
	 * Market bet value pattern strategy.
	 *
	 * @param pXmlData the xml data
	 * @param asianHandicapStrategyConfig the asian handicap strategy config
	 * @param rtBet the rt bet
	 * @return the rt asian handicap attribute
	 */
	private RtAsianHandicapAttribute marketBetValuePatternStrategy (XmlMarketBet pXmlData,CfgBookmakerBetTypeStrategyAsianHandicap asianHandicapStrategyConfig, RtBet rtBet) {
		RtAsianHandicapAttribute result = new RtAsianHandicapAttribute();
		
		result.setEvent(getMatchEvent(pXmlData));
		
		if (StringUtils.isNotEmpty(pXmlData.getMarketBetValue())) {
			//Tratamos la cadena para eliminar caracteres innecesarios
			if ( (Double.valueOf(pXmlData.getMarketBetValue()) == specialNegativeCaseHandicap) || (pXmlData.getMarketBetValue().indexOf(".25") != -1) ) {
				result.setFirstValue(0);
				result.setSecondValue(-0.5);
			} else if ( (Double.valueOf(pXmlData.getMarketBetValue()) == specialPositiveCaseHandicap) || (pXmlData.getMarketBetValue().indexOf(".25") != -1)) {
				result.setFirstValue(0);
				result.setSecondValue(0.5);
			} else {
				result.setFirstValue((Double.valueOf(stringUtil.deleteCharacter(pXmlData.getMarketBetValue(), "+"))));
			}
		}
		return result;
	}

	/**
	 * Literal team name pattern strategy.
	 *
	 * @param pXmlData the xml data
	 * @param rtBet the rt bet
	 * @return the rt asian handicap attribute
	 */
	private RtAsianHandicapAttribute literalTeamNamePatternStrategy(
			XmlMarketBet pXmlData, RtBet rtBet) {
		RtAsianHandicapAttribute result = new RtAsianHandicapAttribute();

		// Añado el valor de la estrategia
		//String nombreApuesta = stringUtil.deleteParenthesis(pXmlData.getName());
//		
		String nombreApuesta;
		
		if (StringUtils.isEmpty(pXmlData.getMarketBetValue())) {
			int primerParentesis = pXmlData.getName().indexOf("(");
			int segundoParentesis = pXmlData.getName().indexOf(")");
			nombreApuesta = pXmlData.getName().substring(primerParentesis+1, segundoParentesis);
			nombreApuesta = stringUtil.deleteCharacter(nombreApuesta, "+");
		} else {
			nombreApuesta = stringUtil.deleteParenthesis(pXmlData.getName());
		}
		
		
		
		String[] valorHandicap = nombreApuesta.split(",");
		valorHandicap[0] = valorHandicap[0].replace(" ", "");
		if (valorHandicap.length > 1) {
			valorHandicap[0] = valorHandicap[0].substring(
				valorHandicap[0].length() - 1, valorHandicap[0].length());
		}

		if (valorHandicap.length > 1) {
			// Cuando vienen dos numeros pongo los dos.
			result.setFirstValue(Double.valueOf(valorHandicap[0]));
			result.setSecondValue(Double.valueOf(valorHandicap[1]));
		} else {
			// Si nos llega -0.25 se ponen los dos multiplos mas cercanos a 0.5,
			// es decir 0 y -0.5
			//String valor = valorHandicap[0].substring(valorHandicap[0].length()-1,valorHandicap[0].length());
			if (Double.valueOf(valorHandicap[0]) == specialNegativeCaseHandicap) {
				result.setFirstValue(0);
				result.setSecondValue(-0.5);
				// Si llega 0.25 se ponen los dos multiplos mas cercanos es
				// decir, 0 y 0.5
			} else if (Double.valueOf(valorHandicap[0]) == specialPositiveCaseHandicap) {
				result.setFirstValue(0);
				result.setSecondValue(0.5);
			} else {
				result.setFirstValue(Double.valueOf(valorHandicap[0]));
			}

		}

		// Añado el apostante
		if (rtBet.getParticipant() != null) {
			if (rtBet.getParticipant().isHomeParticipant()) {
				result.setAsianResult(AsianResult.ONE);
			} else if (rtBet.getParticipant().isAwayParticipant()) {
				result.setAsianResult(AsianResult.TWO);
			}
		}

		// Añado el primer tiempo o segundo.
		result.setEvent(this.getMatchEvent(pXmlData));

		return result;
	}

	/**
	 * One two pattern strategy.
	 * 
	 * @param pXmlData
	 *            the xml data
	 * @param asianHandicapStrategyConfig
	 *            the asian handicap strategy config
	 * @return the rt asian handicap attribute
	 */
	private RtAsianHandicapAttribute oneTwoPatternStrategy(
			XmlMarketBet pXmlData,
			CfgBookmakerBetTypeStrategyAsianHandicap asianHandicapStrategyConfig) {
		RtAsianHandicapAttribute result = new RtAsianHandicapAttribute();

		// Añado el primer tiempo o segundo.
		result.setEvent(this.getMatchEvent(pXmlData));
		
		String[] array = pXmlData.getName().split(" ");
		if (array.length > 1) {
			result.setFirstValue(Double.valueOf(array[1]));
		} else {
			result.setFirstValue(Double.valueOf(array[0]));
		}
		
		
		// if
		// (array[0].equals(asianHandicapStrategyConfig.getOneTwoPatternStrategyData().getOneString()))
		// {
		// result.setValue(Double.valueOf(array[1]));
		// } else if
		// (array[0].equals(asianHandicapStrategyConfig.getOneTwoPatternStrategyData().getTwoString()))
		// {
		// result.setValue(Double.valueOf(array[1]));
		// }

		return result;
	}

}
