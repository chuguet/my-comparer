/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.portlet.securebet.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.comparadorad.bet.comparer.web.server.portlet.core.config.AbstractAppConfig;

/**
 * The Class TbSecurityAppConfig.
 */
@Configuration
@ComponentScan("com.comparadorad.bet.comparer.web.server.security")
@ImportResource(value = "classpath:/spring-security.xml")
public class SureBetSecurityAppConfig extends AbstractAppConfig {
}
