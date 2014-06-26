/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.valuebet.repository.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.comparadorad.bet.comparer.model.bet.config.BetRepositoryConfigTest;
import com.comparadorad.bet.comparer.model.dbcore.config.SpringMongoTestConfig;
import com.comparadorad.bet.comparer.model.valuebet.config.ValueBetBeanConfigTest;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class ValueBetRepositoryConfigTest.
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.comparadorad.bet.comparer.model.valuebet.repository", repositoryImplementationPostfix = "CustomImpl")
@Import(value = { SpringMongoTestConfig.class, BetRepositoryConfigTest.class,
		ValueBetBeanConfigTest.class })
@Profile(value = { ProfileConstant.TEST, ProfileConstant.TEST_NO_CREATE_DATA })
@ComponentScan({ "com.comparadorad.bet.comparer.model.valuebet.repository.dbinit" })
public class ValueBetRepositoryConfigTest {

	/**
	 * Gets the local validator factory bean config.
	 * 
	 * @return the local validator factory bean config
	 */
	@Bean(name = "localValidatorFactoryBean")
	public LocalValidatorFactoryBean getLocalValidatorFactoryBeanConfig() {
		return new LocalValidatorFactoryBean();
	}

}