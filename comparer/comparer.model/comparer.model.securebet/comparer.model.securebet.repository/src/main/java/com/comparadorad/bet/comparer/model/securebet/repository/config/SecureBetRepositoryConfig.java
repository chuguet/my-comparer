/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.securebet.repository.config;

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
import com.comparadorad.bet.comparer.model.securebet.config.SecureBetBeanConfiguration;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class ConfigRepositoryConfig.
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.comparadorad.bet.comparer.model.securebet.repository", repositoryImplementationPostfix = "CustomImpl")
@Import(value = { SpringMongoProdConfig.class, SpringMongoPreProdConfig.class,
		SpringMongoTestConfig.class, SpringMongoDevConfig.class,
		SecureBetBeanConfiguration.class })
@Profile(value = { ProfileConstant.TEST, ProfileConstant.DEV,
		ProfileConstant.PREPRODUCTION, ProfileConstant.PRODUCTION })
@ComponentScan({ "com.comparadorad.bet.comparer.model.securebet.repository.dbinit" })
public class SecureBetRepositoryConfig {

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