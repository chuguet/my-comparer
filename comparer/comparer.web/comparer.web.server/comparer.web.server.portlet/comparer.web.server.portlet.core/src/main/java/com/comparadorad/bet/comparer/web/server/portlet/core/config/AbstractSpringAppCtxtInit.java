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
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class SpringAppContextInitializer.
 */
public abstract class AbstractSpringAppCtxtInit implements
		ApplicationContextInitializer<ConfigurableApplicationContext> {

	/** The LOG. */
	private static Log LOG = LogFactory
			.getLog(AbstractSpringAppCtxtInit.class);

	/**
	 * Initialize.
	 * 
	 * @param applicationContext
	 *            the application context {@inheritDoc}
	 */
	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		ConfigurableEnvironment environment = applicationContext
				.getEnvironment();
		
		// try {
		String env = System.getProperty("comparer.env");
		if (env != null) {
			environment.setActiveProfiles(env);
		} else {
			environment.setActiveProfiles(ProfileConstant.DEV);
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("Active profiles: ");
			for (String profile : environment.getActiveProfiles()) {
				LOG.debug(profile);
			}
		}

		/*
		 * environment.getPropertySources().addFirst( new
		 * ResourcePropertySource("classpath:env.properties"));
		 */

		LOG.info("env.properties loaded");
		// } catch (IOException e) {
		// // it's ok if the file is not there. we will just log that info.
		// LOG.info("didn't find env.properties in classpath so not loading it in the AppContextInitialized");
		// }
	}
}