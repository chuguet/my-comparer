package com.comparadorad.bet.comparer.synchro.securebet.process.factory.calculate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2HandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatchId;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.repository.CfgBetTypeEventRepository;
import com.comparadorad.bet.comparer.model.repository.CfgBetTypeRepository;
import com.comparadorad.bet.comparer.model.repository.CfgBookmakerRepository;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanBenefit;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMarket;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMatch;
import com.comparadorad.bet.comparer.synchro.securebet.process.AbstractTest;

public class CalculateHandicapAsiaticoSecureBetTest extends AbstractTest {

	@Inject
	private CalculateHandicap1X2SecureBet calculateHandicap1x2SecureBet;
	@Inject
	private CfgBetTypeRepository betTypeRepository;
	@Inject
	private CfgBetTypeEventRepository betTypeEventRepository;
	@Inject
	private CfgBookmakerRepository bookmakerRepository;

	@Test
	public void CalculateHandicapAsiaticoSecureBetTestGenerateSegureBetTest() {

		SureBetsMatch calculateSecureBetBean;
		RtMatch match = new RtMatch();
		RtMatchId matchId = new RtMatchId();
		RtMarket rtMarket = new RtMarket();
		CfgCompetition cfgCompetition = new CfgCompetition();
		Set<RtParticipant> rtParticipants = new HashSet<RtParticipant>();

		RtParticipant homeRtparticipant = new RtParticipant();
		homeRtparticipant.setAwayParticipant(false);
		homeRtparticipant.setHomeParticipant(true);
		rtParticipants.add(homeRtparticipant);

		RtParticipant awayRtparticipant = new RtParticipant();
		awayRtparticipant.setAwayParticipant(true);
		awayRtparticipant.setHomeParticipant(false);
		rtParticipants.add(awayRtparticipant);

		CfgBetType cfgBetType = betTypeRepository.findOne(new BigInteger("4"));
		CfgBetTypeEvent betTypeEvent = betTypeEventRepository
				.findOne(new BigInteger("1"));
		RtBetTypeEvent rtBetTypeEvent = new RtBetTypeEvent();
		rtBetTypeEvent.setBetTypeEvent(betTypeEvent);

		Set<RtBet> bets = new HashSet<RtBet>();

		RtBet bet;

		// BETBOO

		// handicap 1:0
		bet = createBet("2.41", awayRtparticipant, "19", "www.betboo.com", 1d,
				0d, "TWO");
		bets.add(bet);

		bet = createBet("1.01", homeRtparticipant, "19", "www.betboo.com", 1d,
				0d, "ONE");
		bets.add(bet);

		// handicap 2:0
		bet = createBet("2.11", awayRtparticipant, "19", "www.betboo.com", 2d,
				0d, "TWO");
		bets.add(bet);

		bet = createBet("1.02", homeRtparticipant, "19", "www.betboo.com", 2d,
				0d, "ONE");
		bets.add(bet);

		// handicap 3:0
		bet = createBet("3.01", awayRtparticipant, "19", "www.betboo.com", 3d,
				0d, "TWO");
		bets.add(bet);

		bet = createBet("1.01", homeRtparticipant, "19", "www.betboo.com", 3d,
				0d, "ONE");
		bets.add(bet);

		// BETCLICK

		// handicap 1:0
		bet = createBet("1.93", awayRtparticipant, "17", "www.betclick.com",
				1d, 0d, "TWO");
		bets.add(bet);

		bet = createBet("2.21", homeRtparticipant, "17", "www.betclick.com",
				1d, 0d, "ONE");
		bets.add(bet);

		// handicap 2:0
		bet = createBet("1.83", awayRtparticipant, "17", "www.betclick.com",
				2d, 0d, "TWO");
		bets.add(bet);

		bet = createBet("3.11", homeRtparticipant, "17", "www.betclick.com",
				2d, 0d, "ONE");
		bets.add(bet);

		// handicap 3:0
		bet = createBet("1.93", awayRtparticipant, "17", "www.betclick.com",
				3d, 0d, "TWO");
		bets.add(bet);

		bet = createBet("3.01", homeRtparticipant, "17", "www.betclick.com",
				3d, 0d, "ONE");
		bets.add(bet);

		cfgCompetition.setObjectId(BigInteger.ONE);

		matchId.setCompetition(cfgCompetition);
		matchId.setParticipiants(rtParticipants);

		rtMarket.setBetType(cfgBetType);
		rtMarket.setBetTypeEvent(rtBetTypeEvent);
		rtMarket.setBets(bets);

		match.setMatchId(matchId);
		match.add(rtMarket);

		calculateSecureBetBean = calculateHandicap1x2SecureBet
				.calculateSecureBetForRtMarket(match, rtMarket);
		assertNotNull(calculateSecureBetBean);
		assertEquals(3, calculateSecureBetBean.getSureBetsMarket().size());
		assertEquals(cfgBetType, calculateSecureBetBean.getSureBetsMarket()
				.get(0).getBetType());
		assertEquals(rtBetTypeEvent, calculateSecureBetBean.getSureBetsMarket()
				.get(0).getBetTypeEvent());
		assertEquals(cfgCompetition, calculateSecureBetBean.getSureBetsMarket()
				.get(0).getMatch().getMatchId().getCompetition());
		SureBetsMarket bean = calculateSecureBetBean.getSureBetsMarket().get(0);
		for (SecureBeanBenefit beanBenefit : bean.getSecureBetAgrupation()
				.keySet()) {
			Double number = Math.rint(beanBenefit.getValue() * 100) / 100;
			if (15.28d != number && 25.71d != number && 50.50d != number) {
				fail("Los beneficios no son los esperados");
			}
		}

	}

	@Test
	public void CalculateHandicapAsiaticoSecureBetTestNoGenerateSegureBetTest() {

		SureBetsMatch calculateSecureBetBean;
		RtMatch match = new RtMatch();
		RtMatchId matchId = new RtMatchId();
		RtMarket rtMarket = new RtMarket();
		CfgCompetition cfgCompetition = new CfgCompetition();
		Set<RtParticipant> rtParticipants = new HashSet<RtParticipant>();

		RtParticipant homeRtparticipant = new RtParticipant();
		homeRtparticipant.setAwayParticipant(false);
		homeRtparticipant.setHomeParticipant(true);
		rtParticipants.add(homeRtparticipant);

		RtParticipant awayRtparticipant = new RtParticipant();
		awayRtparticipant.setAwayParticipant(true);
		awayRtparticipant.setHomeParticipant(false);
		rtParticipants.add(awayRtparticipant);

		CfgBetType cfgBetType = betTypeRepository.findOne(new BigInteger("4"));
		CfgBetTypeEvent betTypeEvent = betTypeEventRepository
				.findOne(new BigInteger("1"));
		RtBetTypeEvent rtBetTypeEvent = new RtBetTypeEvent();
		rtBetTypeEvent.setBetTypeEvent(betTypeEvent);

		Set<RtBet> bets = new HashSet<RtBet>();

		RtBet bet;

		// BETBOO

		// handicap 1:0
		bet = createBet("1.41", awayRtparticipant, "19", "www.betboo.com", 1d,
				0d, "TWO");
		bets.add(bet);

		bet = createBet("1.01", homeRtparticipant, "19", "www.betboo.com", 1d,
				0d, "ONE");
		bets.add(bet);

		// handicap 2:0
		bet = createBet("1.11", awayRtparticipant, "19", "www.betboo.com", 2d,
				0d, "TWO");
		bets.add(bet);

		bet = createBet("1.02", homeRtparticipant, "19", "www.betboo.com", 2d,
				0d, "ONE");
		bets.add(bet);

		// handicap 3:0
		bet = createBet("1.61", awayRtparticipant, "19", "www.betboo.com", 3d,
				0d, "TWO");
		bets.add(bet);

		bet = createBet("1.01", homeRtparticipant, "19", "www.betboo.com", 3d,
				0d, "ONE");
		bets.add(bet);

		// BETCLICK

		// handicap 1:0
		bet = createBet("1.93", awayRtparticipant, "17", "www.betclick.com",
				1d, 0d, "TWO");
		bets.add(bet);

		bet = createBet("1.21", homeRtparticipant, "17", "www.betclick.com",
				1d, 0d, "ONE");
		bets.add(bet);

		// handicap 2:0
		bet = createBet("1.83", awayRtparticipant, "17", "www.betclick.com",
				2d, 0d, "TWO");
		bets.add(bet);

		bet = createBet("1.11", homeRtparticipant, "17", "www.betclick.com",
				2d, 0d, "ONE");
		bets.add(bet);

		// handicap 3:0
		bet = createBet("1.93", awayRtparticipant, "17", "www.betclick.com",
				3d, 0d, "TWO");
		bets.add(bet);

		bet = createBet("1.21", homeRtparticipant, "17", "www.betclick.com",
				3d, 0d, "ONE");
		bets.add(bet);

		cfgCompetition.setObjectId(BigInteger.ONE);

		matchId.setCompetition(cfgCompetition);
		matchId.setParticipiants(rtParticipants);

		rtMarket.setBetType(cfgBetType);
		rtMarket.setBetTypeEvent(rtBetTypeEvent);
		rtMarket.setBets(bets);

		match.setMatchId(matchId);
		match.add(rtMarket);

		calculateSecureBetBean = calculateHandicap1x2SecureBet
				.calculateSecureBetForRtMarket(match, rtMarket);
		assertNotNull(calculateSecureBetBean);
		assertEquals(3, calculateSecureBetBean.getSureBetsMarket().size());
		assertEquals(cfgBetType, calculateSecureBetBean.getSureBetsMarket()
				.get(0).getBetType());
		assertEquals(rtBetTypeEvent, calculateSecureBetBean.getSureBetsMarket()
				.get(0).getBetTypeEvent());
		assertEquals(cfgCompetition, calculateSecureBetBean.getSureBetsMarket()
				.get(0).getMatch().getMatchId().getCompetition());

	}

	@Test
	public void CalculateHandicapAsiaticoSecureBetTestAlmostGenerateSegureBetTest() {

		SureBetsMatch calculateSecureBetBean;
		RtMatch match = new RtMatch();
		RtMatchId matchId = new RtMatchId();
		RtMarket rtMarket = new RtMarket();
		CfgCompetition cfgCompetition = new CfgCompetition();
		Set<RtParticipant> rtParticipants = new HashSet<RtParticipant>();

		RtParticipant homeRtparticipant = new RtParticipant();
		homeRtparticipant.setAwayParticipant(false);
		homeRtparticipant.setHomeParticipant(true);
		rtParticipants.add(homeRtparticipant);

		RtParticipant awayRtparticipant = new RtParticipant();
		awayRtparticipant.setAwayParticipant(true);
		awayRtparticipant.setHomeParticipant(false);
		rtParticipants.add(awayRtparticipant);

		CfgBetType cfgBetType = betTypeRepository.findOne(new BigInteger("4"));
		CfgBetTypeEvent betTypeEvent = betTypeEventRepository
				.findOne(new BigInteger("1"));
		RtBetTypeEvent rtBetTypeEvent = new RtBetTypeEvent();
		rtBetTypeEvent.setBetTypeEvent(betTypeEvent);

		Set<RtBet> bets = new HashSet<RtBet>();

		RtBet bet;

		// BETBOO

		// handicap 1:0
		bet = createBet("2.00", awayRtparticipant, "19", "www.betboo.com", 1d,
				0d, "TWO");
		bets.add(bet);

		bet = createBet("1.01", homeRtparticipant, "19", "www.betboo.com", 1d,
				0d, "ONE");
		bets.add(bet);

		// handicap 2:0
		bet = createBet("2.00", awayRtparticipant, "19", "www.betboo.com", 2d,
				0d, "TWO");
		bets.add(bet);

		bet = createBet("1.02", homeRtparticipant, "19", "www.betboo.com", 2d,
				0d, "ONE");
		bets.add(bet);

		// handicap 3:0
		bet = createBet("2.00", awayRtparticipant, "19", "www.betboo.com", 3d,
				0d, "TWO");
		bets.add(bet);

		bet = createBet("1.01", homeRtparticipant, "19", "www.betboo.com", 3d,
				0d, "ONE");
		bets.add(bet);

		// BETCLICK

		// handicap 1:0
		bet = createBet("1.93", awayRtparticipant, "17", "www.betclick.com",
				1d, 0d, "TWO");
		bets.add(bet);

		bet = createBet("2.00", homeRtparticipant, "17", "www.betclick.com",
				1d, 0d, "ONE");
		bets.add(bet);

		// handicap 2:0
		bet = createBet("1.83", awayRtparticipant, "17", "www.betclick.com",
				2d, 0d, "TWO");
		bets.add(bet);

		bet = createBet("2.00", homeRtparticipant, "17", "www.betclick.com",
				2d, 0d, "ONE");
		bets.add(bet);

		// handicap 3:0
		bet = createBet("1.93", awayRtparticipant, "17", "www.betclick.com",
				3d, 0d, "TWO");
		bets.add(bet);

		bet = createBet("1.21", homeRtparticipant, "17", "www.betclick.com",
				3d, 0d, "ONE");
		bets.add(bet);

		cfgCompetition.setObjectId(BigInteger.ONE);

		matchId.setCompetition(cfgCompetition);
		matchId.setParticipiants(rtParticipants);

		rtMarket.setBetType(cfgBetType);
		rtMarket.setBetTypeEvent(rtBetTypeEvent);
		rtMarket.setBets(bets);

		match.setMatchId(matchId);
		match.add(rtMarket);

		calculateSecureBetBean = calculateHandicap1x2SecureBet
				.calculateSecureBetForRtMarket(match, rtMarket);
		assertNotNull(calculateSecureBetBean);
		assertEquals(3, calculateSecureBetBean.getSureBetsMarket().size());
		assertEquals(cfgBetType, calculateSecureBetBean.getSureBetsMarket()
				.get(0).getBetType());
		assertEquals(rtBetTypeEvent, calculateSecureBetBean.getSureBetsMarket()
				.get(0).getBetTypeEvent());
		assertEquals(cfgCompetition, calculateSecureBetBean.getSureBetsMarket()
				.get(0).getMatch().getMatchId().getCompetition());
		SureBetsMarket bean = calculateSecureBetBean.getSureBetsMarket().get(0);
		for (SecureBeanBenefit beanBenefit : bean.getSecureBetAgrupation()
				.keySet()) {
			// List<RtBet> rtBets =
			// bean.getSecureBetAgrupation().get(beanBenefit);
			Double number = Math.rint(beanBenefit.getValue() * 100) / 100;
			assertEquals((Double) 0.00, number);
		}

	}

	private RtBet createBet(String odd, RtParticipant participant,
			String idBookmaker, String urlBookamker, Double primero,
			Double segundo, String ganador) {
		RtBet bet = new RtBet();
		RtBetOdd betOdd = new RtBetOdd();
		Rt1X2HandicapAttribute handicapAttribute = new Rt1X2HandicapAttribute();

		handicapAttribute.setFinalValue(primero);
		handicapAttribute.setResult(Result.valueOf(ganador));

		betOdd.setOdds(odd);
		bet.setBetOdd(betOdd);
		bet.setParticipant(participant);
		bet.setAttribute(handicapAttribute);
		bet.setBookmaker(this.bookmakerRepository.findOne(new BigInteger(
				idBookmaker)));
		return bet;
	}
}
