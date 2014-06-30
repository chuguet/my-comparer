package com.comparadorad.bet.comparer.synchro.securebet.process.factory.calculate;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.synchro.securebet.process.AbstractTest;

public final class CalculateSecureBetTest extends AbstractTest {

	@Inject
	private Calculate1X2SecureBet calculate1x2SecureBet;



	@Test
	public final void isPossibleCalculateSecureBetTest() {
		Assert.assertEquals(true,calculate1x2SecureBet.isPossibleCalculateSecureBet(new RtMarket(), 3));
		Assert.assertEquals(false,calculate1x2SecureBet.isPossibleCalculateSecureBet(new RtMarket(), 6));
		
	}

	
	@Test
	public final void getRtBetForParticipantTest() {
		Set<RtBet> rtBets = new HashSet<RtBet>();
		RtBet bet = new RtBet();
		RtParticipant part = new RtParticipant();
		part.setObjectId("1");
		bet.setParticipant(part);
		rtBets.add(bet);
		bet = new RtBet();
		bet.setParticipant(part);
		rtBets.add(bet);
		
		Map<RtParticipant, Set<RtBet>> result = calculate1x2SecureBet.getRtBetForParticipant(rtBets);
		Assert.assertEquals(1,result.size());
		Assert.assertEquals(2,(result.get(part)).size());
		
		RtParticipant part2 = new RtParticipant();
		part2.setObjectId("2");
		RtBet bet2 = new RtBet();
		bet2.setParticipant(part2);
		rtBets.add(bet2);
		Map<RtParticipant, Set<RtBet>> result2 = calculate1x2SecureBet.getRtBetForParticipant(rtBets);
		Assert.assertEquals(2,result2.size());
		Assert.assertEquals(2,(result2.get(part)).size());
		Assert.assertEquals(1,(result2.get(part2)).size());
		
	}
	
	
	@Test
	public final void searchBetsecureTest() {
		List<RtBet> bets = new ArrayList<RtBet>();
		RtBet bet = new RtBet();
		RtBetOdd odd = new RtBetOdd();
		odd.setOdds("3.1");
		bet.setBetOdd(odd);
		bets.add(bet);
		bet = new RtBet();
		odd = new RtBetOdd();
		odd.setOdds("3.1");
		bet.setBetOdd(odd);
		bets.add(bet);
		bet = new RtBet();
		odd = new RtBetOdd();
		odd.setOdds("3.1");
		bet.setBetOdd(odd);
		bets.add(bet);
		List<List<RtBet>> finalList = new ArrayList<List<RtBet>>();
		finalList.add(bets);
		Assert.assertEquals(1,(calculate1x2SecureBet.searchBetsecure(finalList)).size());
		bets.clear();
		bet = new RtBet();
		odd = new RtBetOdd();
		odd.setOdds("2.1");
		bet.setBetOdd(odd);
		bets.add(bet);
		bet = new RtBet();
		odd = new RtBetOdd();
		odd.setOdds("1.1");
		bet.setBetOdd(odd);
		bets.add(bet);
		bet = new RtBet();
		odd = new RtBetOdd();
		odd.setOdds("3.1");
		bet.setBetOdd(odd);
		bets.add(bet);
		finalList = new ArrayList<List<RtBet>>();
		finalList.add(bets);
		Assert.assertEquals(0,(calculate1x2SecureBet.searchBetsecure(finalList)).size());
	}
	
}