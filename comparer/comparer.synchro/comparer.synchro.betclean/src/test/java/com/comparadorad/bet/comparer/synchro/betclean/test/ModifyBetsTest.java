/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.betclean.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.integration.core.beans.UpdaterBetsTO;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatchId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.bean.LongTerm;
import com.comparadorad.bet.comparer.synchro.betclean.exception.RemoveBetsException;
import com.comparadorad.bet.comparer.synchro.betclean.exception.UpdateBetsException;
import com.comparadorad.bet.comparer.synchro.betclean.util.IModifyBets;

/**
 * The Class ModifyBetsTest.
 */
public class ModifyBetsTest extends AbstractTest {

	/** The modify bets. */
	@Inject
	private IModifyBets modifyBets;

	/**
	 * Removes the bets test.
	 * 
	 * @throws RemoveBetsException
	 *             the remove bets exception
	 */
	@Test
	public void removeBetsDeleteAllTest() throws RemoveBetsException {
		List<RtMatch> rtmatchs = new ArrayList<RtMatch>();
		RtMatch match;

		match = getRtMatchRepository().findOneCustom("1");

		rtmatchs.add(match);

		modifyBets.removeBets(rtmatchs);

		match = getRtMatchRepository().findOneCustom("1");
		assertNull(match);
	}

	/**
	 * No remove bets delete all test.
	 * 
	 * @throws RemoveBetsException
	 *             the remove bets exception
	 */
	@Test
	public void noRemoveBetsDeleteAllTest() throws RemoveBetsException {
		List<RtMatch> rtmatchs = new ArrayList<RtMatch>();
		List<RtMatch> result;
		RtMatch match = new RtMatch();
		CfgCompetitionEvent cfgCompetitionEvent = new CfgCompetitionEvent();
		RtMatchId matchId = new RtMatchId();
		LongTerm longTerm = new LongTerm();
		RtMarket market;
		RtBet bet;
		CfgBookmaker bookmaker = new CfgBookmaker(new BigInteger("19"));

		longTerm.setLongTerm(Boolean.FALSE);
		cfgCompetitionEvent.setLongTerm(longTerm);
		cfgCompetitionEvent.setObjectId(BigInteger.TEN);

		matchId.setObjectId(BigInteger.TEN);
		matchId.setCompetitionEvent(cfgCompetitionEvent);

		match.setMatchId(matchId);

		bet = new RtBet();
		bet.setActualizeDate(new Date());
		bet.setBookmaker(bookmaker);

		market = new RtMarket();
		market.add(bet);

		match.add(market);

		rtmatchs.add(match);

		result = modifyBets.removeBets(rtmatchs);

		assertNotNull(result);
		assertEquals(result.get(0).getRtMarkets().size(), 1);

	}

	/**
	 * Update bets.
	 * 
	 * @throws UpdateBetsException
	 *             the update bets exception
	 */
	@Test
	public void updateBets() throws UpdateBetsException {

		List<RtMatch> matchs;

		UpdaterBetsTO updaterBetsTO = new UpdaterBetsTO(
				"50cc029f2aefb071a250bfc122630c91f2459900",
				new BigInteger("19"), Arrays.asList(
						"472b07b9fcf2c2451e8781e944bf5f77cd8457c8",
						"17ba0791499db908433b80f37c5fbc89b870084b",
						"632667547e7cd3e0466547863e1207a8c0c0c549"));

		modifyBets.updateBets(updaterBetsTO);

		matchs = getRtMatchRepository().getMatchsByHashKey(updaterBetsTO
				.getHashKeysMatch());

		for (RtMatch rtMatch : matchs) {
			for (RtMarket market : rtMatch.getRtMarkets()) {
				if (!"761f22b2c1593d0bb87e0b606f990ba4974706de".equals(market
						.getHashKey())) {
					for (RtBet bet : market.getBets()) {
						if (bet.getBookmaker().getObjectId().toString()
								.equals("19")) {
							assertNotNull(bet.getActualizeDate());
						} else {
							assertNull(bet.getActualizeDate());
						}
					}
				}
			}
		}

	}

	/**
	 * Delete one bet remove bets test.
	 * 
	 * @throws RemoveBetsException
	 *             the remove bets exception
	 */
	@Test
	public void deleteOneBetRemoveBetsTest() throws RemoveBetsException {
		List<RtMatch> rtmatchs = new ArrayList<RtMatch>();
		List<RtMatch> matchResults;
		RtMatch match = new RtMatch();
		RtMatchId matchId = new RtMatchId();
		LongTerm longTerm = new LongTerm();
		CfgCompetitionEvent cfgCompetitionEvent = new CfgCompetitionEvent();
		RtMatch matchResult;
		RtMarket market;
		RtBet currentBet;
		RtBet outdatedBet;
		CfgBookmaker bookmaker = new CfgBookmaker(new BigInteger("19"));

		longTerm.setLongTerm(Boolean.FALSE);
		cfgCompetitionEvent.setLongTerm(longTerm);
		cfgCompetitionEvent.setObjectId(BigInteger.TEN);
		matchId.setCompetitionEvent(cfgCompetitionEvent);

		match.setMatchId(matchId);

		market = new RtMarket();

		currentBet = new RtBet();
		currentBet.setActualizeDate(new Date());
		currentBet.setBookmaker(bookmaker);

		market.add(currentBet);

		outdatedBet = new RtBet();
		outdatedBet.setActualizeDate(new Date(new Date().getTime() - 1800000l));
		outdatedBet.setBookmaker(bookmaker);

		market.add(outdatedBet);

		match.add(market);

		rtmatchs.add(match);

		matchResults = modifyBets.removeBets(rtmatchs);
		matchResult = matchResults.get(0);

		assertNotNull(matchResults);
		assertNotNull(matchResult);
		assertEquals(matchResult.getRtMarkets().size(), 1);

		for (RtMarket rtMarket : matchResult.getRtMarkets()) {
			assertEquals(rtMarket.getBets().size(), 1);
			for (RtBet bet : rtMarket.getBets()) {
				assertEquals(bet, currentBet);
			}
		}

	}

	/**
	 * Removes the bets test.
	 * 
	 * @throws RemoveBetsException
	 *             the remove bets exception
	 */
	@Test
	public void removeBetsTest() throws RemoveBetsException {
		List<RtMatch> rtmatchs = new ArrayList<RtMatch>();
		List<RtMatch> matchResults;
		RtMatch match = new RtMatch();
		CfgCompetitionEvent cfgCompetitionEvent = new CfgCompetitionEvent();
		RtMatchId matchId = new RtMatchId();
		LongTerm longTerm = new LongTerm();
		RtMatch matchResult;
		RtMarket market;
		RtBet currentBet;
		RtBet outdatedBet;
		CfgBookmaker bookmaker = new CfgBookmaker(new BigInteger("19"));

		longTerm.setLongTerm(Boolean.FALSE);
		cfgCompetitionEvent.setLongTerm(longTerm);
		cfgCompetitionEvent.setObjectId(BigInteger.TEN);
		matchId.setCompetitionEvent(cfgCompetitionEvent);

		matchId.setObjectId(BigInteger.TEN);
		match.setMatchId(matchId);

		currentBet = new RtBet();
		currentBet.setActualizeDate(new Date());
		currentBet.setBookmaker(bookmaker);

		outdatedBet = new RtBet();
		outdatedBet.setActualizeDate(new Date(new Date().getTime() - 1800000l));
		outdatedBet.setBookmaker(bookmaker);

		market = new RtMarket();

		market.add(currentBet);
		market.add(currentBet);

		match.add(market);

		market = new RtMarket();

		market.add(outdatedBet);
		market.add(outdatedBet);

		match.add(market);

		market = new RtMarket();

		market.add(outdatedBet);
		market.add(outdatedBet);

		match.add(market);

		market = new RtMarket();

		market.add(currentBet);
		market.add(outdatedBet);

		match.add(market);

		rtmatchs.add(match);

		matchResults = modifyBets.removeBets(rtmatchs);
		matchResult = matchResults.get(0);

		assertNotNull(matchResults);
		assertNotNull(matchResult);

		assertEquals(matchResult.getRtMarkets().size(), 2);

		for (RtMarket rtMarket : matchResult.getRtMarkets()) {
			if (rtMarket.getBets().size() != 1
					&& rtMarket.getBets().size() != 2) {
				fail("El numero de apuesta no es correcto");
			}
		}

	}
	
	@Test
	public void noRemoveBets() throws RemoveBetsException{
		
		List<RtMatch> rtmatchs = new ArrayList<RtMatch>();
		RtMatch match;

		match = getRtMatchRepository().findOneCustom("3");

		rtmatchs.add(match);

		modifyBets.removeBets(rtmatchs);

		match = getRtMatchRepository().findOneCustom("3");
		
		assertNotNull(match);
		
	}

}
