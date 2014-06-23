/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.communication.core.config.QueueCoreConfigTest;
import com.comparadorad.bet.comparer.model.valuebet.config.ValueBetServiceConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class CommunicationValueBetsConfigTest.
 */
@Configuration
@Import(value = { ValueBetServiceConfig.class, QueueCoreConfigTest.class})
@Profile(value = { ProfileConstant.TEST })
public class CommunicationValueBetsConfigTest extends
		AbstractCommunicationValueBets {

}
