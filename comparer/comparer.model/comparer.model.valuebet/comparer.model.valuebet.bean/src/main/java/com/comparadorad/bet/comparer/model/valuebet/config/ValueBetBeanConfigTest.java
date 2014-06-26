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

import com.comparadorad.bet.comparer.model.bet.config.BetServiceConfigTest;
import com.comparadorad.bet.comparer.model.repository.config.ConfigRepositoryConfigTest;

/**
 * The Class ValueBetBeanConfigTest.
 */
@Configuration
@Import({ BetServiceConfigTest.class, ConfigRepositoryConfigTest.class })
public class ValueBetBeanConfigTest {

}
