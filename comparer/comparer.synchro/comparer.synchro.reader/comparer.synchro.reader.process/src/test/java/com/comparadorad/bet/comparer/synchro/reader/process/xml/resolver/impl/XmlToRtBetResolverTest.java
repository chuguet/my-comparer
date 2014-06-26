/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.impl;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.synchro.reader.process.AbstractTest;

/**
 * The Class XmlToRtBetResolverTest.
 */
public final class XmlToRtBetResolverTest extends AbstractTest {

	/** The xml to rt bet resolver. */

	@Inject
	private IXmlToRtBetResolver xmlToRtBetResolver;

	/**
	 * All nulltest.
	 */
	@Test
	public final void test() {

		xmlToRtBetResolver.resolve(null, null, null);

	}

}
