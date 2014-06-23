/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.dbsynchro.usertask;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.dbsynchro.usertask.task.IUpdateAutoSender;

/**
 * The Class UpdateAutoSenderTest.
 */
public class UpdateAutoSenderTest extends AbstractTest {

	/** The update auto sender. */
	@Inject
	private IUpdateAutoSender updateAutoSender;

	/**
	 * Update auto sender test.
	 */
	@Test
	public final void updateAutoSenderTest() {
		updateAutoSender.updateExternalSystem();
	}

}
