package com.comparadorad.bet.comparer.util.mock.example;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.util.mock.AbstractTest;
import com.comparadorad.bet.comparer.util.mock.exception.MockException;

public class ISimpleExampleConfigurationTest extends AbstractTest {
	
	@Inject
	private ISimpleExampleConfiguration exampleConfiguration;
	
	/**
	 * Mock with params.
	 *
	 * @throws MockException the mock exception
	 */
	@Test
	public final void mockWithParams() throws MockException {
		assertEquals(exampleConfiguration.exampleWithString("ejemplo"), "ejemplo");
	}
	
	/**
	 * Mock exception.
	 *
	 * @throws MockException the mock exception
	 */
	@Test(expected = Exception.class)
	public final void mockException() throws MockException{
		exampleConfiguration.exampleWithString("excepcion");
	}
	
	/**
	 * Mock any string.
	 *
	 * @throws MockException the mock exception
	 */
	@Test
	public final void mockAnyString() throws MockException{
		assertEquals(exampleConfiguration.exampleWithString("aa"),null);
	}

}
