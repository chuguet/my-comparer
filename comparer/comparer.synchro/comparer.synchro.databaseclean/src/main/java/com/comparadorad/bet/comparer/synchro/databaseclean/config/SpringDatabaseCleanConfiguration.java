/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.databaseclean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.comparadorad.bet.comparer.log.repository.config.LogRepositoryConfig;
import com.comparadorad.bet.comparer.model.bet.config.BetRepositoryConfig;
import com.comparadorad.bet.comparer.model.repository.config.ConfigRepositoryConfig;
import com.comparadorad.bet.comparer.model.securebet.repository.config.SecureBetRepositoryConfig;
import com.comparadorad.bet.comparer.model.valuebet.repository.config.ValueBetRepositoryConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class SpringCleanTaskConfiguration.
 */
@Configuration
@ComponentScan("com.comparadorad.bet.comparer.synchro.databaseclean")
@Import(value = { BetRepositoryConfig.class, ConfigRepositoryConfig.class,
		ValueBetRepositoryConfig.class, SecureBetRepositoryConfig.class, LogRepositoryConfig.class })
@PropertySource("DataConfiguration.properties")
@EnableScheduling
@Profile(value = { ProfileConstant.DEV, ProfileConstant.PREPRODUCTION,
		ProfileConstant.PRODUCTION, ProfileConstant.TEST })
public class SpringDatabaseCleanConfiguration {

	/**
	 * Validator.
	 * 
	 * @return the local validator factory bean
	 */
	@Bean
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}

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
