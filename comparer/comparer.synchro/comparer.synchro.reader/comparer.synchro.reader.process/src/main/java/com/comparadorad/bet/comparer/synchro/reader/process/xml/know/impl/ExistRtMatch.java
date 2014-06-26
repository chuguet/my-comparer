/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.xml.know.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtInternalId;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.service.IRtMatchService;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.know.bean.ExistData;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.know.bean.ExistMarketData;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.know.bean.ExistMatchData;

/**
 * The Class ExistRtMatchData.
 */
@Component
class ExistRtMatch extends AbstractRtData implements IExistRtMatch {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ExistRtMatch.class);

	/** The sport type service. */
	@Inject
	private IRtMatchService matchService;

	/** The market service. */
	@Inject
	private IExistRTMarket existRTMarket;

	/** The internal id. */
	private String xmlMatchInternalId = "";

	/**
	 * Exist.
	 * 
	 * @param xmlMatch
	 *            the xml match
	 * @param pExistRtDataData
	 *            the exist rt data data
	 * @return the exist match data {@inheritDoc}
	 */

	@Override
	public ExistMatchData exist(XmlMatch xmlMatch, ExistData pExistRtDataData) {
		ExistMatchData existMatchData = new ExistMatchData(true);
		ExistMarketData existMarketData = new ExistMarketData(true);
		List<RtMatch> rtMatchs = new ArrayList<RtMatch>();
		RtMatch rtMatch = new RtMatch();
		// Obtengo el internalID del objeto generado a partir del XML
		if (xmlMatch.getBmInternalId().getValue() != null) {
			xmlMatchInternalId = xmlMatch.getBmInternalId().getValue();
		}
		// Si no existe en el xml que nos llega el Internal id
		// buscamos a través de nueva apuesta
		if (!"".equals(xmlMatchInternalId)) {
			pExistRtDataData.setXmlMatchInternalId(xmlMatchInternalId);
			LOG.debug("Obtenemos de BD el evento");
			rtMatchs = matchService.getMatchs(xmlMatchInternalId);
			// Si nos ha encontrado algo buscamos el resto de elementos.
			if (rtMatchs != null && !rtMatchs.isEmpty()) {
				LOG.debug("El evento se ha encontrado en BD con lo que trabajamos sobre el");
				existMatchData = new ExistMatchData(false);
				rtMatch = rtMatchs.get(0);
				for (RtInternalId internal : rtMatch.getRtInternalIds()) {

					if (internal.getCfgBookmaker() != null
							&& internal
									.getCfgBookmaker()
									.getObjectId()
									.equals(pExistRtDataData.getBookmaker()
											.getObjectId())) {
						pExistRtDataData.setRtMatch(rtMatch);
						if (xmlMatch.getXmlMarkets() != null) {
							for (XmlMarket xmlMarket : xmlMatch.getXmlMarkets()) {
								existMarketData = existRTMarket.exist(
										xmlMarket, pExistRtDataData);
								if (existMarketData.getIsNew()) {
									rtMatch.add((RtMarket) existMarketData
											.getRtData());
								} else {
									rtMatch = updatePreviousMatch(
											existMarketData, rtMatch);
								}
							}
							existMatchData.setRtData(rtMatch);
							// Si no hay nada hacemos alta nueva
						}
					} else {
						existMatchData = new ExistMatchData(true);
					}
				}

			} else {
				existMatchData = new ExistMatchData(true);
			}
		}
		return existMatchData;
	}

	/**
	 * Update previous match.
	 * 
	 * @param existMarketData
	 *            the exist market data
	 * @param rtMatch
	 *            the rt match
	 * @return the rt match
	 */
	private RtMatch updatePreviousMatch(final ExistMarketData existMarketData,
			final RtMatch rtMatch) {
		RtMatch rtMatchFinal = rtMatch;
		RtMarket rtMarket = (RtMarket) existMarketData.getRtData();
		boolean encontrado = false;
		Iterator<RtMarket> iterator = rtMatch.getRtMarkets().iterator();
		Set<RtMarket> marketFinal = new HashSet<RtMarket>();
		while (iterator.hasNext() && !encontrado) {
			RtMarket rtMarketIt = iterator.next();
			if (!rtMarketIt.equals(rtMarket)) {
				marketFinal.add(rtMarketIt);
			}
		}
		marketFinal.add(rtMarket);
		rtMatchFinal.setRtMarkets(null);
		rtMatchFinal.setRtMarkets(marketFinal);
		rtMatchFinal.add(rtMarket);
		// encontrado = true;

		return rtMatchFinal;
	}

}
