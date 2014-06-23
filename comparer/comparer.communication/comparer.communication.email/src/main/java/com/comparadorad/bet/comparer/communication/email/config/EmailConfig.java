/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.email.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.comparadorad.bet.comparer.autosender.core.config.AutosenderCoreConfig;
import com.comparadorad.bet.comparer.autosender.getresponse.config.AutosenderGetResponseConfig;
import com.comparadorad.bet.comparer.communication.consumer.config.ConsumerConfig;
import com.comparadorad.bet.comparer.model.securebet.service.config.SecureBetServiceConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class EmailConfig.
 */
@Configuration
@EnableScheduling
@Import({ AutosenderGetResponseConfig.class, AutosenderCoreConfig.class,
		ConsumerConfig.class, SecureBetServiceConfig.class })
@Profile(value = { ProfileConstant.DEV, ProfileConstant.PREPRODUCTION,
		ProfileConstant.PRODUCTION })
public class EmailConfig extends AbstractEmailConfig {

}
