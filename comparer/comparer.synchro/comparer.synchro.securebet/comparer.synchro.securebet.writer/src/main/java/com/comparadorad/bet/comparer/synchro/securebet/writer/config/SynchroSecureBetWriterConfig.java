/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.writer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.communication.surebets.config.CommunicationSurebetsConfig;
import com.comparadorad.bet.comparer.model.bet.config.BetRepositoryConfig;
import com.comparadorad.bet.comparer.model.securebet.service.config.SecureBetServiceConfig;
import com.comparadorad.bet.comparer.synchro.securebet.core.config.SynchroSecureBetCoreConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class SynchroBetSecureWriterConfig.
 */
@Configuration
@Import(value = { BetRepositoryConfig.class, SecureBetServiceConfig.class,
		CommunicationSurebetsConfig.class, SynchroSecureBetCoreConfig.class })
@ComponentScan({ "com.comparadorad.bet.comparer.synchro.securebet.writer" })
@Profile(value = { ProfileConstant.DEV, ProfileConstant.PREPRODUCTION,
		ProfileConstant.PRODUCTION, ProfileConstant.TEST })
public class SynchroSecureBetWriterConfig {

}
