/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBetOdd;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.CustomConvertProcess;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.BetOddNotFoundException;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class XmlMarketBetOddToXmlMarketBetOdd.
 */
@Component
public class XmlMarketBetOddToXmlMarketBetOdd extends
		AbstractCustomConvertProcess implements CustomConvertProcess {

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/** {@inheritDoc} */
	@Override
	public Object convert(Object targetObject, Object sourceObject,
			Class<?> pArg2, Class<?> pArg3) {
		RtBetOdd result = new RtBetOdd();
		if (sourceObject instanceof XmlMarketBetOdd) {
			XmlMarketBetOdd xmlMarketBetOdd = (XmlMarketBetOdd) sourceObject;
			if (xmlMarketBetOdd.getAmericanOdds() != null) {
				result.setAmericanOdds(xmlMarketBetOdd.getAmericanOdds().trim());
			}
			if (xmlMarketBetOdd.getFraOdds() != null) {
				result.setFraOdds(xmlMarketBetOdd.getFraOdds().trim());
			}
			if (xmlMarketBetOdd.getOdds() != null) {
				result.setOdds(xmlMarketBetOdd.getOdds().trim());
			}
		} else {
			LOG.debug(Thread.currentThread(), "No se podido asignar los valores de la apuesta");
			throw new BetOddNotFoundException(
					"No se podido asignar los valores de la apuesta");
		}
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public String getName() {
		return "xmlMarketBetOddToXmlMarketBetOdd";
	}

}
