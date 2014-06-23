/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.integration.consumer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.integration.core.config.IntegrationConfiguration;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class IntegrationConsumerConfiguration.
 */
@Configuration
@Import(IntegrationConfiguration.class)
@ComponentScan("com.comparadorad.bet.comparer.integration.consumer")
@ImportResource(value = { "classpath*:/updaterBetsConsumer-application-context.xml" })
@Profile(value = { ProfileConstant.DEV, ProfileConstant.PREPRODUCTION,
		ProfileConstant.PRODUCTION, ProfileConstant.TEST })
public class IntegrationConsumerConfiguration {

	
}
