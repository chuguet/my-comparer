/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */

package com.comparadorad.bet.comparer.synchro.securebet.process.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.comparadorad.bet.comparer.communication.surebets.config.CommunicationSurebetsConfig;
import com.comparadorad.bet.comparer.communication.surebets.config.CommunicationSurebetsConfigTest;
import com.comparadorad.bet.comparer.model.securebet.service.config.SecureBetServiceConfig;
import com.comparadorad.bet.comparer.synchro.securebet.core.config.SynchroSecureBetCoreConfig;
import com.comparadorad.bet.comparer.synchro.securebet.writer.config.SynchroSecureBetWriterConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;


/**
 * The Class SynchroSecureBetProcessConfig.
 */
@Configuration
@ComponentScan({ "com.comparadorad.bet.comparer.synchro.securebet.process" })
@PropertySource({ "classpath:/SynchroBetSecureProcessConfig.properties" })
@Import(value = { SynchroSecureBetCoreConfig.class,
		SynchroSecureBetWriterConfig.class, SecureBetServiceConfig.class,
		CommunicationSurebetsConfig.class, CommunicationSurebetsConfigTest.class, CommunicationSurebetsConfig.class })
@Profile(value = { ProfileConstant.TEST, ProfileConstant.DEV,
		ProfileConstant.PREPRODUCTION, ProfileConstant.PRODUCTION })
public class SynchroSecureBetProcessConfig {
	
	/**
	 * Property sources placeholder configurer.
	 *
	 * @return the property sources placeholder configurer
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
