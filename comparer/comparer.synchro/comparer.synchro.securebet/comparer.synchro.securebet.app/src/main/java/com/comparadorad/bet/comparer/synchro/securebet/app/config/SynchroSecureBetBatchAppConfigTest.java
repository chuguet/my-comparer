/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.synchro.securebet.core.config.SynchroSecureBetCoreConfig;
import com.comparadorad.bet.comparer.synchro.securebet.historic.config.SynchroSecureBetHistoricConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class SynchroBetSecureBatchAppConfigTest.
 */
@Configuration
@Profile(value = { ProfileConstant.TEST })
@Import({ SynchroSecureBetCoreConfig.class,
		SynchroSecureBetHistoricConfig.class })
public class SynchroSecureBetBatchAppConfigTest extends
		AbstractSynchroSecureBetBatchAppConfig {

}
