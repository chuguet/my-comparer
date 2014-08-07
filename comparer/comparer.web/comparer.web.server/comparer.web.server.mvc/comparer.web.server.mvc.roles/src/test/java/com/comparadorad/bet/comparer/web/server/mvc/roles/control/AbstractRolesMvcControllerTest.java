/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.roles.control;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.comparadorad.bet.comparer.web.server.mvc.core.config.WebServerMvcCoreConfig;
import com.comparadorad.bet.comparer.web.server.mvc.core.test.AbstractMvcControllerTest;
import com.comparadorad.bet.comparer.web.server.mvc.roles.config.WebServerMvcRolesConfig;

/**
 * The Class AbstractToolbarMvcControllerTest.
 */
public abstract class AbstractRolesMvcControllerTest extends
		AbstractMvcControllerTest {

	@Configuration
	@Import(value = { WebServerMvcCoreConfig.class,
			WebServerMvcRolesConfig.class })
	static class RolesMvcMyWebTestConfig extends AbstractMyWebConfig {

	}

	/**
	 * Gets the abstract my web config.
	 *
	 * @return the abstract my web config
	 * {@inheritDoc}
	 */
	protected RolesMvcMyWebTestConfig getAbstractMyWebConfig() {
		return new RolesMvcMyWebTestConfig();
	}
}
