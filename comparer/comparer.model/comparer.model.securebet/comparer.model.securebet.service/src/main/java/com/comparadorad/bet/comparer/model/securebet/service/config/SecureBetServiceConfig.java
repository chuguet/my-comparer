/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.securebet.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.model.securebet.repository.config.SecureBetRepositoryConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class ConfigServiceConfig.
 */
@Configuration
@Import(value = { SecureBetRepositoryConfig.class })
@ComponentScan({ "com.comparadorad.bet.comparer.model.securebet.service","com.comparadorad.bet.comparer.model.securebet.permission" })
@Profile(value = { ProfileConstant.TEST, ProfileConstant.DEV,
		ProfileConstant.PREPRODUCTION, ProfileConstant.PRODUCTION })
public class SecureBetServiceConfig {

}