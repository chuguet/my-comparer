/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.restclient.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class RestClientConfig.
 */
@Configuration
@Profile(value = { ProfileConstant.TEST, ProfileConstant.DEV, ProfileConstant.PRODUCTION,
		ProfileConstant.PREPRODUCTION })
public class RestClientConfig extends
		AbstractRestClientConfig {

}
