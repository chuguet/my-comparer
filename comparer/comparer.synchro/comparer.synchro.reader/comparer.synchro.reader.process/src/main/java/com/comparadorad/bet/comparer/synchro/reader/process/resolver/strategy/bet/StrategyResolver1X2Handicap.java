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
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2HandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerBetTypeStrategy1X2Handicap;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bean.StrategyData;
import com.comparadorad.bet.comparer.util.commons.string.StringUtil;

/**
 * The Class StrategyResolverBetClick.
 */
@Component
public class StrategyResolver1X2Handicap extends AbstractStrategyResolver {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(StrategyResolver1X2Handicap.class);

	/** The Constant NAME. */
	private static final String NAME = CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId();

	@Inject
	private StringUtil stringUtil;

	/** {@inheritDoc} */

	@Override
	public String getName() {
		return NAME;
	}

	/** {@inheritDoc} */

	@Override
	protected AbstractRtAttribute resolver(StrategyData pStrategyData,
			XmlMarketBet pXmlData, RtBet rtBet) {
		Rt1X2HandicapAttribute atributo = new Rt1X2HandicapAttribute();
		CfgBookmakerBetTypeStrategy1X2Handicap handicapStrategyConfig = (CfgBookmakerBetTypeStrategy1X2Handicap) pStrategyData
				.getBookmaker().getBookmakerConfiguration()
				.getBookmakerBetTypeStrategies()
				.get(CfgBookmakerBetTypeStrategy1X2Handicap.STRATEGY_ID);

		if (handicapStrategyConfig != null) {
			if (handicapStrategyConfig.isDrawPatternStrategy()) {
				atributo = drawPatternStrategy(pXmlData, handicapStrategyConfig);
			} else if (handicapStrategyConfig
					.isHandicapMarketBetValuePatternStrategy()) {
				atributo = handicapMarketBetValuePatternStrategy(pXmlData,
						handicapStrategyConfig, rtBet);
			} else if (handicapStrategyConfig
					.isLiteralTeamNamePatternStrategy()) {
				atributo = literalTeamNamePatternStrategy(pXmlData, rtBet);
			}
		} else {
			LOG.error("No ha sido posible determina la estrategia necesaria para resolver la apuesta");
		}

		return atributo;
	}

	private Rt1X2HandicapAttribute literalTeamNamePatternStrategy(
			XmlMarketBet pXmlData, RtBet rtBet) {
		Rt1X2HandicapAttribute result = new Rt1X2HandicapAttribute();

		int primerParentesis = pXmlData.getName().indexOf("(");
		int segundoParentesis = pXmlData.getName().indexOf(")");

		String nombreApuesta = pXmlData.getName().substring(
				primerParentesis + 1, segundoParentesis);
		nombreApuesta = stringUtil.deleteCharacter(nombreApuesta, "+");

		String[] valorHandicap = nombreApuesta.split(",");
		valorHandicap[0] = valorHandicap[0].replace(" ", "");
		if (valorHandicap.length > 1) {
			valorHandicap[0] = valorHandicap[0].substring(
					valorHandicap[0].length() - 1, valorHandicap[0].length());
		}

		result.setValue(Double.valueOf(valorHandicap[0]));

		// Añado el apostante
		if (rtBet.getParticipant() != null) {
			if (rtBet.getParticipant().isHomeParticipant()) {
				result.setResult(Result.ONE);
			} else if (rtBet.getParticipant().isAwayParticipant()) {
				result.setResult(Result.TWO);
			} else {
				result.setResult(Result.DRAW);
			}
		}

		// Añado el primer tiempo o segundo.
		result.setEvent(this.getMatchEvent(pXmlData));

		return result;
	}

	private Rt1X2HandicapAttribute handicapMarketBetValuePatternStrategy(
			XmlMarketBet pXmlData,
			CfgBookmakerBetTypeStrategy1X2Handicap handicapStrategyConfig,
			RtBet rtBet) {
		Rt1X2HandicapAttribute result = new Rt1X2HandicapAttribute();

		result.setEvent(getMatchEvent(pXmlData));

		if (StringUtils.isNotEmpty(pXmlData.getMarketBetValue())) {
			// Tratamos la cadena para eliminar caracteres innecesarios
			result.setValue(Double.valueOf(stringUtil.deleteCharacter(
					pXmlData.getMarketBetValue(), "+")));

		}

		if (handicapStrategyConfig
				.getHandicapMarketBetValueLiteralPatternStrategyData().getOne()
				.equals("")) {
			String[] nombre = rtBet.getName().split(" ");
			if (handicapStrategyConfig
					.getHandicapMarketBetValueLiteralPatternStrategyData()
					.getDraw().equals(nombre[0])) {
				result.setResult(Result.DRAW);
			} else {
				if (pXmlData.getXmlMatchParticipant() != null) {
					if (pXmlData.getXmlMatchParticipant().isHomeParticipant()) {
						result.setResult(Result.ONE);
					} else if (pXmlData.getXmlMatchParticipant()
							.isAwayParticipant()) {
						result.setResult(Result.TWO);
					}
				}

			}
		} else {
			if (handicapStrategyConfig
					.getHandicapMarketBetValueLiteralPatternStrategyData()
					.getDraw().equals(rtBet.getName())) {
				result.setResult(Result.DRAW);
			} else if (handicapStrategyConfig
					.getHandicapMarketBetValueLiteralPatternStrategyData()
					.getOne().equals(rtBet.getName())) {
				result.setResult(Result.ONE);
			} else if (handicapStrategyConfig
					.getHandicapMarketBetValueLiteralPatternStrategyData()
					.getTwo().equals(rtBet.getName())) {
				result.setResult(Result.TWO);
			}
		}

		return result;
	}

	/**
	 * Draw pattern strategy.
	 * 
	 * @param pXmlData
	 *            the xml data
	 * @return the rt match result attribute
	 */
	private Rt1X2HandicapAttribute drawPatternStrategy(XmlMarketBet pXmlData,
			CfgBookmakerBetTypeStrategy1X2Handicap handicapStrategyConfig) {
		Rt1X2HandicapAttribute result = new Rt1X2HandicapAttribute();

		result.setEvent(this.getMatchEvent(pXmlData));

		String[] array = pXmlData.getName().split(" ");
		if (handicapStrategyConfig.getDrawPatternStrategyData().getDrawString()
				.equals(array[0])) {
			result.setResult(Result.DRAW);
			if (array.length > 1) {
				array[array.length - 1] = stringUtil
						.deleteParenthesis(array[array.length - 1]);
				result.setValue(Double.valueOf(stringUtil.deleteCharacter(
						array[array.length - 1], "+")));
			} else {
				if (StringUtils.isNotEmpty(pXmlData.getMarketBetValue())) {
					stringUtil.deleteCharacter(pXmlData.getMarketBetValue(),
							"+");
					result.setValue(Double.valueOf(pXmlData.getMarketBetValue()));
				}

			}

		} else {
			if (handicapStrategyConfig.getDrawPatternStrategyData()
					.getOneString().equals(array[0])) {
				result.setResult(Result.ONE);
				if (array.length > 1) {
					result.setValue(Double.valueOf(stringUtil.deleteCharacter(
							array[1], "+")));
				} else {
					if (StringUtils.isNotEmpty(pXmlData.getMarketBetValue())) {
						result.setValue(Double.valueOf(stringUtil
								.deleteCharacter(pXmlData.getMarketBetValue(),
										"+")));
					}
				}
			} else {
				result.setResult(Result.TWO);
				if (array.length > 1) {
					result.setValue(Double.valueOf(stringUtil.deleteCharacter(
							array[1], "+")));
				} else {
					if (StringUtils.isNotEmpty(pXmlData.getMarketBetValue())) {
						result.setValue(Double.valueOf(stringUtil
								.deleteCharacter(pXmlData.getMarketBetValue(),
										"+")));
					}
				}

			}
		}

		return result;
	}
}
