/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker;

import com.comparadorad.bet.comparer.util.batch.AbstractBatchReaderAppLauncher;

/**
 * The Class BatchReaderAppLauncherTest.
 */
public class BatchReaderAppLauncherTest extends AbstractBatchReaderAppLauncher {

	/** {@inheritDoc} */
	@Override
	protected void launch() {
		launchJobs();
	}

	@Override
	protected String getJobName() {
		return "jobBet";
	}

}
