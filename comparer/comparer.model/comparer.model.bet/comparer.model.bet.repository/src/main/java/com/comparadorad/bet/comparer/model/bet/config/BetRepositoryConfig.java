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

import com.comparadorad.bet.comparer.model.dbcore.config.SpringMongoDevConfig;
import com.comparadorad.bet.comparer.model.dbcore.config.SpringMongoPreProdConfig;
import com.comparadorad.bet.comparer.model.dbcore.config.SpringMongoProdConfig;
import com.comparadorad.bet.comparer.model.dbcore.config.SpringMongoTestConfig;
import com.comparadorad.bet.comparer.model.repository.config.ConfigRepositoryConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class BetRepositoryConfig.
 * 
 */
@Configuration
@Profile(value = { ProfileConstant.TEST, ProfileConstant.DEV,
		ProfileConstant.PREPRODUCTION, ProfileConstant.PRODUCTION })
@Import(value = { SpringMongoProdConfig.class, SpringMongoPreProdConfig.class,
		SpringMongoDevConfig.class, SpringMongoTestConfig.class,
		ConfigRepositoryConfig.class })
@EnableMongoRepositories(basePackages="com.comparadorad.bet.comparer.model.bet.repository",repositoryImplementationPostfix="CustomImpl")
@ComponentScan({ "com.comparadorad.bet.comparer.model.bet.repository.dbinit","com.comparadorad.bet.comparer.model.bet.repository.updatelog" })
public abstract class BetRepositoryConfig {

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
