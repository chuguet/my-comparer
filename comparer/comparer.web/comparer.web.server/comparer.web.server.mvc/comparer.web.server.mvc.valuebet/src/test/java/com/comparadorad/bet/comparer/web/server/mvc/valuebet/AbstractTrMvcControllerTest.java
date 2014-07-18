package com.comparadorad.bet.comparer.web.server.mvc.valuebet;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.comparadorad.bet.comparer.web.server.mvc.core.test.AbstractMvcControllerTest;
import com.comparadorad.bet.comparer.web.server.mvc.valuebet.config.WebServerMvcValueBetConfig;

public abstract class AbstractTrMvcControllerTest extends
		AbstractMvcControllerTest {

	/**
	 * The Class ToolbarMvcMyWebTestConfig.
	 */
	@Configuration
	@Import(value = { WebServerMvcValueBetConfig.class })
	static class ToolbarMvcMyWebTestConfig extends AbstractMyWebConfig {

	}

	/**
	 * Gets the abstract my web config.
	 * 
	 * @return the abstract my web config {@inheritDoc}
	 */
	protected ToolbarMvcMyWebTestConfig getAbstractMyWebConfig() {
		return new ToolbarMvcMyWebTestConfig();
	}
}