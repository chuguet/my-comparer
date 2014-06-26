/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.impl;

import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.bet.bean.IRtData;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.config.ConfiguredSports;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.BetBySportNotAllowedException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.bean.XmlToRtResolverData;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class XmlToRtMarketResolver.
 * 
 */
@Service
class XmlToRtMarketResolver extends AbstractXmlToRtResolver<RtMarket, IRtData, XmlMarket> implements IXmlToRtMarketResolver {

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/** The xml to rt bet resolver. */
	@Inject
	private IXmlToRtBetResolver xmlToRtBetResolver;

	/** The active sports. */
	@Inject
	private ConfiguredSports activeSports;

	/**
	 * Resuelve el mercado a partir de un XmlMarket dado.
	 * 
	 * @param xmlMarket
	 *            the xml market
	 * @param pRtData
	 *            the rt data
	 * @param pXmlToRtResolverData
	 *            the xml to rt resolver data
	 * @return the rt market {@inheritDoc}
	 * @throws BetBySportNotAllowedException
	 *             en caso de no estar permitida la apuesta para el deporte
	 */
	@Override
	public RtMarket resolve(XmlMarket xmlMarket, IRtData pRtData, XmlToRtResolverData pXmlToRtResolverData)
			throws BetBySportNotAllowedException {
		XmlToRtResolverData xmlToRtResolverData = pXmlToRtResolverData;
		LOG.debug(Thread.currentThread(), "Inicio mapeo market");
		RtMarket result = new RtMarket();
		if (xmlMarket != null && xmlToRtResolverData != null) {
			result = mapMarket(null, xmlMarket, pXmlToRtResolverData);

			Boolean availability = checkBetAvailability(result, pXmlToRtResolverData);
			if (availability) {
				if (result != null) {
					if (xmlMarket.getXmlMarketBets() != null && xmlMarket.getXmlMarketBets().size() > 0) {
						if (result.getBetType() != null) {
							xmlToRtResolverData.setLastCfgBetType(result.getBetType());
							xmlToRtResolverData = resolverXmlToRtResolverData(result, xmlToRtResolverData);
							for (XmlMarketBet bet : xmlMarket.getXmlMarketBets()) {
								RtBet rtBet = new RtBet();
								rtBet = xmlToRtBetResolver.resolve(bet, result, xmlToRtResolverData);
								if (rtBet != null) {
									result.add(rtBet);
									result.setHashKey(result.getHashKey());
								}
							}
						}
					}
				}
			} else {
				LOG.debug(
						Thread.currentThread(),
						new StringBuffer().append("La apuesta ").append(result.getBetType().getNameId())
								.append(" no esta permitida para el deporte ")
								.append(pXmlToRtResolverData.getMatch().getMatchId().getCompetition().getSport().getName(null)).toString());
				throw new BetBySportNotAllowedException(new StringBuffer().append("La apuesta ").append(result.getBetType().getNameId())
						.append(" no esta permitida para el deporte ")
						.append(pXmlToRtResolverData.getMatch().getMatchId().getCompetition().getSport().getName(null)).toString());
			}

		}
		LOG.debug(Thread.currentThread(), "Fin mapeo market");
		return result;
	}

	/**
	 * Comprueba para el deporte dado si la apuesta que acabamos de resolver
	 * está permitida o es una apuesta no permitida para dicho deporte.
	 * 
	 * @param result
	 *            the result el mercado que se acaba de resolver
	 * @param pXmlToRtResolverData
	 *            the xml to rt resolver data los datos resueltos anteriormente
	 * @return the boolean si está permitida o no.
	 */
	private Boolean checkBetAvailability(final RtMarket result, final XmlToRtResolverData pXmlToRtResolverData) {
		Boolean availability = false;
		LOG.debug(Thread.currentThread(), new StringBuffer().append("Comprobamos si la apuesta ").append(result.getBetType().getNameId())
					.append(" está permitida para el deporte ")
					.append(pXmlToRtResolverData.getMatch().getMatchId().getCompetition().getSport().getName(null)).toString());
		availability = activeSports.isAvailableBet(result.getBetType().getNameId(), pXmlToRtResolverData.getMatch().getMatchId()
				.getCompetition().getSport().getName(Locale.ENGLISH));

		return availability;
	}

	/**
	 * Resolver xml to rt resolver data.
	 * 
	 * @param pRtMarket
	 *            the rt market
	 * @param xmlToRtResolverData
	 *            the xml to rt resolver data
	 * @return the xml to rt resolver data {@inheritDoc}
	 */
	@Override
	protected XmlToRtResolverData resolverXmlToRtResolverData(RtMarket pRtMarket, XmlToRtResolverData xmlToRtResolverData) {
		XmlToRtResolverData result = (XmlToRtResolverData) xmlToRtResolverData.clone();
		if (pRtMarket != null && result != null) {
			if (result.getMatch() != null) {
				// result.getMatch().add(pRtMarket);
			}
			result.setLastMarket(pRtMarket);
		}
		return result;
	}

	/**
	 * Map market.
	 * 
	 * @param rtMarketDB
	 *            the rt market db
	 * @param xmlMarket
	 *            the xml market
	 * @param pXmlToRtResolverData
	 *            the xml to rt resolver data
	 * @return the rt market
	 */
	private RtMarket mapMarket(RtMarket rtMarketDB, XmlMarket xmlMarket, XmlToRtResolverData pXmlToRtResolverData) {
		RtMarket mapMarket = new RtMarket();
		if (xmlMarket != null && xmlMarket.getXmlMarketBets() != null) {
			pXmlToRtResolverData.setBetsNumber(xmlMarket.getXmlMarketBets().size());
		}
		mapMarket = map(xmlMarket, RtMarket.class, "xmlMarketToRtMarket", pXmlToRtResolverData.getBookmaker(), pXmlToRtResolverData);
		mapMarket.setHistoricCreationData(getUser());
		mapMarket.setHistoricCreationData(getUser());
		mapMarket.setHashKey(mapMarket.getHashKey());
		if (rtMarketDB != null) {
			mapMarket.setBetType(rtMarketDB.getBetType());
		}

		return mapMarket;
	}

}
