/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.impl;

import java.math.BigInteger;
import java.util.Date;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.bet.bean.IRtData;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.core.bean.Historic;
import com.comparadorad.bet.comparer.model.core.bean.HistoricChange;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.process.convert.impl.XmlBetTypeToCfgBetTypeDefault;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.bean.XmlToRtResolverData;

/**
 * The Class XmlToRtMarketResolver.
 * 
 */
@Service
class XmlToRtMarketResolver extends
		AbstractXmlToRtResolver<RtMarket, IRtData, XmlMarket> implements
		IXmlToRtMarketResolver {

	 /** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(XmlToRtMarketResolver.class);
	
	/** The xml to rt bet resolver. */
	@Inject
	private IXmlToRtBetResolver xmlToRtBetResolver;

	/**
	 * Resolve.
	 * 
	 * @param xmlMarket
	 *            the xml market
	 * @param pRtData
	 *            the rt data
	 * @param pXmlToRtResolverData
	 *            the xml to rt resolver data
	 * @return the rt market {@inheritDoc}
	 */
	@Override
	public RtMarket resolve(XmlMarket xmlMarket, IRtData pRtData,
			XmlToRtResolverData pXmlToRtResolverData) {
		XmlToRtResolverData xmlToRtResolverData = pXmlToRtResolverData;
		RtMarket result = new RtMarket();
		if (xmlMarket != null && xmlToRtResolverData != null) {
			result = mapMarket(xmlMarket, pXmlToRtResolverData);
			// Resolvemos largo plazo, de momento solo para betclick
			LOG.debug("Resolvemos apuestas a largo plazo");
			boolean longTerm = getLongTermBet(result, pXmlToRtResolverData);
			xmlToRtResolverData.setLongTerm(longTerm);
			if (result != null) {
				if (xmlMarket.getXmlMarketBets() != null) {
					if (result.getBetType() != null) {
						xmlToRtResolverData.setLastCfgBetType(result
								.getBetType());
						xmlToRtResolverData = resolverXmlToRtResolverData(
								result, xmlToRtResolverData);
						for (XmlMarketBet bet : xmlMarket.getXmlMarketBets()) {
							RtBet rtBet = new RtBet();
							rtBet = xmlToRtBetResolver.resolve(bet, result,
									xmlToRtResolverData);
							if (rtBet != null) {
								result.add(rtBet);
								result.setHashKey(result.getHashKey());
							}
						}
					}
				}
			}

		}
		return result;
	}

	private boolean getLongTermBet(RtMarket rtMarket,
			XmlToRtResolverData pXmlToRtResolverData) {
		boolean longTerm = false;
		
		if (pXmlToRtResolverData.getBookmaker().getObjectId()
				.equals(CfgBookmakerId.BETCLIC_COM_ID.objectId())) {
			if (rtMarket.getBetType() != null
					&& StringUtils
							.isNotEmpty(rtMarket.getBetType().getNameId())) {
				if (rtMarket.getBetType().getNameId()
						.equalsIgnoreCase(CfgBetTypeId.GANADOR.toString())) {
					LOG.debug("La apuesta ha sido marcada como largo plazo");
					longTerm = true;
				}

			}
		}

		return longTerm;
	}

	/**
	 * Resolve by hash key.
	 * 
	 * @param xmlMarket
	 *            the xml market
	 * @param pData
	 *            the data
	 * @param rtMarket
	 *            the rt market
	 * @param pXmlToRtResolverData
	 *            the p xml to rt resolver data
	 * @return the rt market {@inheritDoc}
	 */

	@Override
	public RtMarket resolveByHashKey(final XmlMarket xmlMarket, IRtData pData,
			final RtMarket rtMarket, XmlToRtResolverData pXmlToRtResolverData) {
		RtMarket result = new RtMarket();
		RtMarket mapMarket = new RtMarket();
		if (xmlMarket != null) {
			XmlToRtResolverData xmlToRtResolverData = pXmlToRtResolverData;
			xmlToRtResolverData.setLastCfgBetType(result.getBetType());
			xmlToRtResolverData = resolverXmlToRtResolverData(result,
					xmlToRtResolverData);
			// Obtengo el HashKey del mercado que estamos comprobando
			String hashKeyMarketBD = rtMarket.getHashKey();
			// Mapeo el mercado del xml para poder comparar los distintos
			// hashKey
			mapMarket = mapMarket(xmlMarket, pXmlToRtResolverData);
			// Si los hashKey son iguales proceso el mercado de bd para
			// actualizar
			if (hashKeyMarketBD.equals(mapMarket.getHashKey())) {
				result = (RtMarket) rtMarket.clone();
				if (xmlMarket.getXmlMarketBets() != null) {
					for (XmlMarketBet xmlBet : xmlMarket.getXmlMarketBets()) {
						// Iterator<RtBet> ite =
						// rtMarket.getBets().iterator();
						if (rtMarket.getBets() != null
								&& !rtMarket.getBets().isEmpty()) {
							for (RtBet betBD : rtMarket.getBets()) {
								RtBet rtB = new RtBet();
								rtB = xmlToRtBetResolver.resolveByHashKey(
										betBD, result, xmlBet,
										xmlToRtResolverData);
								rtB = updatePreviousMarket(betBD, rtB);
								if (rtB != null) {
									result.remove(betBD);
									result.add(rtB);
								}
								break;
							}
						} else {
							result = processNewMarket(xmlMarket,
									pXmlToRtResolverData);
						}
					}
				}
				// Si son distintos proceso el nuevo mercado con el metodo
				// anterior.
			} else {
				result = processNewMarket(xmlMarket, pXmlToRtResolverData);
			}
		}
		result.setHashKey(result.getHashKey());
		return result;
	}

	/**
	 * Process new market.
	 * 
	 * @param xmlMarket
	 *            the xml market
	 * @param xmlToRtResolverData
	 *            the xml to rt resolver data
	 * @return the rt market
	 */
	private RtMarket processNewMarket(final XmlMarket xmlMarket,
			final XmlToRtResolverData xmlToRtResolverData) {
		RtMarket result = new RtMarket();
		XmlToRtResolverData pXmlToRtResolverData = xmlToRtResolverData;
		for (XmlMarketBet bet : xmlMarket.getXmlMarketBets()) {
			result.add(xmlToRtBetResolver.resolve(bet, result,
					pXmlToRtResolverData));
		}
		return result;
	}

	/**
	 * Update previous market.
	 * 
	 * @param betBD
	 *            the bet bd
	 * @param bet
	 *            the bet
	 * @return the rt bet
	 */
	private RtBet updatePreviousMarket(RtBet betBD, RtBet bet) {
		RtBet rtBetFinal = (RtBet) bet.clone();
		BigInteger bookBd = null;
		BigInteger book = null;
		// Obtenemos la casa de apuestas del objeto de BD
		// for (RtInternalId internal : betBD.getRtInternalIds()) {
		// bookBd = internal.getCfgBookmaker().getObjectId();
		// }
		bookBd = betBD.getBookmaker().getObjectId();
		// Lo mismo para el objeto creado
		// for (RtInternalId internal : bet.getRtInternalIds()) {
		// book = internal.getCfgBookmaker().getObjectId();
		// }
		book = bet.getBookmaker().getObjectId();
		if (book != null && bookBd != null) {
			if (!bet.equals(betBD) || !book.equals(bookBd)) {
				rtBetFinal.add(betBD.getBetOdd());
				rtBetFinal.setUpdated(true);
				rtBetFinal.setAttribute(bet.getAttribute());
				rtBetFinal.setBetOdd(bet.getBetOdd());
				rtBetFinal.setBookmaker(bet.getBookmaker());
				rtBetFinal.setHistoric(setHistoric());
			} else {
				rtBetFinal = null;
			}
		}
		return rtBetFinal;
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
	protected XmlToRtResolverData resolverXmlToRtResolverData(
			RtMarket pRtMarket, XmlToRtResolverData xmlToRtResolverData) {
		XmlToRtResolverData result = (XmlToRtResolverData) xmlToRtResolverData
				.clone();
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
	 * @param xmlMarket
	 *            the xml market
	 * @param pXmlToRtResolverData
	 *            the xml to rt resolver data
	 * @return the rt market
	 */
	private RtMarket mapMarket(XmlMarket xmlMarket,
			XmlToRtResolverData pXmlToRtResolverData) {
		RtMarket mapMarket = new RtMarket();
		if (xmlMarket != null && xmlMarket.getXmlMarketBets() != null) {
			pXmlToRtResolverData.setBetsNumber(xmlMarket.getXmlMarketBets().size());
		}
		mapMarket = map(xmlMarket, RtMarket.class, "xmlMarketToRtMarket",
				pXmlToRtResolverData.getBookmaker(), pXmlToRtResolverData);
		mapMarket.setHistoricCreationData(getUser());
		mapMarket.add(getRtInternalId(xmlMarket.getBmInternalId(),
				pXmlToRtResolverData));
		mapMarket.setHistoricCreationData(getUser());
		mapMarket.setHashKey(mapMarket.getHashKey());
		return mapMarket;
	}

	/**
	 * Sets the historic.
	 * 
	 * @return the historic
	 */
	private Historic setHistoric() {
		Historic historico = new Historic();
		HistoricChange historicChange = new HistoricChange();
		historicChange.setDate(new Date());
		historicChange.setUser(getUser());
		historico.add(historicChange);

		return historico;
	}

}
