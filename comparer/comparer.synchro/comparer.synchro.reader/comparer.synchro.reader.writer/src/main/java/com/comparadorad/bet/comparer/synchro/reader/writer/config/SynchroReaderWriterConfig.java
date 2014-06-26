/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.writer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.model.activator.config.ActivatorServiceConfig;
import com.comparadorad.bet.comparer.model.bet.config.BetServiceConfig;
import com.comparadorad.bet.comparer.model.config.service.config.ConfigServiceConfig;
import com.comparadorad.bet.comparer.model.log.service.config.LogServiceConfig;
import com.comparadorad.bet.comparer.synchro.securebet.process.config.SynchroSecureBetProcessConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.logger.config.SpringSynchroLogConfig;

/**
 * The Class SynchroReaderWriterConfig.
 */
@Configuration
@Import(value = { BetServiceConfig.class, ConfigServiceConfig.class,
		LogServiceConfig.class, SpringSynchroLogConfig.class,
		ActivatorServiceConfig.class, SynchroSecureBetProcessConfig.class })
@ComponentScan("com.comparadorad.bet.comparer.synchro.reader.writer")
@Profile(value = { ProfileConstant.TEST, ProfileConstant.DEV,
		ProfileConstant.PREPRODUCTION, ProfileConstant.PRODUCTION })
public class SynchroReaderWriterConfig {

}
