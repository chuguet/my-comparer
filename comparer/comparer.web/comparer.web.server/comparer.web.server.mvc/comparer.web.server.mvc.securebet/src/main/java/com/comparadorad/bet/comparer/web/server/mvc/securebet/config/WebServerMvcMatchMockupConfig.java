/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.securebet.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.web.server.mvc.core.config.WebServerMvcCoreMockupConfig;

/**
 * The Class WebServerMvcMatchMockupConfig.
 */
@Configuration
@Import(value = { WebServerMvcCoreMockupConfig.class })
@ComponentScan("com.comparadorad.bet.comparer.web.server.mvc.toolbar.controlmockup")
@Profile({ "client" })
public class WebServerMvcMatchMockupConfig {
	
	

}