/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.impl;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.IXmlToRtResolver;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.bean.XmlToRtResolverData;

/**
 * The Interface IXmlToRtBetResolver.
 * 
 */
public interface IXmlToRtBetResolver extends
		IXmlToRtResolver<RtBet, RtMarket, XmlMarketBet> {

	/**
	 * Resolve by hash key.
	 * 
	 * @param rtBet
	 *            the rt bet
	 * @param rtMarket
	 *            the rt market
	 * @param pXmlData
	 *            the p xml data
	 * @param pXmlToRtResolverData
	 *            the p xml to rt resolver data
	 * @return the rt bet
	 */
	public abstract RtBet resolveByHashKey(RtBet rtBet, RtMarket rtMarket,
			XmlMarketBet pXmlData, XmlToRtResolverData pXmlToRtResolverData);

}