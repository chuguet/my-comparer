/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.reader.util;

import static org.junit.Assert.assertEquals;
import nu.xom.Element;

import org.junit.Test;

/**
 * The Class XomUtilTest.
 */
public class XomUtilTest {

	/**
	 * Test get element xpath.
	 */
	@Test
	public void testGetElementXpath() {

		Element element = new Element("node1");
		String xpath = XomUtil.getElementXpath(element);
		assertEquals("/node1", xpath);

		Element element2 = new Element("node2");
		element.appendChild(element2);
		xpath = XomUtil.getElementXpath(element2);
		assertEquals("/node1/node2", xpath);
	}

}
