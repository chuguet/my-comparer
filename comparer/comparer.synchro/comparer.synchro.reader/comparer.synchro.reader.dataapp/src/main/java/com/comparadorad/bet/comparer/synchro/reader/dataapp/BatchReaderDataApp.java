/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.synchro.reader.app.AbstractBatchApp;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.config.SynchroReaderDataAppConfig;
import com.comparadorad.bet.comparer.synchro.reader.dataapp.config.SynchroReaderDataAppTestConfig;

/**
 * The Class BatchApp.
 */
public class BatchReaderDataApp extends AbstractBatchApp {

	/** The Constant FILE_CONFIGURATION. */
	private static final Log LOG = LogFactory.getLog(BatchReaderDataApp.class);

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		LOG.info("Batch app for correction database");
		BatchReaderDataApp batchReaderDataApp = new BatchReaderDataApp();
		batchReaderDataApp.startApp();
	}

	/** {@inheritDoc} */
	@Override
	public Class<?>[] getConfigClass() {
		return new Class<?>[] { SynchroReaderDataAppConfig.class,
				SynchroReaderDataAppTestConfig.class };
	}

}
