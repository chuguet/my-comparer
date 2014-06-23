/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.producer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.communication.core.config.QueueCoreConfigTest;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class ConsumerConfigTest.
 */
@Configuration
@Import({QueueCoreConfigTest.class})
@Profile(value = { ProfileConstant.TEST })
public class ProducerConfigTest extends AbstractProducerConfig {	
	
	
}
