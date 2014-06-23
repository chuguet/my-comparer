/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.comparadorad.bet.comparer.communication.producer.config.ProducerConfig;
import com.comparadorad.bet.comparer.model.valuebet.config.ValueBetServiceConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class SpringConfiguration.
 */
@Configuration
@EnableScheduling
@Import( value = { ProducerConfig.class, ValueBetServiceConfig.class} )
@Profile(value = { ProfileConstant.PRODUCTION })
public class CommunicationValueBetsConfig extends AbstractCommunicationValueBets {
	
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
