/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.app.launcher;

import org.springframework.scheduling.annotation.Scheduled;

import com.comparadorad.bet.comparer.util.batch.AbstractBatchReaderAppLauncher;

/**
 * The Class BatchValueBetAppLauncher.
 */
public class BatchValueBetAppLauncher extends AbstractBatchReaderAppLauncher {

	/** The Constant NAME. */
	private final static String NAME = "batchValueBet";

	/** {@inheritDoc} */
	@Override
	protected String getJobName() {
		return NAME;
	}

	/** {@inheritDoc} */
	@Scheduled(fixedDelay = 1)
	@Override
	protected void launch() {
		launchJobs();
	}

}
