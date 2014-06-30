/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.process.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.model.bet.config.BetServiceConfigTest;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class SynchroValueBetProcessTestConfig.
 */
@Configuration
@Import(value = { BetServiceConfigTest.class })
@Profile(value = { ProfileConstant.TEST })
public class SynchroValueBetProcessConfigTest extends
		AbstractSynchroValueBetProcessConfig {

}
