/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigInteger;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBetClick;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlBetType;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.BetBySportNotAllowedException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.bean.XmlToRtResolverData;

/**
 * The Class XmlToRtMarketResolverTest.
 */
public final class XmlToRtMarketResolverTest extends AbstractTest {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(XmlToRtMarketResolverTest.class);

	/** The xml to rt market resolver. */
	@Inject
	private IXmlToRtMarketResolver xmlToRtMarketResolver;

	/**
	 * All nulltest.
	 * 
	 */
	@Test
	public final void allNullTest() {
		RtMarket rtMarket;
		try {
			rtMarket = xmlToRtMarketResolver.resolve(null, null, null);
			assertNotNull(rtMarket);
		} catch (BetBySportNotAllowedException e) {
			fail("El test no debe de producir ninguna excepcion");
		}

	}

	/**
	 * Test.
	 * 
	 */
	@Test
	public final void test() {

		try {
			XmlMarket xmlMarket = new XmlMarket();
			CfgBookmaker cfgBookmaker = setBookmaker();
			cfgBookmaker.setObjectId(BigInteger.ONE);
			xmlMarket.setXmlBetType(new XmlBetType(BetTypeBetClick.GANADOR));
			CfgSport sport = new CfgSport("1");
			sport.setName("Football");
			CfgCompetition competition = new CfgCompetition("300000");
			competition.setSport(sport);
			RtMatch match = new RtMatch();
			match.setCompetition(competition);
			XmlToRtResolverData resolverData = new XmlToRtResolverData(cfgBookmaker);
			resolverData.setMatch(match);
			RtMarket rtMarket;
			rtMarket = xmlToRtMarketResolver.resolve(xmlMarket, null, resolverData);
			assertNotNull(rtMarket);
		} catch (BetBySportNotAllowedException e) {
			fail("El test no debe de producir ninguna excepcion");
		}

	}

	/**
	 * Testea para un determinado deporte que la apuesta este configurada y sea
	 * permitida, termina correctamente con un market bien procesado.
	 * 
	 */
	@Test
	public void test_apuestasPorDeporte_ok() {

		try {
			XmlMarket xmlMarket = new XmlMarket();
			CfgBookmaker cfgBookmaker = setBookmaker();
			cfgBookmaker.setObjectId(BigInteger.ONE);
			xmlMarket.setXmlBetType(new XmlBetType(BetTypeBetClick.GANADOR_PARTIDO));
			CfgSport sport = new CfgSport("1");
			sport.setName("Football");
			CfgCompetition competition = new CfgCompetition("300000");
			competition.setSport(sport);
			RtMatch match = new RtMatch();
			match.setCompetition(competition);

			XmlToRtResolverData resolverData = new XmlToRtResolverData(cfgBookmaker);
			resolverData.setMatch(match);

			RtMarket rtMarket;
			rtMarket = xmlToRtMarketResolver.resolve(xmlMarket, null, resolverData);
			assertNotNull(rtMarket);
		} catch (BetBySportNotAllowedException e) {
			fail("El test no debe de producir ninguna excepcion");
		}

	}

	/**
	 * Testea para un determinado deporte que la apuesta no este entre las
	 * permitidas para dicho deporte y lanza una excepcion de tipo apuesta
	 * desactivada.
	 * 
	 */
	@SuppressWarnings("unused")
	@Test
	public void test_apuestasPorDeporte_excepcionApuestaDesactivada() {
		try {
			XmlMarket xmlMarket = new XmlMarket();
			CfgBookmaker cfgBookmaker = setBookmaker();
			cfgBookmaker.setObjectId(BigInteger.ONE);
			xmlMarket.setXmlBetType(new XmlBetType(BetTypeBetClick.UNO_X_DOS));
			CfgSport sport = new CfgSport("3");
			sport.setName("Tennis");
			CfgCompetition competition = new CfgCompetition("300000");
			competition.setSport(sport);
			RtMatch match = new RtMatch();
			match.setCompetition(competition);

			XmlToRtResolverData resolverData = new XmlToRtResolverData(cfgBookmaker);
			resolverData.setMatch(match);
			RtMarket rtMarket = xmlToRtMarketResolver.resolve(xmlMarket, null, resolverData);
			fail ("El test debe de producir una excepcion controlada");
		} catch (Exception e) {
			LOG.info("Excepcion controlada");
			assertTrue(e.getClass() == BetBySportNotAllowedException.class);
		}

	}

}
