/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp.config;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.comparadorad.bet.comparer.model.config.service.config.ConfigServiceConfig;
import com.comparadorad.bet.comparer.model.log.service.config.LogServiceConfig;
import com.comparadorad.bet.comparer.util.batch.config.AbstractBatchAppConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileUtil;
import com.comparadorad.bet.comparer.util.commons.string.StringUtil;

/**
 * The Class EmbededMongoConfig.
 */
@Configuration
@ImportResource({
		"classpath*:/application-context-job-repository-data-test.xml",
		"classpath*:/SynchroReaderDataAppConfig-job-repository.xml",
		"classpath*:/SynchroReaderDataAppConfig.xml" })
@Import({ ConfigServiceConfig.class, LogServiceConfig.class, StringUtil.class })
@ComponentScan({
		"com.comparadorad.bet.comparer.synchro.reader.dataapp.bookmaker",
		"com.comparadorad.bet.comparer.synchro.reader.dataapp.parameters" })
public abstract class AbstractSynchroReaderDataAppConfig extends
		AbstractBatchAppConfig {

	/** The application context. */
	@Inject
	private ApplicationContext applicationContext;

	/**
	 * Synchro reader data app params.
	 * 
	 * @return the synchro reader data app params
	 */
	@Bean
	public SynchroReaderDataAppParams synchroReaderDataAppParams() {
		SynchroReaderDataAppParams appParams = new SynchroReaderDataAppParams();
		if (ProfileUtil.containsProfile(
				ProfileConstant.DATA_APP_CORRECT_DATABASE, applicationContext
						.getEnvironment().getActiveProfiles())) {
			appParams.setCorrectDatabaseData(true);
		}
		return appParams;
	}

}
