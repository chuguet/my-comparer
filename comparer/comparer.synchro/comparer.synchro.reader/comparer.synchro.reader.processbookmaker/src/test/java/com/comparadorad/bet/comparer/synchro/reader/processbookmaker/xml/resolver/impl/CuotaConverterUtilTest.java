/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.impl;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest;

/**
 * The Class CuotaConverterUtilTest.
 */
public class CuotaConverterUtilTest extends AbstractTest {

	/** The cuota converter util. */
	@Inject
	private CuotaConverterUtil cuotaConverterUtil;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest
	 * #test()
	 */
	@Override
	@Test
	public void test() {
		RtBetOdd bet = new RtBetOdd();
		bet.setOdds("1.5");
		String result = cuotaConverterUtil.getAmericanOdds(bet);
		assertNotNull(result);
	}

	/**
	 * Gets the odds test.
	 * 
	 * @return the odds test
	 */
	@Test
	public void getOddsTest() {
		RtBetOdd bet = new RtBetOdd();
		bet.setAmericanOdds("800");
		String result = cuotaConverterUtil.getOdds(bet);
		assertNotNull(result);

		bet.setAmericanOdds("-200");
		result = cuotaConverterUtil.getOdds(bet);
		assertNotNull(result);

		bet = new RtBetOdd();
		bet.setFraOdds("0.245");
		result = cuotaConverterUtil.getOdds(bet);
		assertNotNull(result);
	}

	/**
	 * Gets the fra odds test.
	 * 
	 * @return the fra odds test
	 */
	@Test
	public void getFraOddsTest() {
		RtBetOdd bet = new RtBetOdd();
		bet.setOdds("0.9");
		String result = cuotaConverterUtil.getFraOdds(bet);

		assertNotNull(result);
	}

}
