/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.commons.math;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * The Class MathUtilTest.
 */
public class MathUtilTest {

	/**
	 * Redondear test.
	 */
	@Test
	public void redondearTest() {
		double numero = 2.56878;
		String redondeado = "";

		redondeado = MathUtil.redondear(numero, 2);

		assertTrue(redondeado.split("\\.")[1].length() == 2);

		redondeado = MathUtil.redondear(numero, 3);
		assertTrue(redondeado.split("\\.")[1].length() == 3);
	}

}
