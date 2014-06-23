/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean.hashkey;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.AbstractBetBeanTest;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatchId;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.config.bean.LongTerm;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;

/**
 * The Class HashKeyRtMatchTest.
 */
public class HashKeyRtMatchTest extends AbstractBetBeanTest {

	private static final SimpleDateFormat FORMATTER_DATE_TIME = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static final SimpleDateFormat FORMATTER_DATE = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * Bug3189.
	 * @throws ParseException 
	 */
	@Test
	public void bug3189() throws ParseException {

		// Match1
		RtMatch match1 = new RtMatch();
		RtMatchId matchId1 = new RtMatchId();
		CfgSport deporte = new CfgSport(new BigInteger("1"));
		match1.setLive(false);
		matchId1.setStartDate(new CoreDate(FORMATTER_DATE_TIME.parse("29/05/2013 02:30:00"),
				"GMT+1", FORMATTER_DATE_TIME.parse("29/05/2013 01:30:00")));
		CfgCompetition competition1 = new CfgCompetition();
		competition1.setObjectId(new BigInteger("713950301"));
		competition1.setSport(deporte);
		match1.setCompetition(competition1);
		matchId1.setCompetition(competition1);
		CfgCompetitionEvent competitionEvent1 = new CfgCompetitionEvent();
		competitionEvent1.setObjectId(new BigInteger("1"));

		RtParticipant participante1 = new RtParticipant();
		CfgParticipant participant1 = new CfgParticipant(new BigInteger(
				("624965563")));
		participante1.setAwayParticipant(true);
		participante1.setHomeParticipant(false);
		participante1.setCfgParticipant(participant1);

		RtParticipant participante12 = new RtParticipant();
		CfgParticipant participant12 = new CfgParticipant(new BigInteger(
				("578275501")));
		participante12.setAwayParticipant(false);
		participante12.setHomeParticipant(true);
		participante12.setCfgParticipant(participant12);
		matchId1.addParticipiant(participante1);
		matchId1.addParticipiant(participante12);
		matchId1.setCompetitionEvent(competitionEvent1);
		match1.setMatchId(matchId1);

		match1.setName("Rosario Central vs Aldosivi");
		match1.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));

		String match1Hash = match1.getAbstractKey().getHashKey();

		// Match2
		RtMatch match2 = new RtMatch();
		RtMatchId matchId2 = new RtMatchId();
		match2.setLive(false);
		matchId2.setStartDate(new CoreDate(FORMATTER_DATE_TIME.parse("29/05/2013 02:30:00"),
				"GMT+1", FORMATTER_DATE_TIME.parse("29/05/2013 01:30:00")));
		CfgCompetition competition2 = new CfgCompetition();
		competition2.setObjectId(new BigInteger("713950301"));
		competition2.setSport(deporte);
		match2.setCompetition(competition2);
		matchId2.setCompetition(competition1);
		CfgCompetitionEvent competitionEvent2 = new CfgCompetitionEvent();
		competitionEvent2.setObjectId(new BigInteger("1"));

		RtParticipant participante2 = new RtParticipant();
		CfgParticipant participant2 = new CfgParticipant(new BigInteger(
				("624965563")));
		participante2.setAwayParticipant(true);
		participante2.setHomeParticipant(false);
		participante2.setCfgParticipant(participant2);

		RtParticipant participante21 = new RtParticipant();
		CfgParticipant participant21 = new CfgParticipant(new BigInteger(
				("578275501")));
		participante21.setAwayParticipant(false);
		participante21.setHomeParticipant(true);
		participante21.setCfgParticipant(participant21);
		matchId2.addParticipiant(participante2);
		matchId2.addParticipiant(participante21);
		matchId2.setCompetitionEvent(competitionEvent2);
		match2.setMatchId(matchId2);

		match2.setName("Rosario Central vs Aldosivi");
		match2.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));

		String match2Hash = match2.getAbstractKey().getHashKey();

		assertEquals(match1Hash, match2Hash);

	}

	/**
	 * Test.
	 * 
	 * {@inheritDoc}
	 */

	@Override
	public final void test() {
		RtMatch match = new RtMatch();
		assertNotNull(match.getAbstractKey());
		assertEquals(match.getAbstractKey().getHashKey(), "");
	}

	/**
	 * Test different order participant.
	 */
	@Test
	public final void testDifferentOrderParticipant() {
		String firstHash;
		String secondHash;
		RtMatch match = new RtMatch();
		RtMatch rtMatch = new RtMatch();
		CfgCompetition cfgCompetition = new CfgCompetition();
		CfgParticipant cfgParticipant = new CfgParticipant();
		CfgParticipant team = new CfgParticipant();
		RtParticipant rtParticipant = new RtParticipant();
		RtParticipant rtTeam = new RtParticipant();
		RtMatchId matchId = new RtMatchId();
		CoreDate coreDate = new CoreDate();
		LongTerm longTerm = new LongTerm();
		longTerm.setLongTerm(Boolean.FALSE);
		CfgCompetitionEvent competitionEvent = new CfgCompetitionEvent();
		competitionEvent.setLongTerm(longTerm);

		cfgCompetition.setObjectId(BigInteger.ONE);
		CfgSport sport = new CfgSport(new BigInteger("1"));
		sport.setHashKeyParticipants(Boolean.TRUE);
		cfgCompetition.setSport(sport);
		cfgParticipant.setObjectId(BigInteger.TEN);
		team.setObjectId(BigInteger.ONE);
		rtTeam.setCfgParticipant(team);
		rtParticipant.setCfgParticipant(cfgParticipant);
		matchId.setCompetition(cfgCompetition);
		matchId.setCompetitionEvent(competitionEvent);
		matchId.addParticipiant(rtParticipant);
		matchId.addParticipiant(rtTeam);
		coreDate.setZeroGmtMatchDate(new Date());
		matchId.setStartDate(coreDate);
		match.setMatchId(matchId);

		firstHash = match.getAbstractKey().getHashKey();

		matchId.setParticipiants(null);
		matchId.addParticipiant(rtTeam);
		matchId.addParticipiant(rtParticipant);
		rtMatch.setMatchId(matchId);

		secondHash = rtMatch.getAbstractKey().getHashKey();

		assertEquals(firstHash, secondHash);
		assertNotSame(firstHash, "");
		assertNotSame(secondHash, "");

	}

	/**
	 * Test equal rt match new hash key.
	 * @throws ParseException 
	 */
	@Test
	public final void testEqualRtMatchNewHashKey() throws ParseException {
		RtMatch m1 = new RtMatch();
		RtMatch m2 = new RtMatch();
		RtMatchId matchid1 = new RtMatchId();
		RtMatchId matchid2 = new RtMatchId();

		CfgCompetition cfgCompetition = new CfgCompetition(new BigInteger("1"));
		CfgSport cfgSport = new CfgSport(new BigInteger("2"));
		cfgSport.setHashKeyParticipants(Boolean.TRUE);
		cfgCompetition.setSport(cfgSport);
		CfgCompetitionEvent cfgCompetitionEvent = new CfgCompetitionEvent();
		cfgCompetitionEvent.setObjectId(new BigInteger("1"));
		LongTerm lt = new LongTerm();
		lt.setLongTerm(true);
		cfgCompetitionEvent.setLongTerm(lt);

		matchid1.setCompetition(cfgCompetition);
		matchid2.setCompetition(cfgCompetition);
		matchid1.setCompetitionEvent(cfgCompetitionEvent);
		matchid2.setCompetitionEvent(cfgCompetitionEvent);

		RtParticipant rtParticipant = new RtParticipant();
		CfgParticipant cfgParticipant = new CfgParticipant();
		cfgParticipant.setObjectId(BigInteger.TEN);
		rtParticipant.setCfgParticipant(cfgParticipant);

		matchid1.addParticipiant(rtParticipant);
		matchid2.addParticipiant(rtParticipant);

		CoreDate coreDate1 = new CoreDate();
		coreDate1.setZeroGmtMatchDate(FORMATTER_DATE.parse("13/05/2013"));

		CoreDate coreDate2 = new CoreDate();
		coreDate2.setZeroGmtMatchDate(FORMATTER_DATE.parse("13/05/2013"));

		matchid1.setStartDate(coreDate1);
		matchid2.setStartDate(coreDate2);

		m1.setMatchId(matchid1);
		m2.setMatchId(matchid2);

		String firstHash = m1.getAbstractKey().getHashKey();
		String secondHash = m2.getAbstractKey().getHashKey();

		assertEquals(firstHash, secondHash);
	}

	/**
	 * Test two different.
	 */
	@Test
	public final void testTwoDifferent() {
		String firstHash;
		String secondHash;
		RtMatch match = new RtMatch();
		CfgCompetition cfgCompetition = new CfgCompetition();
		CfgParticipant cfgParticipant = new CfgParticipant();
		CfgParticipant team = new CfgParticipant();
		RtParticipant rtParticipant = new RtParticipant();
		RtParticipant rtTeam = new RtParticipant();
		RtMatchId matchId = new RtMatchId();
		CoreDate coreDate = new CoreDate();
		LongTerm longTerm = new LongTerm();
		longTerm.setLongTerm(Boolean.FALSE);
		CfgCompetitionEvent competitionEvent = new CfgCompetitionEvent();
		competitionEvent.setLongTerm(longTerm);

		cfgCompetition.setObjectId(BigInteger.ONE);
		CfgSport sport = new CfgSport(new BigInteger("1"));
		sport.setHashKeyParticipants(Boolean.TRUE);
		cfgCompetition.setSport(sport);
		cfgParticipant.setObjectId(BigInteger.ONE);
		team.setObjectId(BigInteger.ONE);
		rtTeam.setCfgParticipant(team);
		rtParticipant.setCfgParticipant(cfgParticipant);
		matchId.setCompetition(cfgCompetition);
		matchId.setCompetitionEvent(competitionEvent);
		matchId.addParticipiant(rtParticipant);
		matchId.addParticipiant(rtTeam);
		coreDate.setZeroGmtMatchDate(new Date());
		matchId.setStartDate(coreDate);
		match.setMatchId(matchId);

		firstHash = match.getAbstractKey().getHashKey();

		coreDate.setZeroGmtMatchDate(new Date());
		matchId.setStartDate(coreDate);
		longTerm.setLongTerm(Boolean.TRUE);
		competitionEvent.setLongTerm(longTerm);
		matchId.setCompetitionEvent(competitionEvent);
		match.setMatchId(matchId);

		secondHash = match.getAbstractKey().getHashKey();

		assertTrue(!firstHash.equalsIgnoreCase(secondHash));
		assertNotSame(firstHash, "");
		assertNotSame(secondHash, "");

	}

	/**
	 * Test two different no participants.
	 */
	@Test
	public final void testTwoDifferentNoParticipants() {
		String firstHash;
		String secondHash;
		RtMatch match = new RtMatch();
		CfgCompetition cfgCompetition = new CfgCompetition();
		CfgParticipant cfgParticipant = new CfgParticipant();
		CfgParticipant team = new CfgParticipant();
		RtParticipant rtParticipant = new RtParticipant();
		RtParticipant rtTeam = new RtParticipant();
		RtMatchId matchId = new RtMatchId();
		CoreDate coreDate = new CoreDate();
		LongTerm longTerm = new LongTerm();
		longTerm.setLongTerm(Boolean.FALSE);
		CfgCompetitionEvent competitionEvent = new CfgCompetitionEvent();
		competitionEvent.setLongTerm(longTerm);

		cfgCompetition.setObjectId(BigInteger.ONE);
		CfgSport sport = new CfgSport(new BigInteger("14"));
		sport.setHashKeyParticipants(Boolean.TRUE);
		cfgCompetition.setSport(sport);
		cfgParticipant.setObjectId(BigInteger.ONE);
		team.setObjectId(BigInteger.ONE);
		rtTeam.setCfgParticipant(team);
		rtParticipant.setCfgParticipant(cfgParticipant);
		matchId.setCompetition(cfgCompetition);
		matchId.setCompetitionEvent(competitionEvent);
		matchId.addParticipiant(rtParticipant);
		matchId.addParticipiant(rtTeam);
		coreDate.setZeroGmtMatchDate(new Date());
		matchId.setStartDate(coreDate);
		match.setMatchId(matchId);

		firstHash = match.getAbstractKey().getHashKey();

		coreDate.setZeroGmtMatchDate(new Date());
		matchId.setStartDate(coreDate);
		longTerm.setLongTerm(Boolean.TRUE);
		competitionEvent.setLongTerm(longTerm);
		matchId.setCompetitionEvent(competitionEvent);
		match.setMatchId(matchId);

		secondHash = match.getAbstractKey().getHashKey();

		assertTrue(!firstHash.equalsIgnoreCase(secondHash));
		assertNotSame(firstHash, "");
		assertNotSame(secondHash, "");

	}

	/**
	 * Test two equal.
	 */
	@Test
	public final void testTwoEqual() {
		String firstHash;
		String secondHash;
		RtMatch match = new RtMatch();
		RtMatch rtMatch = new RtMatch();
		CfgCompetition cfgCompetition = new CfgCompetition();
		CfgParticipant cfgParticipant = new CfgParticipant();
		CfgParticipant team = new CfgParticipant();
		RtParticipant rtParticipant = new RtParticipant();
		RtParticipant rtTeam = new RtParticipant();
		RtMatchId matchId = new RtMatchId();
		CoreDate coreDate = new CoreDate();
		LongTerm longTerm = new LongTerm();
		longTerm.setLongTerm(Boolean.FALSE);
		CfgCompetitionEvent competitionEvent = new CfgCompetitionEvent();
		competitionEvent.setLongTerm(longTerm);
		CfgSport sport = new CfgSport(new BigInteger("1"));
		sport.setHashKeyParticipants(Boolean.TRUE);
		cfgCompetition.setObjectId(BigInteger.ONE);
		cfgCompetition.setSport(sport);
		cfgParticipant.setObjectId(BigInteger.ONE);
		team.setObjectId(BigInteger.ONE);
		rtTeam.setCfgParticipant(team);
		rtParticipant.setCfgParticipant(cfgParticipant);
		matchId.setCompetition(cfgCompetition);
		matchId.setCompetitionEvent(competitionEvent);
		matchId.addParticipiant(rtParticipant);
		matchId.addParticipiant(rtTeam);
		coreDate.setZeroGmtMatchDate(new Date());
		matchId.setStartDate(coreDate);
		match.setMatchId(matchId);

		firstHash = match.getAbstractKey().getHashKey();

		rtMatch.setMatchId(matchId);

		secondHash = rtMatch.getAbstractKey().getHashKey();

		assertEquals(firstHash, secondHash);
		assertNotSame(firstHash, "");
		assertNotSame(secondHash, "");

	}

	/**
	 * Test two equal no participants.
	 */
	@Test
	public final void testTwoEqualNoParticipants() {
		String firstHash;
		String secondHash;
		RtMatch match = new RtMatch();
		RtMatch rtMatch = new RtMatch();
		CfgCompetition cfgCompetition = new CfgCompetition();
		CfgParticipant cfgParticipant = new CfgParticipant();
		CfgParticipant team = new CfgParticipant();
		RtParticipant rtParticipant = new RtParticipant();
		RtParticipant rtTeam = new RtParticipant();
		RtMatchId matchId = new RtMatchId();
		CoreDate coreDate = new CoreDate();
		LongTerm longTerm = new LongTerm();
		longTerm.setLongTerm(Boolean.FALSE);
		CfgCompetitionEvent competitionEvent = new CfgCompetitionEvent();
		competitionEvent.setLongTerm(longTerm);
		CfgSport sport = new CfgSport(new BigInteger("14"));
		sport.setHashKeyParticipants(Boolean.TRUE);
		cfgCompetition.setObjectId(BigInteger.ONE);
		cfgCompetition.setSport(sport);
		cfgParticipant.setObjectId(BigInteger.ONE);
		team.setObjectId(BigInteger.ONE);
		rtTeam.setCfgParticipant(team);
		rtParticipant.setCfgParticipant(cfgParticipant);
		matchId.setCompetition(cfgCompetition);
		matchId.setCompetitionEvent(competitionEvent);
		matchId.addParticipiant(rtParticipant);
		matchId.addParticipiant(rtTeam);
		coreDate.setZeroGmtMatchDate(new Date());
		matchId.setStartDate(coreDate);
		match.setMatchId(matchId);

		firstHash = match.getAbstractKey().getHashKey();

		rtMatch.setMatchId(matchId);

		secondHash = rtMatch.getAbstractKey().getHashKey();

		assertEquals(firstHash, secondHash);
		assertNotSame(firstHash, "");
		assertNotSame(secondHash, "");

	}

}
