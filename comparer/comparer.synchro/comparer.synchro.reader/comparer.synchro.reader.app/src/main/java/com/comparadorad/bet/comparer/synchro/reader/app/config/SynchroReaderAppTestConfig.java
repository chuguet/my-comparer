/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.BatchReaderAppLauncherTest;
import com.comparadorad.bet.comparer.util.batch.AbstractBatchReaderAppLauncher;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.logger.config.SpringSynchroLogConfig;

/**
 * The Class SynchroReaderAppTestConfig.
 */
@Configuration
@Import({SpringSynchroLogConfig.class})
@ImportResource({ "classpath*:/application-context-job-repository-data-test.xml",
	"classpath*:/SynchroReaderAppConfig-job-repository.xml",
	"classpath*:/SynchroReaderAppConfig.xml" })
@Profile(value = { ProfileConstant.TEST })
public class SynchroReaderAppTestConfig extends AbstractSynchroReaderAppConfig {

	/**
	 * Batch reader app launcher.
	 *
	 * @return the abstract batch reader app launcher
	 * {@inheritDoc}
	 */
	@Bean
	public AbstractBatchReaderAppLauncher batchReaderAppLauncher() {
		return new BatchReaderAppLauncherTest();
	}

	 /** {@inheritDoc} */ 
	@Override
	@Bean
	public String launchTest() {
		return doLaunchTest();
	}

}
