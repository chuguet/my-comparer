/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.impl;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.BetBySportNotAllowedException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.impl.IXmlToRtBetResolver;

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

		try {
			xmlToRtBetResolver.resolve(null, null, null);
		} catch (BetBySportNotAllowedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
