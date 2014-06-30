/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.writer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.model.bet.config.BetServiceConfigTest;
import com.comparadorad.bet.comparer.model.valuebet.config.ValueBetServiceConfigTest;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class SynchroValueBetWriterConfigTest.
 */
@Configuration
@ComponentScan({ "com.comparadorad.bet.comparer.synchro.valuebet.writer" })
@Import(value = { BetServiceConfigTest.class, ValueBetServiceConfigTest.class })
@Profile(value = { ProfileConstant.TEST })
public class SynchroValueBetWriterConfigTest {

}
