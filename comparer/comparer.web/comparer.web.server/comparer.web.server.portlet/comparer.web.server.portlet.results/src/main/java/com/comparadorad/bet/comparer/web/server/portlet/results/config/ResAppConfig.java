/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.portlet.results.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.comparadorad.bet.comparer.web.server.mvc.match.config.WebServerMvcMatchConfig;
import com.comparadorad.bet.comparer.web.server.portlet.core.config.AbstractAppConfig;

/**
 * The Class AppConfig.
 */
@Configuration
@Import(value = { WebServerMvcMatchConfig.class })
public class ResAppConfig extends AbstractAppConfig {
}
