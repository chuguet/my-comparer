/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.process;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2Attribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatchId;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsCandidate;

/**
 * The Class ProcessSecureBetTest.
 */
public class ProcessSecureBetTest extends AbstractTest {

	/** The process secure bet. */
	@Inject
	private SureBetProcess<SureBetsCandidate> processSecureBet;

	/**
	 * Test.
	 */
	@Test
	public final void nullTest() {
		SureBetsCandidate betResultBean = new SureBetsCandidate();
		processSecureBet.calculate(betResultBean);
	}

	/**
	 * Calculate bet secure test with two participant.
	 */
	@Test
	public final void calculateBetSecureTestWithTwoParticipant() {
		SureBetsCandidate betResultBean = new SureBetsCandidate();
		RtMarket market = new RtMarket();
		RtMatch match = new RtMatch();
		RtMatchId matchId = new RtMatchId();
		RtParticipant participant;
		CfgParticipant cfgParticipant;
		CfgCompetition cfgCompetition;
		CfgSport cfgSport;

		participant = new RtParticipant();
		cfgCompetition = new CfgCompetition();
		cfgSport = new CfgSport();
		cfgCompetition.setObjectId(BigInteger.ONE);
		cfgSport.setObjectId(BigInteger.ONE);
		cfgParticipant = new CfgParticipant();
		cfgParticipant.setObjectId(BigInteger.ONE);
		cfgParticipant.setCompetition(cfgCompetition);
		cfgParticipant.setSport(cfgSport);
		participant.setCfgParticipant(cfgParticipant);
		matchId.addParticipiant(participant);

		participant = new RtParticipant();
		cfgCompetition = new CfgCompetition();
		cfgSport = new CfgSport();
		cfgParticipant = new CfgParticipant();
		cfgCompetition.setObjectId(BigInteger.TEN);
		cfgSport.setObjectId(BigInteger.TEN);
		cfgParticipant.setObjectId(BigInteger.TEN);
		cfgParticipant.setCompetition(cfgCompetition);
		cfgParticipant.setSport(cfgSport);
		participant.setCfgParticipant(cfgParticipant);
		matchId.addParticipiant(participant);
		
		matchId.setStartDate(new CoreDate(new Date()));

		match.setMatchId(matchId);

		CfgBetType betType = new CfgBetType();
		betType.setObjectId(new BigInteger("3124"));
		betType.setNameId(CfgBetType.CfgBetTypeId.GANADOR_PARTIDO.nameId());
		market.setBetType(betType);

		market.add(marketGanadorRtBet(makeCfgBookmaker("1"),
				makeRtBetOdd("", "", "2.1"), makeRtParticipant("1"), Result.ONE));
		market.add(marketGanadorRtBet(makeCfgBookmaker("1"), makeRtBetOdd("", "", "2"),
				makeRtParticipant("2"), Result.TWO));

		market.add(marketGanadorRtBet(makeCfgBookmaker("2"), makeRtBetOdd("", "", "1"),
				makeRtParticipant("1"), Result.ONE));
		market.add(marketGanadorRtBet(makeCfgBookmaker("2"), makeRtBetOdd("", "", "2"),
				makeRtParticipant("2"), Result.TWO));

		match.getRtMarkets().add(market);

		betResultBean.setRtMatch(match);

		processSecureBet.calculate(betResultBean);
	}

	/**
	 * Calculate bet secure test with three participant.
	 */
	@Test
	public final void calculateBetSecureTestWithThreeParticipant() {
		SureBetsCandidate betResultBean = new SureBetsCandidate();
		RtMarket market = new RtMarket();
		RtMatch match = new RtMatch();
		RtMatchId matchId = new RtMatchId();
		RtParticipant participant;
		CfgParticipant cfgParticipant;

		participant = new RtParticipant();
		cfgParticipant = new CfgParticipant();
		cfgParticipant.setObjectId(BigInteger.ONE);
		participant.setCfgParticipant(cfgParticipant);
		matchId.addParticipiant(participant);

		participant = new RtParticipant();
		cfgParticipant = new CfgParticipant();
		cfgParticipant.setObjectId(BigInteger.TEN);
		participant.setCfgParticipant(cfgParticipant);
		matchId.addParticipiant(participant);

		participant = new RtParticipant();
		cfgParticipant = new CfgParticipant();
		cfgParticipant.setObjectId(BigInteger.ZERO);
		participant.setCfgParticipant(cfgParticipant);
		matchId.addParticipiant(participant);
		
		matchId.setStartDate(new CoreDate(new Date()));

		match.setMatchId(matchId);

		market.add(market1X2RtBet(makeCfgBookmaker("1"),
				makeRtBetOdd("", "", "3.5"), makeRtParticipant("1"), Result.ONE));
		market.add(market1X2RtBet(makeCfgBookmaker("1"), makeRtBetOdd("", "", "2"),
				makeRtParticipant("2"), Result.DRAW));
		market.add(market1X2RtBet(makeCfgBookmaker("1"), makeRtBetOdd("", "", "1"),
				makeRtParticipant("3"), Result.TWO));

		market.add(market1X2RtBet(makeCfgBookmaker("2"), makeRtBetOdd("", "", "1"),
				makeRtParticipant("1"), Result.ONE));
		market.add(market1X2RtBet(makeCfgBookmaker("2"), makeRtBetOdd("", "", "3"),
				makeRtParticipant("2"), Result.DRAW));
		market.add(market1X2RtBet(makeCfgBookmaker("3"), makeRtBetOdd("", "", "3"),
				makeRtParticipant("3"), Result.TWO));
		CfgBetType betType = new CfgBetType();
		betType.setNameId(CfgBetType.CfgBetTypeId.UNO_X_DOS.nameId());
		betType.setObjectId(new BigInteger("23"));
		market.setBetType(betType);

		match.getRtMarkets().add(market);

		betResultBean.setRtMatch(match);

		processSecureBet.calculate(betResultBean);
	}

	@Test
	public final void calculateBetSecure1X2Test() {
		
		SureBetsCandidate betResultBean = new SureBetsCandidate();
		RtMarket market = new RtMarket();
		RtMatch match = new RtMatch();
		RtMatchId matchId = new RtMatchId();
		CfgBetType cfgBetType = new CfgBetType();
		RtParticipant participant;
		CfgParticipant cfgParticipant;

		participant = new RtParticipant();
		cfgParticipant = new CfgParticipant();
		cfgParticipant.setObjectId(BigInteger.ONE);
		participant.setCfgParticipant(cfgParticipant);
		matchId.addParticipiant(participant);

		participant = new RtParticipant();
		cfgParticipant = new CfgParticipant();
		cfgParticipant.setObjectId(BigInteger.TEN);
		participant.setCfgParticipant(cfgParticipant);
		matchId.addParticipiant(participant);

		participant = new RtParticipant();
		cfgParticipant = new CfgParticipant();
		cfgParticipant.setObjectId(BigInteger.ZERO);
		participant.setCfgParticipant(cfgParticipant);
		matchId.addParticipiant(participant);
		
		matchId.setStartDate(new CoreDate(new Date()));

		match.setMatchId(matchId);

		cfgBetType.setNameId(CfgBetType.CfgBetTypeId.UNO_X_DOS.nameId());
		cfgBetType.setObjectId(new BigInteger("4832748"));

		market.setBetType(cfgBetType);
		market.add(market1X2RtBet(makeCfgBookmaker("1"),
				makeRtBetOdd("", "", "3.5"), makeRtParticipant("1"), Result.ONE));
		market.add(market1X2RtBet(makeCfgBookmaker("1"), makeRtBetOdd("", "", "2"),
				makeRtParticipant("2"), Result.DRAW));
		market.add(market1X2RtBet(makeCfgBookmaker("1"), makeRtBetOdd("", "", "1"),
				makeRtParticipant("3"), Result.TWO));

		market.add(market1X2RtBet(makeCfgBookmaker("2"), makeRtBetOdd("", "", "1"),
				makeRtParticipant("1"), Result.ONE));
		market.add(market1X2RtBet(makeCfgBookmaker("2"), makeRtBetOdd("", "", "3"),
				makeRtParticipant("2"), Result.DRAW));
		market.add(market1X2RtBet(makeCfgBookmaker("3"), makeRtBetOdd("", "", "3"),
				makeRtParticipant("3"), Result.TWO));

		Set<RtMarket> markets = new HashSet<RtMarket>();
		markets.add(market);
		match.setRtMarkets(markets);

		betResultBean.setRtMatch(match);

		processSecureBet.calculate(betResultBean);
	}

}
