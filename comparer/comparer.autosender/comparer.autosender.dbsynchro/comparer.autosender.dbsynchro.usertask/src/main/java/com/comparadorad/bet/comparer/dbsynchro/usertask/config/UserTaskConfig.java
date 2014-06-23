/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.dbsynchro.usertask.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.autosender.core.config.AutosenderCoreConfig;
import com.comparadorad.bet.comparer.autosender.getresponse.config.AutosenderGetResponseConfig;
import com.comparadorad.bet.comparer.model.autosender.service.config.AutoSenderServiceConfig;
import com.comparadorad.bet.comparer.payment.adapter.config.PaymentAdapterSpringConfiguration;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.web.restclient.config.AbstractRestClientConfig;

/**
 * The Class UserTaskConfig.
 */
@Configuration
@Import({ AutosenderGetResponseConfig.class, AutoSenderServiceConfig.class,
		AutosenderCoreConfig.class, AbstractRestClientConfig.class,PaymentAdapterSpringConfiguration.class })
@Profile(value = { ProfileConstant.DEV, ProfileConstant.PREPRODUCTION,
		ProfileConstant.PRODUCTION })
public class UserTaskConfig extends AbstractUserTaskConfig {

}
