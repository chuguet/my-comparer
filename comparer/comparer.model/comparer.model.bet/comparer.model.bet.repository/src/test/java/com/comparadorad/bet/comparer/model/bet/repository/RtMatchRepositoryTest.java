/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatchId;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.core.bean.I18n;
import com.comparadorad.bet.comparer.model.core.bean.I18nField;
import com.comparadorad.bet.comparer.model.core.repository.exception.ValidationObjectException;

/**
 * The Class RtMatchRepositoryTest.
 */
public class RtMatchRepositoryTest extends AbstractTest {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(RtMatchRepositoryTest.class);
	/** The rt match repository. */
	@Inject
	private RtMatchRepository rtMatchRepository;

	/**
	 * Gets the new element.
	 * 
	 * @return the new element {@inheritDoc}
	 * @throws ParseException
	 *             the parse exception
	 */
	protected RtMatch getNewElement() throws ParseException {
		RtMatch rtMatch = new RtMatch();
		RtMatchId rtMatchId = new RtMatchId();
		CfgCompetition competition = new CfgCompetition();
		competition.setObjectId(BigInteger.ONE);
		competition.setName("prueba");
		I18n i18 = new I18n();
		I18nField i18nField = new I18nField();
		i18nField.setString("Nombre a mostrar");
		i18.addI18nField(i18nField);
		rtMatch.setI18n(i18);
		rtMatch.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));
		competition.setI18n(i18);
		rtMatchId.setCompetition(competition);
		RtParticipant pParticipants = new RtParticipant();
		CoreDate coreDate = new CoreDate();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date date;
		date = dateFormat.parse("2014-12-10 10:10:00");

		Set<RtParticipant> participiants = new HashSet<RtParticipant>();
		coreDate.setZeroGmtMatchDate(date);
		coreDate.setProviderDate(date);

		coreDate.setProviderTimeZoneStr("GMT+1");

		pParticipants.setAwayParticipant(false);
		pParticipants.setHomeParticipant(false);
		participiants.add(pParticipants);

		rtMatchId.setParticipiants(participiants);
		rtMatchId.setStartDate(coreDate);

		rtMatch.setMatchId(rtMatchId);
		return rtMatch;
	}

	/**
	 * Test get matchs. Obtiene partidos de BD por competicion
	 */
	@Test
	public void testGetMatchs() {
		CfgCompetition competition = new CfgCompetition();
		competition.setName("Nombre a mostrar", null);
		competition.setObjectId(BigInteger.ONE);
		List<RtMatch> lstRtMatch;
		lstRtMatch = rtMatchRepository.getCompetitionMatchs(competition);
		assertNotNull(lstRtMatch);
		assertTrue(lstRtMatch.size() > 0);
		assertTrue(lstRtMatch.get(1).getName(null)
				.equals("Atletico de Madrid Vs Malaga"));
		assertTrue(lstRtMatch.get(0).getStartDate().getZeroGmtMatchDate() != null);
		for (RtMarket rtMarket : lstRtMatch.get(0).getRtMarkets()) {
			assertNotNull(rtMarket);
			for (RtBet rtBet : rtMarket.getBets()) {
				assertNotNull(rtBet);
			}
		}
	}
	
	
	/**
	 * Test que comprueb que entre todos los partidos devuelve siempre uno que
	 * está activo.
	 */
	@Test
	public void testFindActiveMatch() {
		RtMatch result = rtMatchRepository.findActiveMatch("1", "1");
		assertTrue(result != null);
		assertTrue(result.isActive(new Date()));
	}
	

	/**
	 * Test save with errors. Devuelve errores de validacion
	 */
	@Test
	public void testSaveWithErrorsAll() {
		try {
			RtMatch rtMatch = new RtMatch();
			rtMatchRepository.save(rtMatch);
			// fail("The save must fail");
		} catch (ValidationObjectException e) {
			LOG.info(e.getMessage());
		}
	}

	/**
	 * Test save with errors hashkey. Error por no existir hashkey
	 * 
	 * @throws ParseException
	 *             the parse exception
	 */
	@Test
	public void testSaveWithErrorsHashkey() throws ParseException {
		RtMatch rtMatch = (RtMatch) getNewElement();
		rtMatch.setHashKey(null);

		try {
			rtMatchRepository.save(rtMatch);
			// fail("The save must fail");
		} catch (ValidationObjectException e) {
			LOG.info(e.getMessage());
		}
	}

	/**
	 * Test save with errors match id. Error por no existir MatchId
	 * 
	 * @throws ParseException
	 */
	@Test
	public void testSaveWithErrorsMatchId() throws ParseException {
		RtMatch rtMatch = (RtMatch) getNewElement();
		rtMatch.setMatchId(null);

		try {
			rtMatchRepository.save(rtMatch);
			// fail("The save must fail");
		} catch (ValidationObjectException e) {
			LOG.info(e.getMessage());
		}
	}

	/**
	 * Test save with errors match id competition. Error por no existir
	 * competicion.
	 * 
	 * @throws ParseException
	 */
	@Test
	public void testSaveWithErrorsMatchIdCompetition() throws ParseException {
		RtMatch rtMatch = (RtMatch) getNewElement();
		rtMatch.getMatchId().setCompetition(null);

		try {
			rtMatchRepository.save(rtMatch);
			// fail("The save must fail");
		} catch (ValidationObjectException e) {
			LOG.info(e.getMessage());
		}
	}

	/**
	 * Test save with errorsi18n. Error por no existir i18n
	 * 
	 * @throws ParseException
	 */
	@Test
	public void testSaveWithErrorsi18n() throws ParseException {
		RtMatch rtMatch = (RtMatch) getNewElement();
		rtMatch.setI18n(null);

		try {
			rtMatchRepository.save(rtMatch);
			// fail("The save must fail");
		} catch (ValidationObjectException e) {
			LOG.info(e.getMessage());
		}
	}
	
	/**
	 * Gets the num matchs by competition.
	 * 
	 * @return the num matchs by competition
	 */
	@Test
	public void getNumMatchsByCompetition() {
		CfgCompetition competition = new CfgCompetition();
		competition.setName("Nombre a mostrar", null);
		competition.setObjectId(BigInteger.ONE);
		Long result = rtMatchRepository.getNumMatchsByCompetition(competition,
				"1");
		assertNotNull(result);
		assertEquals(competition.getName(null), "Nombre a mostrar");
		assertTrue(result > 0);
	}
	
	/**
	 * Gets the matchs by bet type and competition.
	 * 
	 * @return the matchs by bet type and competition
	 */
	@Test
	public void getMatchsByBetTypeAndCompetition() {
		List<RtMatch> result = rtMatchRepository
				.getMatchsByBetTypeAndCompetition(new BigInteger("1"),
						new BigInteger("3"));

		for (RtMarket rtMarket : result.get(0).getRtMarkets()) {
			assertNotNull(rtMarket);
			for (RtBet rtBet : rtMarket.getBets()) {
				assertNotNull(rtBet);
			}
		}
		assertEquals(result.get(0).getCompetition().getObjectId(),
				new BigInteger("1"));
	}
	
	/**
	 * Gets the rt match by competition and competition event.
	 * 
	 * @return the rt match by competition and competition event
	 */
	@Test
	public void getRtMatchByCompetitionAndCompetitionEvent() {
		List<RtMatch> result = rtMatchRepository
				.getRtMatchByCompetitionAndCompetitionEvent(
						new BigInteger("3"), new BigInteger("2"));

		assertNotNull(result);
		for (RtMatch match : result) {
			assertEquals(match.getCompetition().getObjectId(), new BigInteger(
					"3"));
			assertEquals(match.getCompetitionEvent().getObjectId(),
					new BigInteger("2"));
		}
	}
	
	/**
	 * Gets the competition matchs.
	 * 
	 * @return the competition matchs
	 */
	@Test
	public void getCompetitionMatchs() {
		CfgCompetition competition = new CfgCompetition();
		competition.setName("Nombre a mostrar", null);
		competition.setObjectId(BigInteger.ONE);
		List<RtMatch> result = rtMatchRepository
				.getCompetitionMatchs(competition);

		assertNotNull(result);
		assertEquals(competition.getName(null), "Nombre a mostrar");
		assertTrue(result.size() > 0);
	}



	/**
	 * Gets the bet types competition matchs.
	 * 
	 * @return the bet types competition matchs
	 */
	@Test
	public void getBetTypesCompetitionMatchs() {
		CfgCompetition competition = new CfgCompetition();
		competition.setName("Nombre a mostrar", null);
		competition.setObjectId(BigInteger.ONE);
		List<RtMatch> result = rtMatchRepository
				.getBetTypesCompetitionMatchs(competition);

		assertNotNull(result);
		assertEquals(competition.getName(null), "Nombre a mostrar");
	}

	// @SuppressWarnings("deprecation")
	// @Test
	// public void getUpcomingEventsForSureBet() {// como el que tiene tos y se
	// // rasca los...
	// Date today = new Date();
	// Date limit = new Date();
	// limit.setDate(17);
	// limit.setMonth(3);
	// limit.setYear(2222);
	// limit.setHours(7);
	// limit.setMinutes(15);
	// limit.setSeconds(22);
	// List<RtMatch> result = rtMatchRepository.getUpcomingEventsForSureBet(
	// today, limit);
	//
	// assertNotNull(result);
	// for (RtMatch event : result) {
	// assertTrue(event.getStartDate().getZeroGmtMatchDate().after(today));
	// }
	// assertEquals(result.size(), 7);
	// }
	
	/**
	 * Gets the matchs by hash keys test.
	 * 
	 * @return the matchs by hash keys test
	 */
	@Test
	public void getMatchsByHashKeysTest() {
		List<RtMatch> rtMatchs;
		rtMatchs = rtMatchRepository.getMatchsByHashKeys("1haskey");
		assertNotNull(rtMatchs);
		assertEquals(rtMatchs.get(0).contains("1haskey"), true);
	}

	/**
	 * Gets the matchs by competition map reduce.
	 * 
	 * @return the matchs by competition map reduce
	 */
	@Test
	public void getMatchsByCompetitionMapReduce() {
		List<RtMatch> result;
		result = rtMatchRepository.mapReduceGetMatchsByCompetition(
				new BigInteger("48"), "1", "1", "1");
		//F assertEquals(result.size(), 21);
		assertEquals(result.size(), 1);
		for (RtMatch match : result) {
			assertEquals(match.getRtMarkets().size(), 1);
			assertEquals(match.getRtMarkets().iterator().next().getBetType()
					.getObjectId().toString(), "1");
			assertEquals(match.getRtMarkets().iterator().next()
					.getBetTypeEvent().getBetTypeEvent().getObjectId()
					.toString(), "1");
			assertEquals(match.getMatchId().getCompetition().getObjectId()
					.toString(), "48");
		}
	}
	
//	@Test
//	public void test_getUpcomingEvents() {
//		
//		try {
//			List<RtMatch> result;
//			 CoreDate userCoreDate = new CoreDate(); 
//			String userDate = "27/06/2013 09:59:00";
//			 SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
//			 dt.setTimeZone(TimeZone.getTimeZone("GMT_0"));
//			 Date uDate = dt.parse(userDate);
//			 userCoreDate.setZeroGmtMatchDate(uDate);
//			 String limitDate = "15/12/2050 7:35:41";
//			 Date dlimit;
//			dlimit = dt.parse(limitDate);
//			Date inicio = new Date();
//			System.out.println("Empieza la prueba con un tiempo de :" + inicio.getTime());
//			result = rtMatchRepository.getUpcomingEvents(userCoreDate.getZeroGmtMatchDate(), dlimit, 6);
//			Date fin = new Date();
//			System.out.println("Empieza la prueba con un tiempo de :" + fin.getTime());
//			System.out.println(result.size());
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void removeBetsByUpdateDateTest(){
		RtMatch matchIn;
		RtMatch matchOut;
		matchIn = rtMatchRepository.findAll().get(0);
		matchOut = rtMatchRepository.removeBetsByUpdateDate(matchIn, new Date());
		if( matchIn.equals(matchOut) ){
			
		}
	}
}
