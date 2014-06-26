/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.longTerm;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.LongTerm;
import com.comparadorad.bet.comparer.synchro.reader.process.AbstractTest;

/**
 * The Class LongTermResolverTest.
 */
public class LongTermResolverTest extends AbstractTest{

	/** The long term resolver. */
	@Inject
	private ILongTermResolver longTermResolver;

	/**
	 * Long term resolver test.
	 */
	@Override
	@Test
	public final void test() {
		boolean largoPlazo = true;
		LongTerm longTerm;
		longTerm = longTermResolver.resolveLongTerm(largoPlazo);
		assertNotNull(longTerm);
		assertTrue(longTerm.getLongTerm());
	}

}
