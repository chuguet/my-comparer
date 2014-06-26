/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.dataapp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AbstractCreateData.
 */
abstract class AbstractCreateData {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(AbstractCreateData.class);

	/**
	 * Launch.
	 */
	protected void launch() {
		AnnotationConfigApplicationContext context;
		context = new AnnotationConfigApplicationContext();
		((ConfigurableApplicationContext) context).getEnvironment()
				.setActiveProfiles(getProfile(),
						ProfileConstant.CREATE_TEST_DATA);
		context.register(getConfigClass());
		context.refresh();
		LOG.info("Data created in:" + getProfile());
	}

	/**
	 * Gets the profile.
	 * 
	 * @return the profile
	 */
	protected abstract String getProfile();

	/**
	 * Gets the config class.
	 * 
	 * @return the config class
	 */
	protected abstract Class<?> getConfigClass();
}
