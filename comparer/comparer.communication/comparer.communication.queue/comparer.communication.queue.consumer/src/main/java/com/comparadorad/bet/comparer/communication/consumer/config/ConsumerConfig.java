/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.consumer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.comparadorad.bet.comparer.communication.core.config.QueueCoreConfig;

/**
 * The Class ClientConfig.
 */
@Configuration
@Import({ QueueCoreConfig.class })
public class ConsumerConfig extends AbstractConsumerConfig {

}
