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

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.AbstractBetBeanTest;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;

/**
 * The Class HashKeyRtMarketTest.
 */
public class HashKeyRtMarketTest extends AbstractBetBeanTest {

	/**
	 * Test.
	 * 
	 * {@inheritDoc}
	 */

	@Override
	public final void test() {
		RtMarket rtMarket = new RtMarket();
		assertNotNull(rtMarket.getAbstractKey());
		assertEquals(rtMarket.getAbstractKey().getHashKey(), "");
	}

	/**
	 * Test two different.
	 */
	@Test
	public final void testTwoDifferent() {
		String firstHash;
		String secondHash;
		RtMarket market = new RtMarket();
		RtBetTypeEvent betTypeEvent = new RtBetTypeEvent();
		CfgBetType betType = new CfgBetType();

		betTypeEvent.setObjectId(BigInteger.ONE);
		betType.setObjectId(BigInteger.ONE);
		market.setBetType(betType);
		market.setBetTypeEvent(betTypeEvent);
		firstHash = market.getAbstractKey().getHashKey();

		betType.setObjectId(BigInteger.TEN);
		betTypeEvent.setObjectId(BigInteger.TEN);
		market.setBetType(betType);
		market.setBetTypeEvent(betTypeEvent);
		secondHash = market.getAbstractKey().getHashKey();

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
		RtMarket mainMarket = new RtMarket();
		RtMarket secondaryMarket = new RtMarket();
		RtBetTypeEvent betTypeEvent = new RtBetTypeEvent();
		CfgBetType betType = new CfgBetType();

		betTypeEvent.setObjectId(BigInteger.ONE);
		betType.setObjectId(BigInteger.ONE);
		mainMarket.setBetType(betType);
		mainMarket.setBetTypeEvent(betTypeEvent);
		firstHash = mainMarket.getAbstractKey().getHashKey();

		betType.setObjectId(BigInteger.ONE);
		betTypeEvent.setObjectId(BigInteger.ONE);
		secondaryMarket.setBetType(betType);
		secondaryMarket.setBetTypeEvent(betTypeEvent);
		secondHash = secondaryMarket.getAbstractKey().getHashKey();

		assertEquals(firstHash, secondHash);
		assertNotSame(firstHash, "");
		assertNotSame(secondHash, "");

	}

}
