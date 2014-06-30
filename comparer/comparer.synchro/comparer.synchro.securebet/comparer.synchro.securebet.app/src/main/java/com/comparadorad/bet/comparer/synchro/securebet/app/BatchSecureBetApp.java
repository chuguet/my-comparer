/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.app;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.synchro.securebet.app.config.SynchroSecureBetBatchAppConfigTest;
import com.comparadorad.bet.comparer.synchro.securebet.app.config.SynchroSecureBetBatchAppConfig;

/**
 * The Class BatchBetSecureApp.
 */
public class BatchSecureBetApp extends AbstractApp {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(AbstractApp.class);

	/**
	 * Gets the config class.
	 * 
	 * @return the config class {@inheritDoc}
	 */
	@Override
	public Class<?>[] getConfigClass() {
		return new Class<?>[] { SynchroSecureBetBatchAppConfig.class,
				SynchroSecureBetBatchAppConfigTest.class };
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		BatchSecureBetApp app = new BatchSecureBetApp();
		app.startApp();
		LOG.info("Batch app for obtaining secure bet...");
	}

}
