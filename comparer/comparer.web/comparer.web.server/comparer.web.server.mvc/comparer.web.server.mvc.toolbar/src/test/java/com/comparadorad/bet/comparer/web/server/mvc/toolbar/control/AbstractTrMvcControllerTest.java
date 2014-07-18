/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.toolbar.control;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.comparadorad.bet.comparer.web.server.mvc.core.config.WebServerMvcCoreConfig;
import com.comparadorad.bet.comparer.web.server.mvc.core.test.AbstractMvcControllerTest;
import com.comparadorad.bet.comparer.web.server.mvc.toolbar.config.WebServerMvcToolbarConfig;

/**
 * The Class AbstractToolbarMvcControllerTest.
 */
public abstract class AbstractTrMvcControllerTest extends
		AbstractMvcControllerTest {

	/**
	 * The Class ToolbarMvcMyWebTestConfig.
	 */
	@Configuration
	@Import(value = { WebServerMvcCoreConfig.class,
			WebServerMvcToolbarConfig.class })
	static class ToolbarMvcMyWebTestConfig extends AbstractMyWebConfig {

	}

	/** {@inheritDoc} */
	protected ToolbarMvcMyWebTestConfig getAbstractMyWebConfig() {
		return new ToolbarMvcMyWebTestConfig();
	}
}
