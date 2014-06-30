/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.comparadorad.bet.comparer.synchro.securebet.core.config.SynchroSecureBetCoreConfig;
import com.comparadorad.bet.comparer.synchro.securebet.historic.config.SynchroSecureBetHistoricConfig;

/**
 * The Class AbstractSynchroBetSecureBatchAppConfig.
 */
@Configuration
@ComponentScan({ "com.comparadorad.bet.comparer.synchro.securebet.app" })
@PropertySource("classpath:/config-batch.properties")
@Import({ SynchroSecureBetCoreConfig.class,
		SynchroSecureBetHistoricConfig.class })
public abstract class AbstractSynchroSecureBetBatchAppConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
