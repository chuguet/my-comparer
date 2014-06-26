/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.model.repository.config.ConfigRepositoryConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.logger.config.SpringSynchroLogConfig;

/**
 * The Class ConfigServiceConfigTest.
 */
@Configuration
@Import({ ConfigRepositoryConfig.class, SpringSynchroLogConfig.class })
@ComponentScan({ "com.comparadorad.bet.comparer.model.config.service" })
@Profile(value = { ProfileConstant.TEST })
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigServiceConfigTest {

}