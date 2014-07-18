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

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AppConfig.
 */
@Configuration
@Profile(value = { ProfileConstant.TEST, ProfileConstant.DEV,
		ProfileConstant.PREPRODUCTION, ProfileConstant.PRODUCTION })
public abstract class AbstractAppConfig {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(AbstractAppConfig.class);

	/**
	 * Instantiates a new app config.
	 */
	public AbstractAppConfig() {
		super();
		LOG.info("Initializing config: " + getClass().getName());
	}

	/**
	 * Config name.
	 * 
	 * @return the string
	 */
	@Bean
	public String configName() {
		LOG.info("Initializing config: " + getClass().getName());
		return getClass().getName();
	}

}
