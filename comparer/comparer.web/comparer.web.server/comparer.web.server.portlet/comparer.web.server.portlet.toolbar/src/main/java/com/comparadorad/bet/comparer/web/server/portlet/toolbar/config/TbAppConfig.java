/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.portlet.toolbar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.comparadorad.bet.comparer.web.server.mvc.toolbar.config.WebServerMvcToolbarConfig;
import com.comparadorad.bet.comparer.web.server.portlet.core.config.AbstractAppConfig;

/**
 * The Class AppConfig.
 */
@Configuration
@Import(value = { WebServerMvcToolbarConfig.class })
public class TbAppConfig extends AbstractAppConfig {
}
