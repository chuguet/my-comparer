/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.payment.control;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.comparadorad.bet.comparer.web.server.mvc.core.test.AbstractMvcControllerTest;
import com.comparadorad.bet.comparer.web.server.mvc.payment.config.WebServerMvcPaymentMockupConfig;


public abstract class AbstractPaymentMvcControllerTest extends
		AbstractMvcControllerTest {

	
	@Configuration
	@Import(value = { WebServerMvcPaymentMockupConfig.class })
	static class PaymentMvcMyWebTestConfig extends AbstractMyWebConfig {
		
	}

	
	protected PaymentMvcMyWebTestConfig getAbstractMyWebConfig() {
		return new PaymentMvcMyWebTestConfig();
	}
}
