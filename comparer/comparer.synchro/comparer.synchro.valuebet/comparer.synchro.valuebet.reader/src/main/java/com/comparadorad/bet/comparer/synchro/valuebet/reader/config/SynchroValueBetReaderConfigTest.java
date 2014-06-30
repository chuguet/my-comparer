/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.reader.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.comparadorad.bet.comparer.model.bet.config.BetServiceConfigTest;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.web.server.util.config.WebServerUtilCoreConfigTest;

/**
 * The Class SynchroValueBetReaderConfigTest.
 */
@Configuration
@PropertySource({ "classpath:/readerValueBetQuantityBets.properties" })
@Import(value = { WebServerUtilCoreConfigTest.class, BetServiceConfigTest.class })
@ComponentScan({ "com.comparadorad.bet.comparer.synchro.valuebet" })
@Profile(value = { ProfileConstant.TEST })
public class SynchroValueBetReaderConfigTest {

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
