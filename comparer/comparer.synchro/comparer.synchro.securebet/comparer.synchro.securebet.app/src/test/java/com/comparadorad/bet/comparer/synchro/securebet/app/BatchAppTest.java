/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.app;

import org.junit.Test;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class BatchAppTest.
 */
public class BatchAppTest {
	
	/**
	 * Test.
	 */
	@Test
	public final void test(){
		System.setProperty("spring.profiles.active", ProfileConstant.TEST);
		BatchSecureBetApp.main(new String[] {});
	}

}
