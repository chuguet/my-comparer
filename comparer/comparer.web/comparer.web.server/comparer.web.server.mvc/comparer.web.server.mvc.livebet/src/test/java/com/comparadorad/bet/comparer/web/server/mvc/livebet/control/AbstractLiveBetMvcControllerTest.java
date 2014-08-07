/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.livebet.control;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.comparadorad.bet.comparer.web.server.mvc.core.test.AbstractMvcControllerTest;
import com.comparadorad.bet.comparer.web.server.mvc.livebet.config.WebServerMvcLiveBetMockupConfig;

/**
 * The Class AbstractToolbarMvcControllerTest.
 */
public abstract class AbstractLiveBetMvcControllerTest extends
		AbstractMvcControllerTest {

	/**
	 * The Class ToolbarMvcMyWebTestConfig.
	 */
	@Configuration
	@Import(value = { WebServerMvcLiveBetMockupConfig.class })
	static class LiveBetMvcMyWebTestConfig extends AbstractMyWebConfig {
		
	}

	/**
	 * Gets the abstract my web config.
	 *
	 * @return the abstract my web config
	 * {@inheritDoc}
	 */
	protected LiveBetMvcMyWebTestConfig getAbstractMyWebConfig() {
		return new LiveBetMvcMyWebTestConfig();
	}
}
