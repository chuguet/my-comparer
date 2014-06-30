/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.process.combination;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.synchro.securebet.process.AbstractTest;

/**
 * The Class RtBetCombinationTest.
 */
public class RtBetCombinationTest extends AbstractTest {

	/**
	 * Test.
	 */
	@Test
	public final void test() {
		List<RtBet[]> rtBets = new ArrayList<RtBet[]>();

		RtBet bet_1 = makeRtBet(makeCfgBookmaker("1"),
				makeRtBetOdd("1", "1", "1"), makeRtParticipant("1"));
		RtBet bet_2 = makeRtBet(makeCfgBookmaker("1"),
				makeRtBetOdd("2", "2", "2"), makeRtParticipant("1"));
		RtBet bet_3 = makeRtBet(makeCfgBookmaker("1"),
				makeRtBetOdd("3", "3", "3"), makeRtParticipant("1"));

		RtBet[] rtBetArray_1 = { bet_1, bet_2, bet_3 };

		bet_1 = makeRtBet(makeCfgBookmaker("1"), makeRtBetOdd("4", "4", "4"),
				makeRtParticipant("2"));
		bet_2 = makeRtBet(makeCfgBookmaker("1"), makeRtBetOdd("5", "5", "5"),
				makeRtParticipant("2"));
		bet_3 = makeRtBet(makeCfgBookmaker("1"), makeRtBetOdd("6", "6", "6"),
				makeRtParticipant("2"));
		RtBet[] rtBetArray_2 = { bet_1, bet_2, bet_3 };

		bet_1 = makeRtBet(makeCfgBookmaker("1"), makeRtBetOdd("7", "7", "7"),
				makeRtParticipant("3"));
		bet_2 = makeRtBet(makeCfgBookmaker("1"), makeRtBetOdd("8", "8", "8"),
				makeRtParticipant("3"));
		bet_3 = makeRtBet(makeCfgBookmaker("1"), makeRtBetOdd("9", "9", "9"),
				makeRtParticipant("3"));
		RtBet[] rtBetArray_3 = { bet_1, bet_2, bet_3 };

		rtBets.add(rtBetArray_1);
		rtBets.add(rtBetArray_2);
		rtBets.add(rtBetArray_3);

		IRtBetCombination permutations = new RtBetCombination(rtBets);

		assertEquals(permutations.getCombinations(3).size(), 27);
		assertEquals(permutations.getCombinations().size(), 63);
		

	}

}
