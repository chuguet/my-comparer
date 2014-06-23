/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.surebets.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.communication.producer.config.ProducerConfig;
import com.comparadorad.bet.comparer.model.securebet.service.config.SecureBetServiceConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class CommunicationSurebetsConfig.
 */
@Configuration
@Import({ ProducerConfig.class, SecureBetServiceConfig.class })
@Profile({ ProfileConstant.PRODUCTION, ProfileConstant.PREPRODUCTION,
		ProfileConstant.DEV })
public class CommunicationSurebetsConfig extends
		AbstractCommunicationSurebetsConfig {

}
