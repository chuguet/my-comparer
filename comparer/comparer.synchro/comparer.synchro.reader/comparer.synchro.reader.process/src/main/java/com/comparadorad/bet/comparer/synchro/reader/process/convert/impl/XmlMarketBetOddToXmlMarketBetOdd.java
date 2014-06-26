/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.convert.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBetOdd;
import com.comparadorad.bet.comparer.synchro.reader.process.convert.CustomConvertProcess;

/**
 * The Class XmlMarketBetOddToXmlMarketBetOdd.
 */
@Component
public class XmlMarketBetOddToXmlMarketBetOdd extends
		AbstractCustomConvertProcess implements CustomConvertProcess {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(XmlMarketBetOddToXmlMarketBetOdd.class);

	/** {@inheritDoc} */
	@Override
	public Object convert(Object targetObject, Object sourceObject,
			Class<?> pArg2, Class<?> pArg3) {
		RtBetOdd result = new RtBetOdd();
		if (sourceObject instanceof XmlMarketBetOdd) {
			XmlMarketBetOdd xmlMarketBetOdd = (XmlMarketBetOdd) sourceObject;
			result.setAmericanOdds(xmlMarketBetOdd.getAmericanOdds());
			result.setFraOdds(xmlMarketBetOdd.getFraOdds());
			result.setOdds(xmlMarketBetOdd.getOdds());
		} else {
			LOG.error("No se podido asignar los valores de la apuesta");
		}
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public String getName() {
		return "xmlMarketBetOddToXmlMarketBetOdd";
	}

}
