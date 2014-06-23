/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.util.cache.config.CacheConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class BetServiceConfig.
 */
@Configuration
@Import({ BetRepositoryConfig.class, CacheConfig.class })
@ComponentScan({ "com.comparadorad.bet.comparer.model.bet.service",
		"com.comparadorad.bet.comparer.model.bet.activator" })
@Profile(value = { ProfileConstant.TEST, ProfileConstant.DEV,
		ProfileConstant.PREPRODUCTION, ProfileConstant.PRODUCTION })
public class BetServiceConfig {

}
