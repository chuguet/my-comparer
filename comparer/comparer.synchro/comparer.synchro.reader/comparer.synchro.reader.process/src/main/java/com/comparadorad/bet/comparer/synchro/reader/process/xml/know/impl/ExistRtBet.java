/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.xml.know.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;
import com.comparadorad.bet.comparer.model.bet.bean.RtInternalId;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.core.bean.Historic;
import com.comparadorad.bet.comparer.model.core.bean.HistoricChange;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.know.bean.ExistBetData;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.know.bean.ExistData;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.impl.IXmlToRtBetResolver;

/**
 * The Class ExistRtBet.
 */
@Component
class ExistRtBet extends AbstractRtData implements IExistRtBet {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ExistRtBet.class);

	/** The Constant USER. */
	private final static String USER = "system";

	/** The xml bet identifier. */
	private String xmlInternalBetIdentifier = "";

	/** The internal bet bookmaker. */
	private CfgBookmaker internalBetBookmaker;

	/** The xml to rt market resolver. */
	@Inject
	private IXmlToRtBetResolver xmlToRtBetResolver;

	/**
	 * Exist.
	 * 
	 * @param xmlMarketBet
	 *            the xml market bet
	 * @param pExistRtDataData
	 *            the exist rt data data
	 * @return the exist bet data {@inheritDoc}
	 */
	@Override
	public ExistBetData exist(XmlMarketBet xmlMarketBet,
			ExistData pExistRtDataData) {
		ExistBetData existBetData = new ExistBetData(true);
		RtBet rtBet = new RtBet();
		RtMarket previousMarket = new RtMarket();
		RtMatch rtMatch = pExistRtDataData.getRtMatch();
		Set<RtMarket> markets = rtMatch.getRtMarkets();
		// Obtengo el internalID del objeto generado a partir del XML
		xmlInternalBetIdentifier = xmlMarketBet.getBmInternalId().getValue();

		// Obtengo el mercado q nos interesa para que a la hora de mirar
		// por las apuestas solo miramos las de ese mercado.
		for (RtMarket merc : markets) {
			Set<RtInternalId> internalId = merc.getRtInternalIds();
			for (RtInternalId id : internalId) {
				if (id.getRtBmInternalId().getValue() == pExistRtDataData
						.getBeanMarketId()) {
					previousMarket = merc;
					break;
				}
			}
		}
		// Obtengo las apuestas del market q estamos analizando
		Set<RtBet> bets = previousMarket.getBets();
		boolean encontrado = false;
		if (!bets.isEmpty()) {
			Iterator<RtBet> iterator = bets.iterator();
			while (iterator.hasNext() && !encontrado) {
				RtBet iteratorBet = iterator.next();
				Set<RtInternalId> internalId = iteratorBet.getRtInternalIds();
				for (RtInternalId i : internalId) {
					if (xmlInternalBetIdentifier.equals(i.getRtBmInternalId()
							.getValue())) {
						LOG.debug("Hemos encontrado el bet dentro del market con lo que trabajamos con el de BD");
						encontrado = true;
						// Bookmaker de la apuesta
						internalBetBookmaker = i.getCfgBookmaker();
						existBetData = new ExistBetData(false);
						// Actualizamos las apuestas
						RtBet bet = updateBets(iteratorBet, xmlMarketBet,
								pExistRtDataData);
						if (bet != null) {
							bet.setHashKey(bet.getHashKey());
							existBetData.setPreviousRtBet(iteratorBet);
							existBetData.setRtData(bet);
						} else {
							existBetData = new ExistBetData(true);
						}
					}
					break;
				}
			}
		}
		if (existBetData.getIsNew() && !encontrado) {
			LOG.debug("No hemos encontrado el bet dentro del market con lo que resolvemos");
			rtBet = xmlToRtBetResolver.resolve(xmlMarketBet, previousMarket,
					pExistRtDataData.getXmlToRtResolverData());
			existBetData = new ExistBetData(false);
			rtBet.setHashKey(rtBet.getHashKey());
			existBetData.setRtData(rtBet);
		}
		return existBetData;
	}

	/**
	 * Update bets.
	 * 
	 * @param bet
	 *            the bet
	 * @param xmlMarketBet
	 *            the xml market bet
	 * @param pExistData
	 *            the exist data
	 * @return the rt bet
	 */
	private RtBet updateBets(final RtBet bet, final XmlMarketBet xmlMarketBet,
			final ExistData pExistData) {
		RtBetOdd rtBetOdd = new RtBetOdd();
		boolean newBet = false;
		// Comprobamos si las apuestas no son iguales, si lo son no actualizo.
		RtBet rtBet = (RtBet) bet.clone();
		if (xmlMarketBet.getXmlBetOdd() != null) {
			if (rtBet.getBetOdd() != null) {
				if (rtBet.getBetOdd().getAmericanOdds() != null
						|| rtBet.getBetOdd().getFraOdds() != null
						|| rtBet.getBetOdd().getOdds() != null) {
					if ((rtBet.getBetOdd().getAmericanOdds() != null && !rtBet
							.getBetOdd()
							.getAmericanOdds()
							.equals(xmlMarketBet.getXmlBetOdd()
									.getAmericanOdds()))
							|| (rtBet.getBetOdd().getFraOdds() != null && !rtBet
									.getBetOdd()
									.getFraOdds()
									.equals(xmlMarketBet.getXmlBetOdd()
											.getFraOdds()))
							|| (rtBet.getBetOdd().getOdds() != null && !rtBet
									.getBetOdd()
									.getOdds()
									.equals(xmlMarketBet.getXmlBetOdd()
											.getOdds()))) {
						LOG.debug("Las cuotas de las apuestas han cambiado, actualizamos los datos");
						// Añadimos a la apuesta las apuestas anteriores
						rtBet.add(rtBet.getBetOdd());
						rtBet.setUpdated(true);

						// Modificamos la apuesta con los nuevos valores
						rtBetOdd.setAmericanOdds(xmlMarketBet.getXmlBetOdd()
								.getAmericanOdds());
						rtBetOdd.setFraOdds(xmlMarketBet.getXmlBetOdd()
								.getFraOdds());
						rtBetOdd.setOdds(xmlMarketBet.getXmlBetOdd().getOdds());
						rtBet.setBookmaker(pExistData.getBookmaker());
						rtBet.setBetOdd(rtBetOdd);
						newBet = true;
					}
				}
			} else {
				rtBetOdd.setAmericanOdds(xmlMarketBet.getXmlBetOdd()
						.getAmericanOdds());
				rtBetOdd.setFraOdds(xmlMarketBet.getXmlBetOdd().getFraOdds());
				rtBetOdd.setOdds(xmlMarketBet.getXmlBetOdd().getOdds());
				rtBet.setBookmaker(pExistData.getBookmaker());
				rtBet.setBetOdd(rtBetOdd);
			}
		}
		if (newBet) {
			rtBet.setHistoric(setHistoric());
			return rtBet;
		} else {
			return null;
		}

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
		historicChange.setUser(USER);
		historico.add(historicChange);

		return historico;
	}

}
