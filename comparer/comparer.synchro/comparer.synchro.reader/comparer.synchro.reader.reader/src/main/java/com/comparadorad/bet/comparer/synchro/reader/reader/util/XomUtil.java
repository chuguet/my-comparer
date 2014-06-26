/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.reader.util;

import nu.xom.Element;
import nu.xom.ParentNode;

/**
 * The Class XomUtil.
 */
public final class XomUtil {
	
	private static final String XPATH_SEPARATOR = "/";

	/**
	 * Gets the element xpath.
	 * 
	 * @param pElement
	 *            the element
	 * @return the element xpath
	 */
	public static String getElementXpath(final Element pElement) {
		final StringBuffer result = new StringBuffer(XPATH_SEPARATOR);
		result.append(pElement.getLocalName());
		ParentNode parent = pElement.getParent();
		while (parent != null) {
			if (parent instanceof Element) {
				result.insert(0, ((Element) parent).getLocalName());
				result.insert(0, XPATH_SEPARATOR);
			}
			parent = parent.getParent();
		}
		return result.toString();
	}

}
