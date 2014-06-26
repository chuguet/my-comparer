/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app;

import com.comparadorad.bet.comparer.synchro.reader.app.config.SynchroReaderAppConfig;
import com.comparadorad.bet.comparer.synchro.reader.app.config.SynchroReaderAppTestConfig;

/**
 * The Class BatchApp.
 */
public class BatchReaderApp extends AbstractBatchApp {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		BatchReaderApp batchReaderApp = new BatchReaderApp();
		batchReaderApp.startApp();
	}

	/**
	 * Gets the config class.
	 * 
	 * @return the config class {@inheritDoc}
	 */
	@Override
	public Class<?>[] getConfigClass() {
		return new Class<?>[] { SynchroReaderAppConfig.class,
				SynchroReaderAppTestConfig.class };
	}

}
