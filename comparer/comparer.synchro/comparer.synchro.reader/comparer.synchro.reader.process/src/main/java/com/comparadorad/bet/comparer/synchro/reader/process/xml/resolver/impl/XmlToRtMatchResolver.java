/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.IRtData;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatchId;
import com.comparadorad.bet.comparer.model.bet.service.IRtMatchService;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.bean.XmlToRtResolverData;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.longTerm.ILongTermResolver;

/**
 * The Class XmlToRtMatchResolver.
 * 
 */
@Component
class XmlToRtMatchResolver extends
		AbstractXmlToRtResolver<RtMatch, IRtData, XmlMatch> implements
		IXmlToRtMatchResolver {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(XmlToRtMatchResolver.class);

	/** The xml to rt market resolver. */
	@Inject
	private IXmlToRtMarketResolver xmlToRtMarketResolver;

	/** The sport type service. */
	@Inject
	private IRtMatchService matchService;

	/** The long term. */
	@Inject
	private ILongTermResolver longTermResolver;

	@Inject
	private RtMatchNameResolver rtMatchNameResolver;

	/**
	 * Resolve.
	 * 
	 * @param xmlMatch
	 *            the xml match
	 * @param pIRtData
	 *            the i rt data
	 * @param xmlToRtResolverData
	 *            the xml to rt resolver data
	 * @return the rt match {@inheritDoc}
	 */
	@Override
	public RtMatch resolve(XmlMatch xmlMatch, IRtData pIRtData,
			XmlToRtResolverData xmlToRtResolverData) {
		XmlToRtResolverData xmlToResolve = xmlToRtResolverData;
		RtMatchId rtMatchId;
		RtMatch rtMatch = new RtMatch();
		RtMatch rtMatchBD;
		if (xmlMatch != null && xmlToResolve != null) {

			rtMatchId = map(xmlMatch, RtMatchId.class, "xmlMatchToRtMatchId",
					xmlToRtResolverData.getBookmaker(), xmlToRtResolverData);
			rtMatch = map(xmlMatch, RtMatch.class, "xmlMatchToRtMatch",
					xmlToRtResolverData.getBookmaker(), xmlToRtResolverData);
			rtMatch.setMatchId(rtMatchId);
			rtMatchId.setHistoricCreationData(getUser());
			rtMatch.setHistoricCreationData(getUser());
			rtMatch.add(getRtInternalId(xmlMatch.getBmInternalId(),
					xmlToResolve));
			rtMatch.setHashKey(rtMatch.getHashKey());
			// Comprobamos a traves del HashKey que el RtMatch que acabamos de
			// generar no existe en BD si existe trabajaremos con este.
			LOG.debug("Compruebo si el RtMatch existia previamente en BD");
			rtMatchBD = getRtMatchFromDB(rtMatch);
			xmlToResolve = resolverXmlToRtResolverData(rtMatch, xmlToResolve);
			if (xmlMatch.getXmlMarkets() != null) {
				for (XmlMarket market : xmlMatch.getXmlMarkets()) {
					// Resolve by hashkey
					if (rtMatchBD != null) {
						LOG.debug(new StringBuffer().append("El RtMatch ")
								.append(rtMatchBD.getObjectId())
								.append(" ya existia en BD, trabajamos con el"));
						Iterator<RtMarket> iterator = rtMatchBD.getRtMarkets()
								.iterator();
						while (iterator.hasNext()) {
							RtMarket marketBD = iterator.next();
							RtMarket mark;
							mark = xmlToRtMarketResolver.resolveByHashKey(
									market, rtMatchBD, marketBD, xmlToResolve);
							rtMatch = updatePreviousMatch(mark, rtMatchBD);
						}
						// Resolve por el metodo tradicional de alta.
					} else {
						LOG.debug("El RtMatch es un alta nueva");
						RtMarket rtMarket = new RtMarket();

						rtMarket = xmlToRtMarketResolver.resolve(market,
								pIRtData, xmlToResolve);

						// Calculo de largo plazo
						rtMatch.setCompetitionEvent(getLongTermBet(
								rtMatch.getMatchId(), xmlToResolve.isLongTerm()));

						// Si el market no tiene apuestas no tiene sentido
						// añadirlo al match
						if (rtMarket != null && rtMarket.getBets() != null
								&& rtMarket.getBetType() != null
								&& rtMarket.getBetType().getNameId() != null
								&& rtMarket.getBets().size() > 0) {
							rtMatch.add(rtMarket);
						}
					}
				}
			} else {
				if (rtMatchBD != null) {
					rtMatch = rtMatchBD;
				}
			}
			rtMatch = rtMatchNameResolver.resolveNameField(rtMatch);
		}

		rtMatch.setHashKey(rtMatch.getHashKey());
		return rtMatch;
	}

	/**
	 * Gets the long term bet.
	 * 
	 * @param rtMatchId
	 *            the rt match id
	 * @param longTerm
	 *            the long term
	 * @return the long term bet
	 */
	private CfgCompetitionEvent getLongTermBet(RtMatchId rtMatchId,
			boolean longTerm) {
		CfgCompetitionEvent result = rtMatchId.getCompetitionEvent();

		if (result == null) {
			result = new CfgCompetitionEvent();
		}
		result.setLongTerm(longTermResolver.resolveLongTerm(longTerm));

		return result;
	}

	/**
	 * Gets the rt match from db.
	 * 
	 * @param rtMatch
	 *            the rt match
	 * @return the rt match from db
	 */
	private RtMatch getRtMatchFromDB(final RtMatch rtMatch) {
		List<RtMatch> rtMatchs = new ArrayList<RtMatch>();
		RtMatch rtMatchDB = new RtMatch();
		String matchHashKey = rtMatch.getAbstractKey().getHashKey();
		rtMatchs = matchService.getMatchsByHashKey(matchHashKey);
		if (rtMatchs != null && rtMatchs.size() > 0) {
			rtMatchDB = rtMatchs.get(0);
		} else {
			rtMatchDB = null;
		}

		return rtMatchDB;
	}

	/**
	 * Update previous match.
	 * 
	 * @param rtMark
	 *            the rt mark
	 * @param rtMatch
	 *            the rt match
	 * @return the rt match
	 */
	private RtMatch updatePreviousMatch(final RtMarket rtMark,
			final RtMatch rtMatch) {
		RtMatch rtMatchFinal = (RtMatch) rtMatch.clone();
		RtMarket rtMarketFinal = (RtMarket) rtMark.clone();

		boolean encontrado = false;
		Iterator<RtMarket> iterator = rtMatchFinal.getRtMarkets().iterator();
		while (iterator.hasNext() && !encontrado) {
			RtMarket rtMarketIt = iterator.next();
			if (rtMarketIt.equals(rtMarketFinal)) {
				rtMatchFinal.remove(rtMarketIt);
				rtMatchFinal.add(rtMarketFinal);
				rtMatchFinal.setHashKey(rtMatchFinal.getHashKey());
				encontrado = true;
			}
		}
		// Si no ha encontrado nada es que es un nuevo market y lo agregamos
		if (!encontrado) {
			rtMatchFinal.add(rtMarketFinal);
		}
		return rtMatchFinal;
	}

	/**
	 * Resolver xml to rt resolver data.
	 * 
	 * @param rtMatch
	 *            the rt match
	 * @param xmlToRtResolverData
	 *            the xml to rt resolver data
	 * @return the xml to rt resolver data {@inheritDoc}
	 */
	protected XmlToRtResolverData resolverXmlToRtResolverData(RtMatch rtMatch,
			XmlToRtResolverData xmlToRtResolverData) {
		XmlToRtResolverData result = xmlToRtResolverData;
		if (xmlToRtResolverData != null && rtMatch != null) {
			xmlToRtResolverData.setMatch(rtMatch);
		}
		return result;
	}

}
