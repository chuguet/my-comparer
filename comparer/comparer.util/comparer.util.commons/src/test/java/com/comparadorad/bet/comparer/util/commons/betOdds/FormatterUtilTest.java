/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.commons.betOdds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * The Class FormatterUtilTest.
 */
public class FormatterUtilTest {

	/**
	 * Formatter bet double test.
	 */
	@Test
	public void formatterBetDoubleTest() {
		double odd = 76412.5145;
		String formattedOdd = "";

		formattedOdd = FormatterUtil.formatBet(odd, -3);
		assertEquals(formattedOdd, "76413");

		formattedOdd = FormatterUtil.formatBet(odd, 0);
		assertEquals(formattedOdd, "76413");

		formattedOdd = FormatterUtil.formatBet(odd, 1);
		assertEquals(formattedOdd, "76412.5");

		formattedOdd = FormatterUtil.formatBet(odd, 2);
		assertEquals(formattedOdd, "76412.51");

		formattedOdd = FormatterUtil.formatBet(odd, 3);
		assertEquals(formattedOdd, "76412.515");

		formattedOdd = FormatterUtil.formatBet(odd, 4);
		assertEquals(formattedOdd, "76412.5145");

		formattedOdd = FormatterUtil.formatBet(odd, 5);
		assertEquals(formattedOdd, "76412.51450");

		formattedOdd = FormatterUtil.formatBet(odd, 6);
		assertEquals(formattedOdd, "76412.514500");

	}

	/**
	 * Formatter bet handicap double test.
	 */
	@Test
	public void formatterBetHandicapDoubleTest() {
		Double odd;
		String formattedOdd = "";

		odd = 1.0;
		formattedOdd = FormatterUtil.formatBetHandicap(odd);
		assertEquals("+1", formattedOdd);

		odd = 1.25;
		formattedOdd = FormatterUtil.formatBetHandicap(odd);
		assertEquals("+1.25", formattedOdd);

		odd = 1.5;
		formattedOdd = FormatterUtil.formatBetHandicap(odd);
		assertEquals("+1.5", formattedOdd);

		odd = 1.50;
		formattedOdd = FormatterUtil.formatBetHandicap(odd);
		assertEquals("+1.5", formattedOdd);
		
		odd = -1.0;
		formattedOdd = FormatterUtil.formatBetHandicap(odd);
		assertEquals("-1", formattedOdd);

		odd = -1.25;
		formattedOdd = FormatterUtil.formatBetHandicap(odd);
		assertEquals("-1.25", formattedOdd);

		odd = -1.5;
		formattedOdd = FormatterUtil.formatBetHandicap(odd);
		assertEquals("-1.5", formattedOdd);

		odd = -1.50;
		formattedOdd = FormatterUtil.formatBetHandicap(odd);
		assertEquals("-1.5", formattedOdd);

		odd = 0.0;
		formattedOdd = FormatterUtil.formatBetHandicap(odd);
		assertEquals("0", formattedOdd);

		odd = 0.0;
		formattedOdd = FormatterUtil.formatBetHandicap(odd);
		assertEquals("0", formattedOdd);

		odd = 0.00;
		formattedOdd = FormatterUtil.formatBetHandicap(odd);
		assertEquals("0", formattedOdd);

		odd = 0d;
		formattedOdd = FormatterUtil.formatBetHandicap(odd);
		assertEquals("0", formattedOdd);

	}

	/**
	 * Formatter bet float test.
	 */
	@Test
	public void formatterBetFloatTest() {
		Float odd = new Float(550.5648);
		String formattedOdd = "";
		double oddDouble = odd;

		formattedOdd = FormatterUtil.formatBet(odd, 0);
		assertEquals(formattedOdd, "551");

		formattedOdd = FormatterUtil.formatBet(odd, 1);
		assertEquals(formattedOdd, "550.6");

		formattedOdd = FormatterUtil.formatBet(odd, 2);
		assertEquals(formattedOdd, "550.56");

		formattedOdd = FormatterUtil.formatBet(odd, 3);
		assertEquals(formattedOdd, "550.565");

		formattedOdd = FormatterUtil.formatBet(odd, 4);
		assertEquals(formattedOdd, "550.5648");

		formattedOdd = FormatterUtil.formatBet(odd, 5);
		assertEquals(FormatterUtil.formatBet(oddDouble, 5), formattedOdd);

		formattedOdd = FormatterUtil.formatBet(odd, 6);
		assertEquals(FormatterUtil.formatBet(oddDouble, 6), formattedOdd);

	}

	/**
	 * Formatter bet test.
	 */
	@Test
	public void formatterBetTest() {
		String odd = "2.564582";
		String formattedOdd = "";
		double oddDouble = Double.valueOf(odd);

		formattedOdd = FormatterUtil.formatBet(odd, 2);

		assertTrue(formattedOdd.split("\\.")[1].length() == 2);
		assertEquals(formattedOdd, "2.56");

		formattedOdd = FormatterUtil.formatBet(odd, 3);
		assertTrue(formattedOdd.split("\\.")[1].length() == 3);
		assertEquals(formattedOdd, "2.565");

		formattedOdd = FormatterUtil.formatBet(odd, 4);
		assertTrue(formattedOdd.split("\\.")[1].length() == 4);
		assertEquals(formattedOdd, "2.5646");

		formattedOdd = FormatterUtil.formatBet(odd, 5);
		assertTrue(formattedOdd.split("\\.")[1].length() == 5);
		assertEquals(formattedOdd, "2.56458");

		formattedOdd = FormatterUtil.formatBet(odd, 6);
		assertEquals(formattedOdd, "2.564582");

		formattedOdd = FormatterUtil.formatBet(odd, 7);
		assertEquals(FormatterUtil.formatBet(oddDouble, 7), formattedOdd);

	}

}
