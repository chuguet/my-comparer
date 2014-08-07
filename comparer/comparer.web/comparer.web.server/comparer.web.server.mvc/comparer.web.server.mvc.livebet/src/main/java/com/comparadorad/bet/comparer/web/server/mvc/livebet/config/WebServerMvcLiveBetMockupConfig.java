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

import com.comparadorad.bet.comparer.model.bet.config.BetServiceConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.web.server.mvc.core.config.WebServerMvcCoreMockupConfig;
import com.comparadorad.bet.comparer.web.server.redirection.config.WebServerRedirectionCoreConfig;

/**
 * The Class WebServerMvcMatchMockupConfig.
 */
@Configuration
@Import(value = { WebServerMvcCoreMockupConfig.class, BetServiceConfig.class, WebServerRedirectionCoreConfig.class })
@ComponentScan({ "com.comparadorad.bet.comparer.web.server.mvc.livebet" })
@Profile({ "client", ProfileConstant.TEST })
public class WebServerMvcLiveBetMockupConfig {


}