/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.BatchReaderDataAppLauncherTest;
import com.comparadorad.bet.comparer.util.batch.AbstractBatchReaderAppLauncher;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class SynchroReaderDataAppTestConfig.
 */
@Configuration
@Profile(value = { ProfileConstant.TEST })
public class SynchroReaderDataAppTestConfig extends
		AbstractSynchroReaderDataAppConfig {

	/** {@inheritDoc} */
	@Bean
	public AbstractBatchReaderAppLauncher batchReaderAppLauncher() {
		return new BatchReaderDataAppLauncherTest();
	}

	@Override
	@Bean
	public String launchTest() {
		return doLaunchTest();
	}
}
