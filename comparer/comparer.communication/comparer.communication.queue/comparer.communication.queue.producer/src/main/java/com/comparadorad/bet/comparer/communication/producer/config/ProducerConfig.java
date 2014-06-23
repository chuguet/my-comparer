/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.producer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.comparadorad.bet.comparer.communication.core.config.QueueCoreConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class ConsumerConfig.
 */
@Configuration
@Import({ QueueCoreConfig.class })
@Profile(value = { ProfileConstant.PRODUCTION, ProfileConstant.DEV, ProfileConstant.PREPRODUCTION })
public class ProducerConfig extends AbstractProducerConfig {
	
	/**
	 * Gets the local validator factory bean config.
	 *
	 * @return the local validator factory bean config
	 */
	@Bean(name = "producerValidator")
	public LocalValidatorFactoryBean getLocalValidatorFactoryBeanConfig() {
		return new LocalValidatorFactoryBean();
	}
}
