/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.synchro.valuebet.app.launcher.BatchValueBetAppLauncherTest;
import com.comparadorad.bet.comparer.util.batch.AbstractBatchReaderAppLauncher;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;


/**
 * The Class SynchroValueBetBatchAppConfig.
 */
@Configuration
@Profile(value = { ProfileConstant.DEV, ProfileConstant.PREPRODUCTION,
	ProfileConstant.PRODUCTION })
public class SynchroValueBetBatchAppConfig extends AbstractSynchroValueBetBatchAppConfig {

	 /** {@inheritDoc} */
	@Bean
	@Override
	public AbstractBatchReaderAppLauncher batchReaderAppLauncher() {
		return new BatchValueBetAppLauncherTest();
	}

	 /** {@inheritDoc} */ 
	@Override
	public String launchTest() {
		return null;
	}
	

}
