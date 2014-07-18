package com.comparadorad.bet.comparer.web.server.mvc.securebet.control;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.comparadorad.bet.comparer.web.server.mvc.core.test.AbstractMvcControllerTest;
import com.comparadorad.bet.comparer.web.server.mvc.securebet.config.WebServerMvcMatchConfig;

public abstract class AbstractTrMvcControllerTest extends
AbstractMvcControllerTest {

/**
* The Class ToolbarMvcMyWebTestConfig.
*/
@Configuration
@Import(value = { WebServerMvcMatchConfig.class })
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