/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.impl;

import com.comparadorad.bet.comparer.model.bet.bean.IRtData;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.IXmlToRtResolver;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.bean.XmlToRtResolverData;

/**
 * The Interface IXmlToRtMarketResolver.
 * 
 */
public interface IXmlToRtMarketResolver extends
		IXmlToRtResolver<RtMarket, IRtData, XmlMarket> {

	/**
	 * Resolve by hash key.
	 * 
	 * @param xmlMarket
	 *            the xml market
	 * @param pIRtData
	 *            the i rt data
	 * @param rtMarket
	 *            the rt market
	 * @param pXmlToRtResolverData
	 *            the p xml to rt resolver data
	 * @return the rt market
	 */
	RtMarket resolveByHashKey(XmlMarket xmlMarket, IRtData pIRtData,
			RtMarket rtMarket, XmlToRtResolverData pXmlToRtResolverData);
}