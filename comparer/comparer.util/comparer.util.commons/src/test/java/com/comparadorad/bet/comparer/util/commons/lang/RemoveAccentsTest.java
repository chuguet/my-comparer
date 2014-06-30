/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.commons.lang;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The Class RemoveAccentsTest.
 */
public class RemoveAccentsTest {

	/**
	 * Test.
	 */
	@Test
	public void normalizeString() {
		String cadenaSucia = "Gönzález Martín";
		String cadenaLimpia = RemoveAccents.normalizeString(cadenaSucia);
		assertEquals(cadenaLimpia, "Gonzalez Martin");
	}
}
