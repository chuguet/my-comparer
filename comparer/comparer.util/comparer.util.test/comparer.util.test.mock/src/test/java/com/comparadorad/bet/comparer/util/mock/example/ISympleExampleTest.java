/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.mock.example;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.util.mock.AbstractTest;
import com.comparadorad.bet.comparer.util.mock.exception.MockException;

/**
 * The Class ISympleExampleTest.
 */
public class ISympleExampleTest extends AbstractTest {

	/** The mock symple example. */
	@Inject
	private ISympleExample mockSympleExample;

	/**
	 * Mock with params.
	 *
	 * @throws MockException the mock exception
	 */
	@Test
	public final void mockWithParams() throws MockException {
		assertEquals(mockSympleExample.exampleWithString("ejemplo"), "ejemplo");
	}
	
	/**
	 * Mock exception.
	 *
	 * @throws MockException the mock exception
	 */
	@Test(expected = Exception.class)
	public final void mockException() throws MockException{
		mockSympleExample.exampleWithString("excepcion");
	}
	
	/**
	 * Mock any string.
	 *
	 * @throws MockException the mock exception
	 */
	@Test
	public final void mockAnyString() throws MockException{
		assertEquals(mockSympleExample.exampleWithString("aa"),null);
	}

}
