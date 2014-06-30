/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.batch.config;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.comparadorad.bet.comparer.util.batch.AbstractBatchReaderAppLauncher;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileUtil;
import com.comparadorad.bet.comparer.util.logger.config.SpringSynchroLogConfig;

/**
 * The Class AbstractBatchAppConfig.
 */
@Configuration
@Import(SpringSynchroLogConfig.class)
public abstract class AbstractBatchAppConfig {
	/** The application context. */
	@Inject
	private ApplicationContext applicationContext;

	/**
	 * Batch reader app launcher.
	 * 
	 * @return the abstract batch reader app launcher
	 */
	public abstract AbstractBatchReaderAppLauncher batchReaderAppLauncher();

	/**
	 * Launch test.
	 *
	 * @return the string
	 */
	public abstract String launchTest();

	/**
	 * Launch.
	 * 
	 * @return the string
	 */
	protected String doLaunchTest() {
		// Simulation of the sheduling
		if (ProfileUtil.containsProfile(ProfileConstant.TEST,
				applicationContext.getEnvironment().getActiveProfiles())
				&& !ProfileUtil
						.containsProfile(ProfileConstant.TEST_NO_JOB_EXECUTION,
								applicationContext.getEnvironment()
										.getActiveProfiles())) {
			batchReaderAppLauncher().launchJobs();
		}
		return "ok";
	}
}
