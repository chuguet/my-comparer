/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.commons.betOdds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * The Class CuotaConverterUtil.
 */

public class CuotaConverterUtilTest {

	/**
	 * Decimal to american odds big number test.
	 */
	@Test
	public void decimalToAmericanOddsBigNumberTest() {
		String americanOdd = "123456";
		String decimalOdd = "";
		decimalOdd = CuotaConverterUtil.americanToDecimalOdds(americanOdd);
		assertNotNull(decimalOdd);
		assertEquals("1235.56", decimalOdd);
	}

	/**
	 * Decimal to american odds negative number test.
	 */
	@Test
	public void decimalToAmericanOddsNegativeNumberTest() {
		String americanOdd = "-125";
		String decimalOdd = "";
		decimalOdd = CuotaConverterUtil.americanToDecimalOdds(americanOdd);
		assertNotNull(decimalOdd);
		assertEquals("1.80", decimalOdd);
	}

	/**
	 * Decimal to american odds.
	 */
	@Test
	public void decimalToAmericanOddsTest() {
		String americanOdd = "169";
		String decimalOdd = "";
		decimalOdd = CuotaConverterUtil.americanToDecimalOdds(americanOdd);
		assertNotNull(decimalOdd);
		assertEquals("2.69", decimalOdd);
	}

}
