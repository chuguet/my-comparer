/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.IRtData;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBookmakerIdWeight;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatchId;
import com.comparadorad.bet.comparer.model.bet.bean.RtModa;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarket;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.BetBySportNotAllowedException;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.bean.XmlToRtResolverData;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class XmlToRtMatchResolver.
 * 
 */
@Component
class XmlToRtMatchResolver extends
		AbstractXmlToRtResolver<RtMatch, IRtData, XmlMatch> implements
		IXmlToRtMatchResolver {

	@Inject
	private ComparerWrapperLog LOG;

	/** The xml to rt market resolver. */
	@Inject
	private IXmlToRtMarketResolver xmlToRtMarketResolver;

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
	public RtMatch resolve(final XmlMatch xmlMatch, final IRtData pIRtData,
			final XmlToRtResolverData xmlToRtResolverData) {
		XmlToRtResolverData xmlToResolve = xmlToRtResolverData;
		RtMatchId rtMatchId;
		RtModa pModa;
		RtMatch rtMatch = new RtMatch();
		LOG.debug(Thread.currentThread(), "Inicio de procesado del xmlMatch");
		if (xmlMatch != null && xmlToResolve != null) {

			LOG.debug(Thread.currentThread(),
					"Convertimos los distintos elementos de xmlMatch");
			rtMatchId = map(xmlMatch, RtMatchId.class, "xmlMatchToRtMatchId",
					xmlToRtResolverData.getBookmaker(), xmlToRtResolverData);
			rtMatch = map(xmlMatch, RtMatch.class, "xmlMatchToRtMatch",
					xmlToRtResolverData.getBookmaker(), xmlToRtResolverData);
			pModa = createModa(rtMatch.getStartDate(),
					xmlToRtResolverData.getBookmaker());
			rtMatchId.addModa(pModa);
			rtMatch.setMatchId(rtMatchId);
			rtMatchId.setHistoricCreationData(getUser());
			rtMatch.setHistoricCreationData(getUser());

			// DESCOMENTAR SI SE QUIERE ELIMINAR LA DESACTIVACION PARA ELEMENTOS
			// DE LARGO PLAZO
			LOG.debug(Thread.currentThread(), "Activamos el evento");
			rtMatch.setCoreActiveElement(new CoreActiveElement(Boolean.TRUE));

			// INICIO BLOQUE COMENTAR SI SE QUIERE ELIMINAR LA DESACTIVACION
			// PARA ELEMENTOS DE LARGO PLAZO
			// LOG.debug("Comprobamos si el evento se mantiene activo o se desactiva");
			// if (rtMatchId.getCompetitionEvent().getLongTerm().getLongTerm()
			// .equals(Boolean.TRUE)) {
			// LOG.debug("El evento es de tipo ganador con lo que lo desactivamos");
			// rtMatch.setCoreActiveElement(new CoreActiveElement(
			// Boolean.FALSE));
			// } else {
			// LOG.debug("El evento no es de tipo ganador con lo que no lo desactivamos");
			// rtMatch.setCoreActiveElement(new
			// CoreActiveElement(Boolean.TRUE));
			// }
			// FIN BLOQUE COMENTAR SI SE QUIERE ELIMINAR LA DESACTIVACION PARA
			// ELEMENTOS DE LARGO PLAZO

			LOG.debug(Thread.currentThread(),
					new StringBuffer("Fijamos el rtMatch con el hashkey: ")
							.append(rtMatch.getHashKey()).toString());
			rtMatch.setHashKey(rtMatch.getHashKey());
			xmlToResolve = resolverXmlToRtResolverData(rtMatch, xmlToResolve);

			LOG.debug(Thread.currentThread(),
					"Resolvemos los distintos mercados del match");
			if (xmlMatch.getXmlMarkets() != null
					&& xmlMatch.getXmlMarkets().size() > 0) {
				for (XmlMarket market : xmlMatch.getXmlMarkets()) {
					RtMarket rtMarket = new RtMarket();

					try {
						rtMarket = xmlToRtMarketResolver.resolve(market,
								pIRtData, xmlToResolve);
						boolean addMarket = checkUpdateMarkets(rtMarket,
								rtMatch);
						// Si el market no tiene apuestas no tiene sentido
						// añadirlo al match
						if (rtMarket != null && rtMarket.getBets() != null
								&& rtMarket.getBetType() != null
								&& rtMarket.getBetType().getNameId() != null
								&& rtMarket.getBets().size() > 0 && addMarket) {
							rtMatch.add(rtMarket);
						}
					} catch (BetBySportNotAllowedException e) {	
						LOG.warn(Thread.currentThread(), e.getMessage(), e);
					}

				}
			}

			// Se pone el nombre del evento que nos indique el reader para largo
			// plazo, para el resto se deja como estaba
			if (rtMatch.getMatchId().getCompetitionEvent().getLongTerm()
					.getLongTerm().equals(Boolean.TRUE)) {
				rtMatch.setName(xmlMatch.getName());
			} else {
				rtMatch = rtMatchNameResolver.resolveNameField(rtMatch);
			}

		}

		rtMatch.setHashKey(rtMatch.getHashKey());
		LOG.debug(Thread.currentThread(), "Fin de procesado del xmlMatch");
		return rtMatch;
	}

	private RtModa createModa(CoreDate coreDate,
			CfgBookmaker bookmaker) {
		RtModa moda = new RtModa();
		moda.addMatchers(new RtBookmakerIdWeight(bookmaker));
		moda.setElement(coreDate);
		return moda;
	}

	private boolean checkUpdateMarkets(RtMarket rtMartket, RtMatch rtMatch) {
		boolean addMarket = true;
		for (RtMarket previousMarket : rtMatch.getRtMarkets()) {
			// Si el tipo de apuesta ya se habia tratado solo añadimos las bets
			// al market en vez de añadir un nuevo market
			if (previousMarket.getBetType().getNameId()
					.equals(rtMartket.getBetType().getNameId())
					&& previousMarket
							.getBetTypeEvent()
							.getBetTypeEvent()
							.getNameId()
							.equals(rtMartket.getBetTypeEvent()
									.getBetTypeEvent().getNameId())) {
				addMarket = false;
				LOG.debug(Thread.currentThread(),
						"El mercado ya existia en el evento con lo que añadimos las apuestas nuevas");
				// Si son iguales solo añado las nuevas apuestas al mercado ya
				// existente y salgo;
				for (RtBet bet : rtMartket.getBets()) {
					previousMarket.add(bet);
				}
				break;
			}
		}

		return addMarket;
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
	protected XmlToRtResolverData resolverXmlToRtResolverData(
			final RtMatch rtMatch, final XmlToRtResolverData xmlToRtResolverData) {
		XmlToRtResolverData result = xmlToRtResolverData;
		if (xmlToRtResolverData != null && rtMatch != null) {
			xmlToRtResolverData.setMatch(rtMatch);
		}
		return result;
	}

}
