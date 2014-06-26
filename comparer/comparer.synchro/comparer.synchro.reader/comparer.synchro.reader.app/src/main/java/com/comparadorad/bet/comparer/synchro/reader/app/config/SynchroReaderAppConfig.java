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
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.comparadorad.bet.comparer.integration.producer.config.IntegrationProducerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.BatchReaderAppLauncher;
import com.comparadorad.bet.comparer.util.batch.AbstractBatchReaderAppLauncher;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.logger.config.SpringSynchroLogConfig;

/**
 * The Class SynchroReaderAppConfig.
 */
@Configuration
@Import({SpringSynchroLogConfig.class, IntegrationProducerConfiguration.class})
@ImportResource({
		"classpath*:/application-context-job-repository-data-test.xml",
		"classpath*:/SynchroReaderAppConfig-job-repository.xml",
		"classpath*:/SynchroReaderAppConfig.xml" })
@Profile(value = { ProfileConstant.DEV, ProfileConstant.PREPRODUCTION,
		ProfileConstant.PRODUCTION  })
@PropertySource({ "classpath:/config-batch.properties" })
public class SynchroReaderAppConfig extends AbstractSynchroReaderAppConfig {

	/**
	 * Property sources placeholder configurer.
	 * 
	 * @return the property sources placeholder configurer
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	/**
	 * Batch reader app launcher.
	 * 
	 * @return the abstract batch reader app launcher {@inheritDoc}
	 */
	@Bean
	public AbstractBatchReaderAppLauncher batchReaderAppLauncher() {
		return new BatchReaderAppLauncher();
	}

	/** {@inheritDoc} */
	@Override
	public String launchTest() {
		return null;
	}
}
