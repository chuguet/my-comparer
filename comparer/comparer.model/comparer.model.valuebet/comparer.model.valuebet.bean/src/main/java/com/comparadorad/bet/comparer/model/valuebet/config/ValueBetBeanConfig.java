/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.valuebet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.comparadorad.bet.comparer.model.bet.config.BetServiceConfig;
import com.comparadorad.bet.comparer.model.repository.config.ConfigRepositoryConfig;

/**
 * The Class ValueBetBeanConfig.
 */
@Configuration
@Import({ BetServiceConfig.class, ConfigRepositoryConfig.class })
public class ValueBetBeanConfig {

}
