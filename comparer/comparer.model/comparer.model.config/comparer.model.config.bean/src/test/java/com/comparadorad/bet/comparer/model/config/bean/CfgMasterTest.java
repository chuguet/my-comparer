/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgMaster.StrikeConfig;

/**
 * The Class CfgMasterTest.
 */
public class CfgMasterTest {

	/**
	 * Test get strike config.
	 */
	@Test
	public void testGetStrikeConfig() {
		CfgMaster master = new CfgMaster();
		master.add(new StrikeConfig(10, "0.90", "0.95", "0.2"));
		master.add(new StrikeConfig(20, "0.85", "0.90", "0.2"));
		master.add(new StrikeConfig(30, "0.80", "0.85", "0.2"));
		master.add(new StrikeConfig(null, "0.75", "0.70", "0.2"));

		assertTrue(master.getStrikeConfig(9).getNumberOfChar().intValue() == 10);
		assertTrue(master.getStrikeConfig(10).getNumberOfChar().intValue() == 10);
		assertTrue(master.getStrikeConfig(11).getNumberOfChar().intValue() == 20);
		assertTrue(master.getStrikeConfig(22).getNumberOfChar().intValue() == 30);
		assertTrue(master.getStrikeConfig(30).getNumberOfChar().intValue() == 30);
		assertTrue(master.getStrikeConfig(31).getNumberOfChar() == null);
	}

}
