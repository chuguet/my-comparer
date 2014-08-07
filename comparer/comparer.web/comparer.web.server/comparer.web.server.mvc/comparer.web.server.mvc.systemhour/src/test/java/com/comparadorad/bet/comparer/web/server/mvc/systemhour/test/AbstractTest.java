package com.comparadorad.bet.comparer.web.server.mvc.systemhour.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.comparadorad.bet.comparer.web.server.mvc.core.test.AbstractMvcControllerTest;
import com.comparadorad.bet.comparer.web.server.mvc.systemhour.config.WebServerMvcMatchConfig;

public abstract class AbstractTest extends AbstractMvcControllerTest {

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
