/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.portlet.valuebet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.comparadorad.bet.comparer.web.server.mvc.valuebet.config.WebServerMvcValueBetConfig;
import com.comparadorad.bet.comparer.web.server.portlet.core.config.AbstractAppConfig;

/**
 * The Class AppConfig.
 */
@Configuration
@Import(value = { WebServerMvcValueBetConfig.class})
public class ValueBetAppConfig extends AbstractAppConfig {
}
