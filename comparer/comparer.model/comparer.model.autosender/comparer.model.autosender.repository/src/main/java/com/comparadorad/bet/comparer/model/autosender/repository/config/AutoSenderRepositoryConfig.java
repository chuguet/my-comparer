/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.repository.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.model.autosender.config.AutoSenderBeanConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AutoSenderRepositoryConfig.
 */
@Configuration
@Import(AutoSenderBeanConfig.class)
@Profile(value = { ProfileConstant.DEV, ProfileConstant.PREPRODUCTION, ProfileConstant.PRODUCTION  })
public class AutoSenderRepositoryConfig extends AbstractAutoSenderRepositoryConfig {
}
