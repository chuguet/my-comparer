/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.util.test.mongo.json.util.JSONUtil;

/**
 * The Class NumBetFilterTest.
 */
public class NumBetFilterTest extends AbstractValueBetFilterTest {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(NumBetFilterTest.class);

	/** The num bet filter. */
	@Resource(name = "numBetFilter")
	protected IFilterValueBet numBetFilter;

	/**
	 * El test setetea el valor quantityLimitBet a 4. Esto significa que el
	 * filtro quitara todos los mercados que tengan menos de 4 bets. Se le pasa
	 * al filtro un RtMatch con los siguientes mercados:
	 * 
	 * Mercado 1: 1X2, Partido Completo con 9 bets --> Se debería quedar
	 * 
	 * Mercado 2: 1X2, Primera Parte con 3 bookmaker --> Se debería borrar
	 * 
	 * Mercado 3: 12, Partido Completo con 4 bets --> Se debería quedar
	 * 
	 * Mercado 4: Asian Handicap, Partido Completo con 10 bets --> Se debería
	 * quedar
	 * 
	 * Mercado 5: 1X2 Handicap, Partido Completo con 21 bets --> Se debería
	 * quedar
	 * 
	 * Mercado 6: Mas/Menos, Primera Parte con 10 bets --> Se debería quedar:
	 * 
	 */
	@Test
	public final void matchFilterTest() {

		List<IDocument> matchsPOJO = new ArrayList<IDocument>();
		List<RtMatch> matchs = new ArrayList<RtMatch>();
		RtMatch originalMatch;
		RtMatch filteredMatch;

		dataConfiguration.setQuantityLimitBets(4);

		try {
			matchsPOJO = JSONUtil.parseJSONToPOJO(RtMatch.class, getClass(),
					getAditionalNameForLoad(), mongoTemplate);
		} catch (IOException e) {
			LOG.error("Test failure: ", e);
			fail("IOException");
		}

		assertEquals(1, matchsPOJO.size());
		originalMatch = (RtMatch) matchsPOJO.get(0);

		// Comprobar estado inicial
		// ***************************************************************
		assertEquals(6, originalMatch.getRtMarkets().size());
		for (RtMarket market : originalMatch.getRtMarkets()) {
			if (isMarketOfType(market, CfgBetTypeId.UNO_X_DOS,
					CfgBetTypeEventId.PARTIDO_COMPLETO)) {
				assertEquals(9, market.getBets().size());
			} else if (isMarketOfType(market, CfgBetTypeId.UNO_X_DOS,
					CfgBetTypeEventId.PRIMERA_PARTE)) {
				assertEquals(3, market.getBets().size());
			} else if (isMarketOfType(market, CfgBetTypeId.GANADOR_PARTIDO,
					CfgBetTypeEventId.PARTIDO_COMPLETO)) {
				assertEquals(4, market.getBets().size());
			} else if (isMarketOfType(market, CfgBetTypeId.HANDICAP_ASIATICO,
					CfgBetTypeEventId.PARTIDO_COMPLETO)) {
				assertEquals(10, market.getBets().size());
			} else if (isMarketOfType(market, CfgBetTypeId.UNO_X_DOS_HANDICAP,
					CfgBetTypeEventId.PARTIDO_COMPLETO)) {
				assertEquals(21, market.getBets().size());
			} else if (isMarketOfType(market, CfgBetTypeId.MAS_MENOS,
					CfgBetTypeEventId.PRIMERA_PARTE)) {
				assertEquals(10, market.getBets().size());
			} else {
				fail("No se ha encontrado el mercado");
			}
		}

		matchs.add(originalMatch);
		matchs = numBetFilter.matchFilter(matchs);
		assertEquals(1, matchs.size());
		filteredMatch = matchs.get(0);

		// Comprobar estado filtrado
		// ***************************************************************
		assertEquals(5, filteredMatch.getRtMarkets().size());
		for (RtMarket market : filteredMatch.getRtMarkets()) {
			if (isMarketOfType(market, CfgBetTypeId.UNO_X_DOS,
					CfgBetTypeEventId.PARTIDO_COMPLETO)) {
				assertEquals(9, market.getBets().size());
			} else if (isMarketOfType(market, CfgBetTypeId.GANADOR_PARTIDO,
					CfgBetTypeEventId.PARTIDO_COMPLETO)) {
				assertEquals(4, market.getBets().size());
			} else if (isMarketOfType(market, CfgBetTypeId.HANDICAP_ASIATICO,
					CfgBetTypeEventId.PARTIDO_COMPLETO)) {
				assertEquals(10, market.getBets().size());
			} else if (isMarketOfType(market, CfgBetTypeId.UNO_X_DOS_HANDICAP,
					CfgBetTypeEventId.PARTIDO_COMPLETO)) {
				assertEquals(21, market.getBets().size());
			} else if (isMarketOfType(market, CfgBetTypeId.MAS_MENOS,
					CfgBetTypeEventId.PRIMERA_PARTE)) {
				assertEquals(10, market.getBets().size());
			} else {
				fail("No se ha encontrado el mercado");
			}
		}

	}

}
