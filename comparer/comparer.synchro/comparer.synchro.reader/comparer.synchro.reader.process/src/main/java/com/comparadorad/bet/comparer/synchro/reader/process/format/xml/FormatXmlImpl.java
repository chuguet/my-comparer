/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.format.xml;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;

/**
 * The Class FormatXmlImpl.
 */
@Component
class FormatXmlImpl implements IFormatXML {

	/** {@inheritDoc} */
	@Override
	public XmlMatch format(XmlMatch pXmlMatch) {
		XmlMatch result = pXmlMatch;
		if (result != null) {
			if (result.getName() != null) {
				result.setName(formatString(result.getName()));
			}
			if (result.getXmlMarkets() != null) {
				for (XmlMarket xmlMarket : result.getXmlMarkets()) {
					if (xmlMarket.getName() != null) {
						xmlMarket.setName(formatString(xmlMarket.getName()));
					}

				}

			}
		}
		return result;
	}

	/**
	 * Format string.
	 * 
	 * @param string
	 *            the string
	 * @return the string
	 */
	private String formatString(String string) {
		String result = "";
		if (string != null) {
			result = string.trim().toUpperCase();
		}
		return result;
	}
}
