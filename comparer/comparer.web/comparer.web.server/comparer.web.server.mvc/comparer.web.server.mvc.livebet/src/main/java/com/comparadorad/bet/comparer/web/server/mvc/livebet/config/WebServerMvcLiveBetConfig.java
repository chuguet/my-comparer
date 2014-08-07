/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.livebet.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableAsync;

import com.comparadorad.bet.comparer.model.bet.config.BetServiceConfig;
import com.comparadorad.bet.comparer.util.cache.config.CacheConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.web.server.mvc.core.config.WebServerMvcCoreConfig;
import com.comparadorad.bet.comparer.web.server.redirection.config.WebServerRedirectionCoreConfig;
import com.comparadorad.bet.comparer.web.server.util.config.WebServerUtilCoreConfig;

/**
 * The Class WebServerMvcMatchConfig.
 */
@Configuration
@EnableAsync
@Import(value = { WebServerMvcCoreConfig.class, BetServiceConfig.class,
		WebServerRedirectionCoreConfig.class, WebServerUtilCoreConfig.class, CacheConfig.class })
@ComponentScan({ "com.comparadorad.bet.comparer.web.server.mvc.livebet" })
@Profile(value = { ProfileConstant.TEST, ProfileConstant.DEV,
		ProfileConstant.PREPRODUCTION, ProfileConstant.PRODUCTION })
public class WebServerMvcLiveBetConfig {

}