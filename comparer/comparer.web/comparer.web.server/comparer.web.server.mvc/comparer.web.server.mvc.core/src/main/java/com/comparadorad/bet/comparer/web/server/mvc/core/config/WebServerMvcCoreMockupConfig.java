/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.comparadorad.bet.comparer.web.server.redirection.config.WebServerRedirectionCoreConfig;

/**
 * The Class WebServerMvcCoreConfig.
 */
@Configuration
@EnableWebMvc
@Import(value = { WebServerRedirectionCoreConfig.class })
@ComponentScan({ "com.comparadorad.bet.comparer.web.server.mvc.core.config" })
@ImportResource("classpath*:/WebServerMvcCoreMockupConfig.xml")
@Profile({ "client_notworking" })
public class WebServerMvcCoreMockupConfig {

}