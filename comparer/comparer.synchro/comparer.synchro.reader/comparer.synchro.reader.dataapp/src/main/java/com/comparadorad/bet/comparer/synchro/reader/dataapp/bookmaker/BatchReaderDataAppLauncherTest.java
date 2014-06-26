/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker;

import com.comparadorad.bet.comparer.util.batch.AbstractBatchReaderAppLauncher;

/**
 * The Class BatchReaderDataAppLauncherTest.
 */
public class BatchReaderDataAppLauncherTest extends
		AbstractBatchReaderAppLauncher {

	/**
	 * Launch.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected void launch() {
		launchJobs();
	}

	/** {@inheritDoc} */
	@Override
	protected String getJobName() {
		return "jobBatchReaderData";
	}

}
