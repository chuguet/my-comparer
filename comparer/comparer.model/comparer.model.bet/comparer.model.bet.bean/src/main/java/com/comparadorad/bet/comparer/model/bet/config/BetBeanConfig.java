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
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * The Class BetBeanConfig.
 */
@Configuration
@ComponentScan("com.comparadorad.bet.comparer.model.bet.bean")
public class BetBeanConfig {

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
