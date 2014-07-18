/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.portlet.roles.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.web.server.portlet.core.config.AbstractAppMockupConfig;

/**
 * The Class AppConfig.
 */
@Configuration
@Profile({ ProfileConstant.CLIENT })
public class RolesAppMockupConfig extends AbstractAppMockupConfig {

}
