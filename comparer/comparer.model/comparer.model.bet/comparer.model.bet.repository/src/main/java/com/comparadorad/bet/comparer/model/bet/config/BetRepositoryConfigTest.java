/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.comparadorad.bet.comparer.model.dbcore.config.SpringMongoTestConfig;
import com.comparadorad.bet.comparer.model.repository.config.ConfigRepositoryConfigTest;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class BetRepositoryConfigTest.
 */
@Configuration
@Profile(value = { ProfileConstant.TEST })
@Import(value = { SpringMongoTestConfig.class, ConfigRepositoryConfigTest.class })
@EnableMongoRepositories(basePackages = "com.comparadorad.bet.comparer.model.bet.repository", repositoryImplementationPostfix = "CustomImpl")
@ComponentScan({ "com.comparadorad.bet.comparer.model.bet.repository.dbinit" })
public abstract class BetRepositoryConfigTest {

	/**
	 * Gets the local validator factory bean config.
	 * 
	 * @return the local validator factory bean config
	 */
	@Bean
	public LocalValidatorFactoryBean getLocalValidatorFactoryBeanConfig() {
		return new LocalValidatorFactoryBean();
	}

}
