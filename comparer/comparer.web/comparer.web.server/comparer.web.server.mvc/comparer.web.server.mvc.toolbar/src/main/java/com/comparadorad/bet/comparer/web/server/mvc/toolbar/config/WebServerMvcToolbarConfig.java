/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.toolbar.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.comparadorad.bet.comparer.model.bet.config.BetServiceConfig;
import com.comparadorad.bet.comparer.model.config.service.config.ConfigServiceConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.web.server.mvc.core.config.WebServerMvcCoreConfig;
import com.comparadorad.bet.comparer.web.server.redirection.config.WebServerRedirectionCoreConfig;

/**
 * The Class WebServerMvcToolbarConfig.
 */
@Configuration
@Import(value = { WebServerMvcCoreConfig.class, ConfigServiceConfig.class,
		WebServerRedirectionCoreConfig.class, WebServerMvcCoreConfig.class,
		BetServiceConfig.class })
@ComponentScan("com.comparadorad.bet.comparer.web.server.mvc.toolbar")
@Profile(value = { ProfileConstant.TEST, ProfileConstant.DEV,
		ProfileConstant.PREPRODUCTION, ProfileConstant.PRODUCTION })
@EnableScheduling
public class WebServerMvcToolbarConfig {

}