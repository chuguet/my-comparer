/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.activator.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class BetServiceConfigTest.
 */
@Configuration
@ComponentScan("com.comparadorad.bet.comparer.model.activator")
@Profile(value = { ProfileConstant.TEST })
public class ActivatorServiceConfigTest {

}
