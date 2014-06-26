/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bet;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.AbstractRtAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMasMenosAttribute;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerBetTypeStrategyMasMenos;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bean.StrategyData;

/**
 * The Class StrategyResolverGanadorPartido.
 */
@Component
public class StrategyResolverMasMenos extends AbstractStrategyResolver {

	/** The Constant NAME. */
	private static final String NAME = CfgBetTypeId.MAS_MENOS.nameId();

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
	 * @param pXmlData
	 *            the xml data
	 * @param rtBet
	 *            the rt bet
	 * @return the abstract rt attribute {@inheritDoc}
	 */

	@Override
	protected AbstractRtAttribute resolver(StrategyData pStrategyData,
			XmlMarketBet pXmlData, RtBet rtBet) {

		RtMasMenosAttribute atributo = new RtMasMenosAttribute();

		CfgBookmakerBetTypeStrategyMasMenos underOverStrategyConfig = (CfgBookmakerBetTypeStrategyMasMenos) pStrategyData
				.getBookmaker().getBookmakerConfiguration()
				.getBookmakerBetTypeStrategies()
				.get(CfgBookmakerBetTypeStrategyMasMenos.STRATEGY_ID);

		if (underOverStrategyConfig != null) {
			if (underOverStrategyConfig.isGoalsPatternStrategy()) {
				atributo = goalsPatternStrategy(pXmlData,
						underOverStrategyConfig);
			} else if (underOverStrategyConfig.isUnderOverLitteralStrategy()) {
				atributo = underOverLiteralPatternStrategy(pXmlData,
						underOverStrategyConfig);
			} else if (underOverStrategyConfig
					.isUnderOverMarketBetValueStrategy()) {
				atributo = underOverMarketBetValueLiteralPatternStrategy(
						pXmlData, underOverStrategyConfig, rtBet);
			} else if (underOverStrategyConfig
					.isUnderOverCombinedNameBetValueStrategy()) {
				atributo = underOverCombinedNameBetPatternStrategy(pXmlData,
						underOverStrategyConfig);
			}
		}

		return atributo;
	}

	/**
	 * Under over combined name bet pattern strategy.
	 * 
	 * @param pXmlData
	 *            the xml data
	 * @param underOverStrategyConfig
	 *            the under over strategy config
	 * @return the rt mas menos attribute
	 */
	private RtMasMenosAttribute underOverCombinedNameBetPatternStrategy(
			XmlMarketBet pXmlData,
			CfgBookmakerBetTypeStrategyMasMenos underOverStrategyConfig) {
		RtMasMenosAttribute atributo = new RtMasMenosAttribute();
		String valorApuesta;
		// Eliminamos la palabra
		if (pXmlData.getName().indexOf(
				underOverStrategyConfig.getOneTwoPatternStrategyData()
						.getTwoString()) != -1) {
			atributo.setMasMenos(MasMenos.MAS);
			valorApuesta = pXmlData.getName().replaceAll(
					underOverStrategyConfig.getOneTwoPatternStrategyData()
							.getTwoString(), "");
		} else {
			atributo.setMasMenos(MasMenos.MENOS);
			valorApuesta = pXmlData.getName().replaceAll(
					underOverStrategyConfig.getOneTwoPatternStrategyData()
							.getOneString(), "");
		}
		atributo.setTotalGoalValue(valorApuesta);

		return atributo;
	}

	/**
	 * Goals pattern strategy.
	 * 
	 * @param pXmlData
	 *            the xml data
	 * @param underOverStrategyConfig
	 *            the under over strategy config
	 * @return the rt under over attribute
	 */
	private RtMasMenosAttribute goalsPatternStrategy(XmlMarketBet pXmlData,
			CfgBookmakerBetTypeStrategyMasMenos underOverStrategyConfig) {
		RtMasMenosAttribute atributo = new RtMasMenosAttribute();

		String[] array = pXmlData.getName().split(" ");
		double resultado;
		if (pXmlData.getName().indexOf("No") != -1) {
			atributo.setTotalGoalValue("0.5");
			atributo.setMasMenos(MasMenos.MENOS);
		} else if (pXmlData.getName().indexOf("or more") != -1) {
			resultado = Double.valueOf(array[0]) - 0.5;
			atributo.setTotalGoalValue(String.valueOf(resultado));
			atributo.setMasMenos(MasMenos.MENOS);
		} else if (pXmlData.getName().indexOf("or less") != -1) {
			resultado = Double.valueOf(array[0]) + 0.5;
			atributo.setTotalGoalValue(String.valueOf(resultado));
			atributo.setMasMenos(MasMenos.MAS);
		} else if (pXmlData.getName().indexOf("-") != -1) {
			String[] subArray = array[0].split("-");
			resultado = Double.valueOf(subArray[1]) + 0.5;
			atributo.setTotalGoalValue(String.valueOf(resultado));
			atributo.setMasMenos(MasMenos.MENOS);
		}

		return atributo;
	}

	/**
	 * Under over literal pattern strategy.
	 * 
	 * @param pXmlData
	 *            the xml data
	 * @param underOverStrategyConfig
	 *            the under over strategy config
	 * @return the rt mas menos attribute
	 */
	private RtMasMenosAttribute underOverLiteralPatternStrategy(
			XmlMarketBet pXmlData,
			CfgBookmakerBetTypeStrategyMasMenos underOverStrategyConfig) {
		RtMasMenosAttribute atributo = new RtMasMenosAttribute();

		if (underOverStrategyConfig.getUnderOverLiteralPatternStrategy()
				.getUnder().equals(pXmlData.getName())) {
			atributo.setMasMenos(MasMenos.MENOS);
			atributo.setTotalGoalValue(pXmlData.getMarketBetValue());
		} else if (underOverStrategyConfig.getUnderOverLiteralPatternStrategy()
				.getOver().equals(pXmlData.getName())) {
			atributo.setMasMenos(MasMenos.MAS);
			atributo.setTotalGoalValue(pXmlData.getMarketBetValue());
		}

		return atributo;
	}

	/**
	 * Under over literal pattern strategy.
	 * 
	 * @param pXmlData
	 *            the xml data
	 * @param underOverStrategyConfig
	 *            the under over strategy config
	 * @param rtBet
	 *            the rt bet
	 * @return the rt mas menos attribute
	 */
	private RtMasMenosAttribute underOverMarketBetValueLiteralPatternStrategy(
			XmlMarketBet pXmlData,
			CfgBookmakerBetTypeStrategyMasMenos underOverStrategyConfig,
			RtBet rtBet) {
		RtMasMenosAttribute atributo = new RtMasMenosAttribute();

		if (rtBet.getName().indexOf(
				underOverStrategyConfig
						.getUnderOverMarketBetValueLiteralPatternStrategyData()
						.getUnder()) != -1) {
			atributo.setMasMenos(MasMenos.MENOS);
			atributo.setTotalGoalValue(pXmlData.getMarketBetValue());
		} else if (rtBet.getName().indexOf(
				underOverStrategyConfig
						.getUnderOverMarketBetValueLiteralPatternStrategyData()
						.getOver()) != -1) {
			atributo.setMasMenos(MasMenos.MAS);
			atributo.setTotalGoalValue(pXmlData.getMarketBetValue());
		}

		// if
		// (underOverStrategyConfig.getUnderOverMarketBetValueLiteralPatternStrategyData()
		// .getUnder().equals(rtBet.getName())) {
		// atributo.setMasMenos(MasMenos.MENOS);
		// atributo.setTotalGoalValue(pXmlData.getMarketBetValue());
		// } else if
		// (underOverStrategyConfig.getUnderOverMarketBetValueLiteralPatternStrategyData()
		// .getOver().equals(rtBet.getName())) {
		// atributo.setMasMenos(MasMenos.MAS);
		// atributo.setTotalGoalValue(pXmlData.getMarketBetValue());
		// }

		return atributo;
	}

}
