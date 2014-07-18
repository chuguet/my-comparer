/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.portlet.core.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * The Class AppConfig.
 */
@Configuration
@Profile({ "client" })
public abstract class AbstractAppMockupConfig {
	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(AbstractAppMockupConfig.class);

	/**
	 * Instantiates a new app config.
	 */
	public AbstractAppMockupConfig() {
		super();
		LOG.info("Initializing config: " + getClass().getName());
	}

	@Bean
	public String configName() {
		LOG.info("Initializing config: " + getClass().getName());
		return getClass().getName();
	}
}
