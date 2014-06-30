/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.historic.task;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;

/**
 * The Class SecureBetHistoricTest.
 */
public class SecureBetHistoricTest extends AbstractTest {

	@Inject
	private SecureBetHistoric secureBetHistoric;

	@Test
	public final void testSureBetHistoric() throws IOException {
		secureBetHistoric.execute();
	}

	@Test
	public final void equalsBetsTest(){
		CfgBookmaker book = new CfgBookmaker();
		book.setObjectId("1");
		RtParticipant part = new RtParticipant();
		part.setObjectId("1");
		RtBet betMatch = new RtBet();
		betMatch.setParticipant(part);
		betMatch.setBookmaker(book);
		RtBet betOdd = new RtBet();
		betOdd.setParticipant(part);
		betOdd.setBookmaker(book);
		Assert.assertEquals(true, secureBetHistoric.equalsBets(betMatch, betOdd));
		
		CfgBookmaker book2 = new CfgBookmaker();
		book2.setObjectId("2");
		betOdd.setBookmaker(book2);
		RtParticipant part2 = new RtParticipant();
		betOdd.setParticipant(part2);
		
		Assert.assertEquals(false, secureBetHistoric.equalsBets(betMatch, betOdd));
		
	}
	
	@Test
	public final void findOddTest(){
		CfgBookmaker book = new CfgBookmaker();
		book.setObjectId("1");
		RtParticipant part = new RtParticipant();
		part.setObjectId("1");
		RtBet betMatch = new RtBet();
		betMatch.setParticipant(part);
		betMatch.setBookmaker(book);
		RtBet betOdd = new RtBet();
		betOdd.setParticipant(part);
		betOdd.setBookmaker(book);
		RtBetOdd odd = new RtBetOdd();
		odd.setOdds("1.3");
		RtMatch match = new RtMatch();
		RtMarket market = new RtMarket();
		
		
		
		RtBetTypeEvent betTypeEvent = new RtBetTypeEvent();
		betTypeEvent.setObjectId("1");
		market.setBetTypeEvent(betTypeEvent);
		CfgBetType betType = new CfgBetType();
		betType.setObjectId("2");
		market.setBetType(betType);
		betOdd.setBetType(betType);
		betMatch.setBetType(betType);
		betOdd.setBetOdd(odd);
		betMatch.setBetOdd(odd);
		Set<RtBet> bets = new HashSet<RtBet>();
		bets.add(betOdd);
		bets.add(betMatch);
		market.setBets(bets);
		Set<RtMarket> markets = new HashSet<RtMarket>();
		markets.add(market);
		match.setRtMarkets(markets);
		
		Assert.assertEquals(new Float("1.3"), secureBetHistoric.findOdd(match, betOdd, betTypeEvent));
	}
}
