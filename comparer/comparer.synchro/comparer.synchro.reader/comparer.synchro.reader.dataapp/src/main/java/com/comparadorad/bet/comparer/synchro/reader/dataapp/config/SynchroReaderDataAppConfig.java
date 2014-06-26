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
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker.BatchReaderDataAppLauncher;
import com.comparadorad.bet.comparer.util.batch.AbstractBatchReaderAppLauncher;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.commons.string.StringUtil;
import com.comparadorad.bet.comparer.util.logger.config.SpringSynchroLogConfig;

/**
 * The Class SynchroReaderDataAppConfig.
 */
@Configuration
@Import(value = { StringUtil.class, SpringSynchroLogConfig.class})
@Profile(value = {ProfileConstant.DEV, ProfileConstant.TEST, ProfileConstant.PREPRODUCTION,
		ProfileConstant.PRODUCTION })
public class SynchroReaderDataAppConfig extends
		AbstractSynchroReaderDataAppConfig {

	/** {@inheritDoc} */
	@Bean
	public AbstractBatchReaderAppLauncher batchReaderAppLauncher() {
		return new BatchReaderDataAppLauncher();
	}
	
	@Override
	public String launchTest() {
		return null;
	}
}
