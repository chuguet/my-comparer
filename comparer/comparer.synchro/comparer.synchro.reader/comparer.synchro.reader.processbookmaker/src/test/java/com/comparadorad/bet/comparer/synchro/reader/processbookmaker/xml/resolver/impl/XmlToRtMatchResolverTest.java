/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.BetTypeBetClick;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.LongTerm;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlDate;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournamentEvent;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.BetBySportNotAllowedException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.util.TestUtil;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.bean.XmlToRtResolverData;

/**
 * The Class XmlToRtMarketResolverTest.
 */
public final class XmlToRtMatchResolverTest extends AbstractTest {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(XmlToRtMarketResolverTest.class);

	/** The match resolver. */
	@Inject
	private IXmlToRtMatchResolver matchResolver;

	/**
	 * Resolver market and bet.
	 * 
	 * @throws BetBySportNotAllowedException
	 */
	@Test
	public final void resolverMarketAndBet() throws BetBySportNotAllowedException {
		CfgBookmaker cfgBookmaker = this.setBookmaker();

		XmlToRtResolverData resolverData = new XmlToRtResolverData(cfgBookmaker);
		resolverData.setBetsNumber(2);

		TestUtil testUtil = new TestUtil();
		XmlMatch xmlMatch = testUtil.readXmlMatchFile("resolverMarketAndBet");
		LongTerm longTerm = new LongTerm();
		longTerm.setLongTerm(Boolean.FALSE);
		List<XmlMatchParticipant> lista = new ArrayList<XmlMatchParticipant>();
		XmlTournament torneo = new XmlTournament("Primera Liga");
		torneo.setCfgObjectId(new BigInteger("656935033"));
		XmlSport deporte = new XmlSport("Futbol");
		deporte.setCfgObjectId(new BigInteger("1"));
		torneo.setXmlSport(deporte);
		lista.add(new XmlMatchParticipant("Real Madrid", torneo));

		xmlMatch.getXmlTournamentEvent().setLongTerm(longTerm);
		// xmlMatch.getXmlTournament().setXmlSport(new XmlSport("Football"));
		xmlMatch.setXmlTournament(torneo);
		xmlMatch.setXmlMatchParticipants(lista);
		xmlMatch.setStartDate(new XmlDate(new Date()));
		for (XmlMarket market : xmlMatch.getXmlMarkets()) {
			market.getXmlBetType().setBetType(BetTypeBetClick.GANADOR);
			//Añado atributos de apuesta a las apuestas.
			for (XmlMarketBet bet : market.getXmlMarketBets()) {
				XmlWinnerAttribute atributo = new XmlWinnerAttribute();
				atributo.setWinner(new XmlMatchParticipant("Ganador", torneo));
				bet.setXmlAttribute(atributo);
				bet.setXmlMatchParticipant(new XmlMatchParticipant("Real Madrid", torneo));
			}
		}
		RtMatch rtMatch = matchResolver.resolve(xmlMatch, null, resolverData);
		assertNotNull(rtMatch);
		assertNotNull(rtMatch.getMatchId());
		assertNotNull(rtMatch.getRtMarkets());
		assertTrue(rtMatch.getCompetitionEvent().getLongTerm().getLongTerm().equals(Boolean.FALSE));
		for (RtMarket market : rtMatch.getRtMarkets()) {
			// assertNotNull(market.getBetType());
			for (RtBet bet : market.getBets()) {
				assertNotNull(bet);
				assertNotNull(bet.getBetOdd());
				assertEquals(bet.getBetOdd().getAmericanOdds(), "1.5");
				assertEquals(bet.getBetOdd().getFraOdds(), "1/5");
				assertEquals(bet.getBetOdd().getOdds(), "1");
			}
		}

	}

	/**
	 * Resolver market and bet.
	 * 
	 * @throws BetBySportNotAllowedException
	 */
	@Test
	public final void resolverMarketAndBetLongTerm() throws BetBySportNotAllowedException {
		CfgBookmaker cfgBookmaker = this.setBookmaker();

		XmlToRtResolverData resolverData = new XmlToRtResolverData(cfgBookmaker);
		resolverData.setBetsNumber(2);

		TestUtil testUtil = new TestUtil();
		XmlMatch xmlMatch = testUtil.readXmlMatchFile("resolverMarketAndBet");
		LongTerm longTerm = new LongTerm();
		longTerm.setLongTerm(Boolean.TRUE);

		List<XmlMatchParticipant> lista = new ArrayList<XmlMatchParticipant>();
		XmlTournament torneo = new XmlTournament("Primera Liga");
		torneo.setCfgObjectId(new BigInteger("656935033"));
		XmlSport deporte = new XmlSport("Futbol");
		deporte.setCfgObjectId(new BigInteger("1"));
		torneo.setXmlSport(deporte);
		lista.add(new XmlMatchParticipant("Real Madrid", torneo));

		// xmlMatch.getXmlTournament().setXmlSport(new XmlSport("Football"));
		xmlMatch.getXmlTournamentEvent().setLongTerm(longTerm);
		xmlMatch.setXmlTournament(torneo);
		xmlMatch.setXmlMatchParticipants(lista);
		xmlMatch.setStartDate(new XmlDate(new Date()));
		xmlMatch.setName("Nombre evento");
		for (XmlMarket market : xmlMatch.getXmlMarkets()) {
			market.getXmlBetType().setBetType(BetTypeBetClick.GANADOR);
			//Añado atributos de apuesta a las apuestas.
			for (XmlMarketBet bet : market.getXmlMarketBets()) {
				XmlWinnerAttribute atributo = new XmlWinnerAttribute();
				atributo.setWinner(new XmlMatchParticipant("Ganador", torneo));
				bet.setXmlAttribute(atributo);
				bet.setXmlMatchParticipant(new XmlMatchParticipant("Real Madrid", torneo));
			}
		}
		RtMatch rtMatch = matchResolver.resolve(xmlMatch, null, resolverData);
		assertNotNull(rtMatch);
		assertNotNull(rtMatch.getMatchId());
		assertNotNull(rtMatch.getRtMarkets());
		assertTrue(rtMatch.getCompetitionEvent().getLongTerm().getLongTerm().equals(Boolean.TRUE));
		for (RtMarket market : rtMatch.getRtMarkets()) {
			for (RtBet bet : market.getBets()) {
				assertNotNull(bet);
				assertNotNull(bet.getBetOdd());
				assertEquals(bet.getBetOdd().getAmericanOdds(), "1.5");
				assertEquals(bet.getBetOdd().getFraOdds(), "1/5");
				assertEquals(bet.getBetOdd().getOdds(), "1");
			}
		}
		assertNotNull(rtMatch.getName(null).equals("Nombre evento"));
	}

	/**
	 * Resolver market and bet and participant.
	 * 
	 * @throws BetBySportNotAllowedException
	 */
	@Test
	public final void resolverMarketAndBetAndParticipant() throws BetBySportNotAllowedException {
		CfgBookmaker cfgBookmaker = setBookmaker();
		XmlToRtResolverData resolverData = new XmlToRtResolverData(cfgBookmaker);

		TestUtil testUtil = new TestUtil();
		LongTerm longTerm = new LongTerm();
		longTerm.setLongTerm(Boolean.TRUE);
		XmlMatch xmlMatch = testUtil.readXmlMatchFile("resolverMarketAndBetAndParticipant");
		List<XmlMatchParticipant> lista = new ArrayList<XmlMatchParticipant>();
		XmlTournament torneo = new XmlTournament("Primera Liga");
		torneo.setCfgObjectId(new BigInteger("656935033"));
		XmlSport deporte = new XmlSport("Futbol");
		deporte.setCfgObjectId(new BigInteger("1"));
		torneo.setXmlSport(deporte);
		lista.add(new XmlMatchParticipant("Real Madrid", torneo));

		// xmlMatch.getXmlTournament().setXmlSport(new XmlSport("Football"));
		xmlMatch.setXmlTournament(torneo);
		xmlMatch.setStartDate(new XmlDate(new Date(), "GMT+1", new Date()));
		xmlMatch.getXmlTournamentEvent().setLongTerm(longTerm);
		xmlMatch.setXmlMatchParticipants(lista);

		for (XmlMarket market : xmlMatch.getXmlMarkets()) {
			market.getXmlBetType().setBetType(BetTypeBetClick.GANADOR);
			//Añado atributos de apuesta a las apuestas.
			for (XmlMarketBet bet : market.getXmlMarketBets()) {
				XmlWinnerAttribute atributo = new XmlWinnerAttribute();
				atributo.setWinner(new XmlMatchParticipant("Ganador", torneo));
				bet.setXmlAttribute(atributo);
				bet.setXmlMatchParticipant(new XmlMatchParticipant("Real Madrid", torneo));
			}
		}
		RtMatch rtMatch = matchResolver.resolve(xmlMatch, null, resolverData);
		assertNotNull(rtMatch);
		assertNotNull(rtMatch.getMatchId());
		assertNotNull(rtMatch.getMatchId().getParticipiants());
		assertTrue(rtMatch.getCompetitionEvent().getLongTerm().getLongTerm().equals(Boolean.TRUE));
		for (RtParticipant participant : rtMatch.getMatchId().getParticipiants()) {
			assertNotNull(participant);
		}

	}

	/**
	 * Tournament and sport not correct test.
	 * 
	 * @throws BetBySportNotAllowedException
	 * 
	 */
	@Test
	public final void tournamentAndSportNotCorrectTest() throws BetBySportNotAllowedException {
		XmlMatch xmlMatch = new XmlMatch();
		XmlTournament xmlTournament = new XmlTournament();
		XmlSport xmlSport = new XmlSport();
		xmlSport.setName("Baloncesto");
		xmlTournament.setName("Euro 2012");
		xmlMatch.setXmlTournament(xmlTournament);
		xmlTournament.setXmlSport(xmlSport);
		for (XmlMarket market : xmlMatch.getXmlMarkets()) {
			market.getXmlBetType().setBetType(BetTypeBetClick.GANADOR);
		}
		@SuppressWarnings("unused")
		RtMatch rtMatch = matchResolver.resolve(xmlMatch, null, null);
	}

	/**
	 * Resolver tournament test.
	 * 
	 * @throws BetBySportNotAllowedException
	 * 
	 */
	@Test
	public final void resolverTournamentTest() throws BetBySportNotAllowedException {
		CfgBookmaker cfgBookmaker = setBookmaker();

		XmlMatch xmlMatch = new XmlMatch();
		LongTerm longTerm = new LongTerm();
		longTerm.setLongTerm(Boolean.TRUE);
		XmlTournament xmlTournament = new XmlTournament();
		XmlToRtResolverData resolverData = new XmlToRtResolverData(cfgBookmaker);
		xmlTournament.setName("Euro 2012");
		xmlTournament.setXmlSport(new XmlSport("Football"));
		xmlMatch.setXmlTournamentEvent(new XmlTournamentEvent());
		xmlMatch.getXmlTournamentEvent().setLongTerm(longTerm);
		xmlMatch.setStartDate(new XmlDate(new Date(), "GMT+1", new Date()));
		xmlMatch.setXmlTournament(xmlTournament);
		for (XmlMarket market : xmlMatch.getXmlMarkets()) {
			market.getXmlBetType().setBetType(BetTypeBetClick.GANADOR);
		}
		RtMatch rtMatch = matchResolver.resolve(xmlMatch, null, resolverData);
		assertNotNull(rtMatch);
		assertEquals(rtMatch.getMatchId().getCompetition().getObjectId(), new BigInteger("2"));
		assertEquals(rtMatch.getHistoric().getHistoricList().size(), 1);
		assertEquals(rtMatch.getMatchId().getHistoric().getHistoricList().size(), 1);

	}

	/**
	 * Resolver team test.
	 * 
	 * @throws BetBySportNotAllowedException
	 * 
	 */
	@Test
	public final void resolverTeamTest() throws BetBySportNotAllowedException {

		CfgBookmaker cfgBookmaker = setBookmaker();
		XmlToRtResolverData resolverData = new XmlToRtResolverData(cfgBookmaker);

		TestUtil testUtil = new TestUtil();
		XmlMatch xmlMatch = testUtil.readXmlMatchFile("resolverTeamTest");
		LongTerm longTerm = new LongTerm();
		longTerm.setLongTerm(Boolean.TRUE);

		List<XmlMatchParticipant> lista = new ArrayList<XmlMatchParticipant>();
		XmlTournament torneo = new XmlTournament("Primera Liga");
		torneo.setCfgObjectId(new BigInteger("656935033"));
		XmlSport deporte = new XmlSport("Futbol");
		deporte.setCfgObjectId(new BigInteger("1"));
		torneo.setXmlSport(deporte);
		lista.add(new XmlMatchParticipant("Real Madrid", torneo));

		xmlMatch.setXmlTournamentEvent(new XmlTournamentEvent());
		// xmlMatch.getXmlTournament().setXmlSport(new XmlSport("Football"));
		xmlMatch.setXmlTournament(torneo);
		xmlMatch.getXmlTournamentEvent().setLongTerm(longTerm);
		xmlMatch.setStartDate(new XmlDate(new Date(), "GMT+1", new Date()));
		xmlMatch.setXmlMatchParticipants(lista);
		for (XmlMarket market : xmlMatch.getXmlMarkets()) {
			market.getXmlBetType().setBetType(BetTypeBetClick.GANADOR);
		}
		RtMatch rtMatch = matchResolver.resolve(xmlMatch, null, resolverData);

		assertNotNull(rtMatch);
		assertNotNull(rtMatch.getMatchId());
		assertEquals(rtMatch.getHistoric().getHistoricList().size(), 1);
		assertEquals(rtMatch.getMatchId().getHistoric().getHistoricList().size(), 1);

	}

	/**
	 * Resolver market.
	 * 
	 * @throws BetBySportNotAllowedException
	 * 
	 */
	@Test
	public final void resolverMarket() throws BetBySportNotAllowedException {
		CfgBookmaker cfgBookmaker = setBookmaker();
		XmlToRtResolverData resolverData = new XmlToRtResolverData(cfgBookmaker);
		resolverData.setBetsNumber(2);

		TestUtil testUtil = new TestUtil();
		XmlMatch xmlMatch = testUtil.readXmlMatchFile("resolverMarket");
		LongTerm longTerm = new LongTerm();
		longTerm.setLongTerm(Boolean.TRUE);

		List<XmlMatchParticipant> lista = new ArrayList<XmlMatchParticipant>();
		XmlTournament torneo = new XmlTournament("Primera Liga");
		torneo.setCfgObjectId(new BigInteger("656935033"));
		XmlSport deporte = new XmlSport("Futbol");
		deporte.setCfgObjectId(new BigInteger("1"));
		torneo.setXmlSport(deporte);
		lista.add(new XmlMatchParticipant("Real Madrid", torneo));
		xmlMatch.setXmlTournamentEvent(new XmlTournamentEvent());
		// xmlMatch.getXmlTournament().setXmlSport(new XmlSport("Football"));
		xmlMatch.getXmlTournamentEvent().setLongTerm(longTerm);
		xmlMatch.setStartDate(new XmlDate(new Date(), "GMT+1", new Date()));
		xmlMatch.setXmlTournament(torneo);
		xmlMatch.setXmlMatchParticipants(lista);
		for (XmlMarket market : xmlMatch.getXmlMarkets()) {
			market.getXmlBetType().setBetType(BetTypeBetClick.GANADOR);
		}
		RtMatch rtMatch = matchResolver.resolve(xmlMatch, null, resolverData);

		assertNotNull(rtMatch);
		assertNotNull(rtMatch.getMatchId());
		assertEquals(rtMatch.getHistoric().getHistoricList().size(), 1);
		assertEquals(rtMatch.getMatchId().getHistoric().getHistoricList().size(), 1);

	}

	/**
	 * Test que resuelve un evento con una apuesta para el deporte no permitida
	 * y que captura la excepcion de apuesta no permitida, la controla y termina
	 * correctamente no devolviendo el mercado correspondiente a la excepcion
	 */
	@Test
	public final void test_resolverMarket_excepcionBetNoPermitida() {
		CfgBookmaker cfgBookmaker = setBookmaker();
		XmlToRtResolverData resolverData = new XmlToRtResolverData(cfgBookmaker);
		resolverData.setBetsNumber(2);

		TestUtil testUtil = new TestUtil();
		XmlMatch xmlMatch = testUtil.readXmlMatchFile("resolverMarket");
		LongTerm longTerm = new LongTerm();
		longTerm.setLongTerm(Boolean.TRUE);

		List<XmlMatchParticipant> lista = new ArrayList<XmlMatchParticipant>();
		XmlTournament torneo = new XmlTournament("Roland Garros");
		torneo.setCfgObjectId(new BigInteger("656935033"));
		XmlSport deporte = new XmlSport("Tennis");
		deporte.setCfgObjectId(new BigInteger("1"));
		torneo.setXmlSport(deporte);
		lista.add(new XmlMatchParticipant("R. Federer", torneo));
		xmlMatch.setXmlTournamentEvent(new XmlTournamentEvent());
		xmlMatch.getXmlTournamentEvent().setLongTerm(longTerm);
		xmlMatch.setStartDate(new XmlDate(new Date(), "GMT+1", new Date()));
		xmlMatch.setXmlTournament(torneo);
		xmlMatch.setXmlMatchParticipants(lista);
		for (XmlMarket market : xmlMatch.getXmlMarkets()) {
			market.getXmlBetType().setBetType(BetTypeBetClick.UNO_X_DOS);
		}
		RtMatch rtMatch;
		try {
			rtMatch = matchResolver.resolve(xmlMatch, null, resolverData);
			assertTrue(rtMatch.getRtMarkets().size() == 0);
		} catch (BetBySportNotAllowedException e) {
			fail("El test no debe de dar una excepcion");
		}

	}

	/**
	 * All nulltest.
	 * 
	 */
	@Test
	public final void test() {
		RtMatch rtMatch;
		try {
			rtMatch = matchResolver.resolve(null, null, null);
			assertNotNull(rtMatch);
		} catch (BetBySportNotAllowedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
