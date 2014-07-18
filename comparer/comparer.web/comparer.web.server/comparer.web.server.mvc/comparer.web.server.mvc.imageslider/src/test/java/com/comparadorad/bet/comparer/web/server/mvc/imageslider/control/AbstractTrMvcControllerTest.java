package com.comparadorad.bet.comparer.web.server.mvc.imageslider.control;
/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */




import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.comparadorad.bet.comparer.web.server.mvc.core.test.AbstractMvcControllerTest;
import com.comparadorad.bet.comparer.web.server.mvc.imageslider.config.WebServerMvcImageSliderConfig;

/**
 * The Class AbstractToolbarMvcControllerTest.
 */
public abstract class AbstractTrMvcControllerTest extends
		AbstractMvcControllerTest {

	/**
	 * The Class ToolbarMvcMyWebTestConfig.
	 */
	@Configuration
	@Import(value = { WebServerMvcImageSliderConfig.class })
	static class ToolbarMvcMyWebTestConfig extends AbstractMyWebConfig {

	}

	/**
	 * Gets the abstract my web config.
	 *
	 * @return the abstract my web config
	 * {@inheritDoc}
	 */
	protected ToolbarMvcMyWebTestConfig getAbstractMyWebConfig() {
		return new ToolbarMvcMyWebTestConfig();
	}
}
