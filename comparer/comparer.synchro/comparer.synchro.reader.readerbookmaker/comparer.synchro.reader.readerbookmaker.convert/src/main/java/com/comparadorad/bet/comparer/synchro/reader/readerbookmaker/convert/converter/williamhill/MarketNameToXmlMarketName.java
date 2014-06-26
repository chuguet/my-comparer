/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.convert.converter.williamhill;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.convert.converter.AbstractCustomConvertReader;

/**
 * The Class MarketNameToXmlMatchName.
 */
@Component
public class MarketNameToXmlMarketName extends AbstractCustomConvertReader {
	
	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(MarketNameToXmlMarketName.class);

	/** {@inheritDoc} */
	@Override
	public String getName() {
		return "marketNameToXmlMarketNameWilliam";
	}

	/** {@inheritDoc} */
	@Override
	public Object convert(Object pArg0, Object source, Class<?> pArg2,
			Class<?> pArg3) {
		if(LOG.isDebugEnabled()) {
			LOG.debug("Conversion de nombre de mercado");
		}
		if ( ((String) source).split(" - ").length > 1) {
			return ((String) source).split(" - ")[1];
		} else {
			return ((String) source).split(" - ")[0];
		}
	}

}
