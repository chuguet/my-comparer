/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.activator.config;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.comparadorad.bet.comparer.model.activator.service.IActivatorMatch;
import com.comparadorad.bet.comparer.model.activator.service.IEnvironmentActivatorMatch;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.logger.config.SpringSynchroLogConfig;

/**
 * The Class BetServiceConfig.
 */
@Configuration
@Import(SpringSynchroLogConfig.class)
@ComponentScan("com.comparadorad.bet.comparer.model.activator")
@Profile(value = { ProfileConstant.TEST, ProfileConstant.DEV,
		ProfileConstant.PREPRODUCTION, ProfileConstant.PRODUCTION })
public class ActivatorServiceConfig {

	@Inject
	private Environment environment;

	@Inject
	private List<IEnvironmentActivatorMatch> environmentActivatorMatchs;

	@Bean
	public IActivatorMatch activatorMatch() {
		IActivatorMatch result = null;
		for (IEnvironmentActivatorMatch environmentActivatorMatch : environmentActivatorMatchs) {
			if (ArrayUtils.contains(environment.getActiveProfiles(),
					environmentActivatorMatch.getEnviroment())) {
				result = environmentActivatorMatch;
				break;
			}
		}
		return result;

	}

}
