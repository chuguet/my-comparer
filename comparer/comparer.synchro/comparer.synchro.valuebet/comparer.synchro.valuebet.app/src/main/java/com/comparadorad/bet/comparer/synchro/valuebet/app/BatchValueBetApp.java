/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.app;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.synchro.valuebet.app.config.SynchroValueBetBatchAppConfig;
import com.comparadorad.bet.comparer.synchro.valuebet.app.config.SynchroValueBetBatchAppConfigTest;

/**
 * The Class BatchValueBetApp.
 */
public class BatchValueBetApp extends AbstractApp {
	
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(BatchValueBetApp.class);

	/**
	 * Gets the config class.
	 * 
	 * @return the config class {@inheritDoc}
	 */
	@Override
	public Class<?>[] getConfigClass() {
		return new Class<?>[] { SynchroValueBetBatchAppConfig.class,
				SynchroValueBetBatchAppConfigTest.class };
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		BatchValueBetApp app = new BatchValueBetApp();
		app.startApp();
		LOG.info("Batch app for obtaining value bet...");
	}

}
