/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2HandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtAsianHandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMasMenosAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent.CfgBetTypeEventId;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.util.test.mongo.json.util.JSONUtil;
import com.mongodb.util.JSONParseException;

/**
 * The Class BookmakerPercentageFilterTest.
 */
public class BookmakerPercentageFilterTest extends AbstractValueBetFilterTest {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(BookmakerPercentageFilterTest.class);

	/** The bookmaker percentage filter. */
	@Resource(name = "bookmakerPercentageFilter")
	protected IFilterValueBet bookmakerPercentageFilter;

	/**
	 * Filter bets by bookmaker percentage test. El test carga 10 bookmakers
	 * activos en BD. El test setetea el valor quantityPercentBookmakers a 30
	 * (%). Esto significa que el filtro quitara todas las apuestas que
	 * contengan menos de 3 bookmakers. Se le pasa al filtro un RtMatch con los
	 * siguientes mercados:
	 * 
	 * Mercado 1: 1X2, Partido Completo con 3 bookmakers --> Se debería quedar
	 * 
	 * Mercado 2: 1X2, Primera Parte con 1 bookmaker --> Se debería borrar
	 * 
	 * Mercado 3: 12, Partido Completo con 2 bookmakers --> Se debería borrar
	 * 
	 * Mercado 4: Asian Handicap, Partido Completo:
	 * 
	 * (+0.0) con 3 bookmaker --> Se debería quedar; (+0.5) con 2 bookmakers -->
	 * Se debería borrar
	 * 
	 * Mercado 5: 1X2 Handicap, Partido Completo:
	 * 
	 * (+1) con 2 bookmakers --> Se debería borrar; (+2) con 2 bookmakers --> Se
	 * debería borrar; (-1) con 3 bookmakers --> Se debería quedar
	 * 
	 * Mercado 6: Mas/Menos, Primera Parte: (+0.5) con 2 bookmakers --> Se
	 * debería borrar; (+2.5) con 3 bookmakers --> Se debería quedar:
	 * 
	 */
	@Test
	public final void filterBookmakerPercentTest() {

		List<IDocument> matchsPOJO = new ArrayList<IDocument>();
		List<RtMatch> matchs = new ArrayList<RtMatch>();
		RtMatch originalMatch;
		RtMatch filteredMatch;

		dataConfiguration.setQuantityPercentBookmakers(30);

		try {
			matchsPOJO = JSONUtil.parseJSONToPOJO(RtMatch.class, getClass(),
					getAditionalNameForLoad(), mongoTemplate);
		} catch (JSONParseException e) {
			LOG.error("Test failure: ", e);
			fail("JSONParseException");
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
		matchs = bookmakerPercentageFilter.matchFilter(matchs);
		assertEquals(1, matchs.size());
		filteredMatch = matchs.get(0);

		// Comprobar estado filtrado
		// ***************************************************************
		assertEquals(4, filteredMatch.getRtMarkets().size());
		for (RtMarket market : filteredMatch.getRtMarkets()) {
			if (isMarketOfType(market, CfgBetTypeId.UNO_X_DOS,
					CfgBetTypeEventId.PARTIDO_COMPLETO)) {
				assertEquals(9, market.getBets().size());
			} else if (isMarketOfType(market, CfgBetTypeId.HANDICAP_ASIATICO,
					CfgBetTypeEventId.PARTIDO_COMPLETO)) {
				assertEquals(6, market.getBets().size());
				assertTrue(((RtAsianHandicapAttribute) market.getBets()
						.iterator().next().getAttribute()).getFirstValue()
						.equals(0.0));
			} else if (isMarketOfType(market, CfgBetTypeId.UNO_X_DOS_HANDICAP,
					CfgBetTypeEventId.PARTIDO_COMPLETO)) {
				assertEquals(9, market.getBets().size());
				assertTrue(((Rt1X2HandicapAttribute) market.getBets()
						.iterator().next().getAttribute()).getFirstValue()
						.equals(-1.0));
			} else if (isMarketOfType(market, CfgBetTypeId.MAS_MENOS,
					CfgBetTypeEventId.PRIMERA_PARTE)) {
				assertEquals(6, market.getBets().size());
				assertTrue(((RtMasMenosAttribute) market.getBets().iterator()
						.next().getAttribute()).getTotalGoalValue().equals(2.5));
			} else {
				fail("No se ha encontrado el mercado");
			}
		}

	}

}
