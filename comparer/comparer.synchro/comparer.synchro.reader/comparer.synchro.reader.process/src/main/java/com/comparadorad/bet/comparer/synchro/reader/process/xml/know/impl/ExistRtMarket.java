/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.xml.know.impl;

import java.util.Iterator;
import java.util.Set;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtInternalId;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.know.bean.ExistBetData;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.know.bean.ExistData;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.know.bean.ExistMarketData;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.impl.IXmlToRtMarketResolver;

/**
 * The Class ExistRtMarket.
 */
@Component
class ExistRtMarket extends AbstractRtData implements IExistRTMarket {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ExistRtMarket.class);

	/** The market service. */
	@Inject
	private IExistRtBet existRTBet;

	/** The xml to rt market resolver. */
	@Inject
	private IXmlToRtMarketResolver xmlToRtMarketResolver;

	/** The xml internal market id. */
	private String xmlInternalMarketId = "";

	/** The internal bet bookmaker. */
	private CfgBookmaker internalMarketBookmaker;

	/**
	 * Exist.
	 * 
	 * @param xmlMarket
	 *            the xml market
	 * @param pExistRtDataData
	 *            the exist rt data data
	 * @return the exist market data {@inheritDoc}
	 */
	@Override
	public ExistMarketData exist(XmlMarket xmlMarket, ExistData pExistRtDataData) {
		ExistMarketData existMarketData = new ExistMarketData(true);
		ExistBetData existBetData = new ExistBetData(true);
		RtMarket rtMarket = new RtMarket();
		RtMatch rtMatch = pExistRtDataData.getRtMatch();
		Set<RtMarket> markets = rtMatch.getRtMarkets();
		// Obtengo el internalID del objeto generado a partir del XML
		xmlInternalMarketId = xmlMarket.getBmInternalId().getValue();
		if (xmlInternalMarketId != null && !xmlInternalMarketId.equals("")) {
			pExistRtDataData.setXmlMarketInternalId(xmlInternalMarketId);
			if (!markets.isEmpty()) {
				Iterator<RtMarket> iterator = markets.iterator();
				boolean encontrado = false;
				while (iterator.hasNext() && !encontrado) {
					RtMarket m = (RtMarket) iterator.next();
					for (RtInternalId i : m.getRtInternalIds()) {
						internalMarketBookmaker = i.getCfgBookmaker();
						// Debe coincidir tanto id del mercado como la casa de
						// apuestas ya que distintas casas de apuestas pueden
						// tener el mismo id
						if (i.getCfgBookmaker() != null
								&& internalMarketBookmaker.getObjectId()
										.equals(pExistRtDataData.getBookmaker()
												.getObjectId())
								&& xmlInternalMarketId.equals(i
										.getRtBmInternalId().getValue())) {
							LOG.debug("Hemos encontrado el market dentro del match, con lo que trabajamos con el de BD");
							pExistRtDataData
									.setXmlMarketInternalId(xmlInternalMarketId);
							pExistRtDataData.setBeanMarketId(i
									.getRtBmInternalId().getValue());
							existMarketData = new ExistMarketData(false);
							existMarketData.setPreviousMarket(m);
							if (xmlMarket.getXmlMarketBets() != null) {
								for (XmlMarketBet marketBet : xmlMarket
										.getXmlMarketBets()) {
									existBetData = existRTBet.exist(marketBet,
											pExistRtDataData);
									if (!existBetData.getIsNew()) {
										// Elimino la que existia y agrego la
										// nueva que tendra los nuevos valores
										// de apuesta y la apuesta anterior en
										// la lista
										m.remove(existBetData
												.getPreviousRtBet());
										m.add((RtBet) existBetData.getRtData());

									}
									existMarketData.setRtData(m);
									encontrado = true;
								}
							}
						}
					}
				}
			}
			if (existMarketData.getIsNew()) {
				LOG.debug("No se ha encontrado el market dentro del match de BD con lo que resolvemos");
				rtMarket = xmlToRtMarketResolver.resolve(xmlMarket,
						new RtMarket(),
						pExistRtDataData.getXmlToRtResolverData());
				existMarketData.setRtData(rtMarket);
			}
		}
		return existMarketData;
	}

}
