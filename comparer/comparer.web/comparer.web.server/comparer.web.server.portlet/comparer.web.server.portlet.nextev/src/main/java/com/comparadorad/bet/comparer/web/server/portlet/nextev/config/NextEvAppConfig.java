/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.portlet.nextev.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.comparadorad.bet.comparer.web.server.mvc.livebet.config.WebServerMvcLiveBetConfig;
import com.comparadorad.bet.comparer.web.server.portlet.core.config.AbstractAppConfig;

/**
 * The Class AppConfig.
 */
@Configuration
@Import(value = { WebServerMvcLiveBetConfig.class})
public class NextEvAppConfig extends AbstractAppConfig {
}
