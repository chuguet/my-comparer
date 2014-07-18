/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.control;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.comparadorad.bet.comparer.web.server.mvc.core.test.AbstractMvcControllerTest;
import com.comparadorad.bet.comparer.web.server.mvc.match.config.WebServerMvcMatchConfig;

/**
 * The Class AbstractToolbarMvcControllerTest.
 */
public abstract class AbstractTrMvcControllerTest extends
		AbstractMvcControllerTest {

	/**
	 * The Class ToolbarMvcMyWebTestConfig.
	 */
	@Configuration
	@Import(value = { WebServerMvcMatchConfig.class })
	static class WebServerMvcMatchConfigTest extends AbstractMyWebConfig {

	}

	/**
	 * Gets the abstract my web config.
	 * 
	 * @return the abstract my web config {@inheritDoc}
	 */
	protected WebServerMvcMatchConfigTest getAbstractMyWebConfig() {
		return new WebServerMvcMatchConfigTest();
	}

}
