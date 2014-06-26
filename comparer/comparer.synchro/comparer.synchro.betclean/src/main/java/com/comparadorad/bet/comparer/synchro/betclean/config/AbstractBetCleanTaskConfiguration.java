/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.betclean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.comparadorad.bet.comparer.model.bet.config.BetRepositoryConfig;
import com.comparadorad.bet.comparer.util.logger.config.SpringSynchroLogConfig;

/**
 * The Class AbstractBetCleanTaskConfiguration.
 */
@Configuration
@ComponentScan("com.comparadorad.bet.comparer.synchro.betclean")
@PropertySource("classpath:/DataConfiguration.properties")
@Import({ SpringSynchroLogConfig.class, BetRepositoryConfig.class })
public abstract class AbstractBetCleanTaskConfiguration {

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
