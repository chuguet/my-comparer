/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.mock.config;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.comparadorad.bet.comparer.util.mock.example.ISimpleExampleConfiguration;

/**
 * The Class MockConfigTest.
 */
@Configuration
public class MockConfigTest extends AbstractMockConfig {

	@Bean
	public ISimpleExampleConfiguration getMockISimpleExampleConfiguration() {
		ISimpleExampleConfiguration exampleConfiguration = mock(ISimpleExampleConfiguration.class);
		when(exampleConfiguration.exampleWithString("ejemplo")).thenReturn("ejemplo");
		when(exampleConfiguration.exampleWithString("excepcion")).thenThrow(Exception.class);
		return exampleConfiguration;
	}

}
