/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.config;

import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest;

/**
 * The Class ActiveSportsTest.
 */
public class ActiveSportsTest extends AbstractTest {

	/** The active sports. */
	@Inject
	private ConfiguredSports activeSports;

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
		String sportName = "Prueba";

		// Deporte que no existe en la lista de activos
		Boolean result = activeSports.isActiveSport(sportName);
		assertTrue(result.equals(false));

		sportName = "Football";
		// Deporte que si existe en la lista de activos
		result = activeSports.isActiveSport(sportName);
		assertTrue(result.equals(true));

	}

	/**
	 * Test que prueba la validez de una apuesta permitida para el deporte dado
	 */
	@Test
	public void test_availableBet_betAvailable() {
		String sportName = "Football";

		// Apuesta permitida para el deporte futbol
		String betName = "1X2";

		Boolean result = activeSports.isAvailableBet(betName, sportName);

		assertTrue(result == Boolean.TRUE);
	}
	
	/**
	 * Test que prueba la invalidez de una apuesta permitida para el deporte dado
	 */
	@Test
	public void test_availableBet_betNotAvailable() {
		String sportName = "Tennis";

		// Apuesta permitida para el deporte futbol
		String betName = "1X2";

		Boolean result = activeSports.isAvailableBet(betName, sportName);

		assertTrue(result == Boolean.FALSE);
	}

}
