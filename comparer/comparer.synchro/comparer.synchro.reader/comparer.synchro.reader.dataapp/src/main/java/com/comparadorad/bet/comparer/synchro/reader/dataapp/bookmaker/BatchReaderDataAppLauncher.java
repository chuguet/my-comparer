/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker;

import org.springframework.scheduling.annotation.Scheduled;

import com.comparadorad.bet.comparer.util.batch.AbstractBatchReaderAppLauncher;

/**
 * The Class BatchReaderDataAppLauncher.
 */
public class BatchReaderDataAppLauncher extends AbstractBatchReaderAppLauncher {

	/**
	 * Launch.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	@Scheduled(fixedDelay = 1000 * 3)
	protected void launch() {
		launchJobs();
	}

	/** {@inheritDoc} */
	@Override
	protected String getJobName() {
		return "jobBatchReaderData";
	}

}
