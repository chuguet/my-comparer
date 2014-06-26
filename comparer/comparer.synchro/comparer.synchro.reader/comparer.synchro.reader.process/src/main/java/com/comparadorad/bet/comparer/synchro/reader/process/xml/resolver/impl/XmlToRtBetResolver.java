/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.bet.bean.AbstractRtAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bean.StrategyData;
import com.comparadorad.bet.comparer.synchro.reader.process.resolver.strategy.bet.IStrategyResolverBet;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.bean.XmlToRtResolverData;

/**
 * The Class XmlToRtBetResolver.
 * 
 * @param <T>
 *            the generic type
 * @param <I>
 *            the generic type
 */
@Service
class XmlToRtBetResolver extends
		AbstractXmlToRtResolver<RtBet, RtMarket, XmlMarketBet> implements
		IXmlToRtBetResolver {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(XmlToRtBetResolver.class);

	/** The strategy resolver bet. */
	@SuppressWarnings("rawtypes")
	@Inject
	private List<IStrategyResolverBet> strategyResolverBet;

	@Inject
	private CuotaConverterUtil cuotaConverterUtil;

	/**
	 * Resolve.
	 * 
	 * @param pXmlData
	 *            the xml data
	 * @param pXmlToRtResolverData
	 *            the xml to rt resolver data
	 * @return the rt bet {@inheritDoc}
	 */
	@Override
	public RtBet resolve(XmlMarketBet pXmlData, RtMarket rtMarket,
			XmlToRtResolverData pXmlToRtResolverData) {
		RtBet result = new RtBet();
		if (pXmlData != null && pXmlToRtResolverData != null
				&& pXmlToRtResolverData.getBookmaker() != null) {
			result = mapBet(pXmlData, pXmlToRtResolverData);
			if (result != null) {
				if (pXmlData.getParent().getXmlBetType() != null) {
					if (pXmlData.getParent().getXmlBetType().getName() != null) {
						String betTypeName = pXmlData.getParent()
								.getXmlBetType().getName();

						// Si existe el campo MarketBetValue interactuaremos con
						// el en vez de con el name, en los casos detectados
						// aunque el name si biene informado solo indica si es
						// visitante o local, cosa que ya viene tambien
						// informada en el participant
						if (pXmlToRtResolverData.getBookmaker()
								.getBookmakerXmlReader()
								.isXmlMarketBetEnabled()
								&& StringUtils.isNotEmpty(pXmlData
										.getMarketBetValue())) {
							result.setName(pXmlData.getName());
							pXmlData.setName(pXmlData.getMarketBetValue());
						}

						if (StringUtils.isEmpty(result.getBetOdd()
								.getAmericanOdds())) {
							result.getBetOdd().setAmericanOdds(
									cuotaConverterUtil.getAmericanOdds(result
											.getBetOdd()));
						} else if (StringUtils.isEmpty(result.getBetOdd()
								.getOdds())) {
							result.getBetOdd().setOdds(
									cuotaConverterUtil.getOdds(result
											.getBetOdd()));
						} else if (StringUtils.isEmpty(result.getBetOdd()
								.getFraOdds())) {
							result.getBetOdd().setFraOdds(
									cuotaConverterUtil.getFraOdds(result
											.getBetOdd()));
						}

						// Calculamos estrategias de apuesta
						StrategyData strategyData = new StrategyData(
								rtMarket.getBetType(),
								pXmlToRtResolverData.getBookmaker(),
								betTypeName);
						AbstractRtAttribute atributte = resolverAbstractRtAttribute(
								strategyData, result, pXmlData);
						result.setAttribute(atributte);
					}
				}

				result.setBookmaker(pXmlToRtResolverData.getBookmaker());
				result.setHistoricCreationData(getUser());
				result.add(getRtInternalId(pXmlData.getBmInternalId(),
						pXmlToRtResolverData));
				result.setHistoricCreationData(getUser());
				result.setUpdated(false);
				result.setHashKey(result.getHashKey());
			}

		}
		return result;
	}

	/**
	 * Resolve by hash key.
	 * 
	 * @param rtBetBD
	 *            the rt bet bd
	 * @param xmlBet
	 *            the xml bet
	 * @param pXmlToRtResolverData
	 *            the xml to rt resolver data
	 * @return the rt bet {@inheritDoc}
	 */
	@Override
	public RtBet resolveByHashKey(final RtBet rtBetBD, final RtMarket rtMarket,
			final XmlMarketBet xmlBet, XmlToRtResolverData pXmlToRtResolverData) {
		RtBet result = new RtBet();
		RtBet mapBet = new RtBet();

		String hashKeyBetBd = rtBetBD.getHashKey();
		mapBet = mapBet(xmlBet, pXmlToRtResolverData);
		if (xmlBet != null) {
			if (hashKeyBetBd.equals(mapBet.getHashKey())) {
				// Actualizo la apuesta o no hago nada segun se de.
				result = updateBets(rtBetBD, mapBet, pXmlToRtResolverData);
			} else {
				result = resolve(xmlBet, rtMarket, pXmlToRtResolverData);
			}
		}
		result.setHashKey(result.getHashKey());
		return result;
	}

	/**
	 * Update bets.
	 * 
	 * @param bet
	 *            the bet
	 * @param result
	 *            the result
	 * @param xmlToRtResolverData
	 *            the xml to rt resolver data
	 * @return the rt bet
	 */
	private RtBet updateBets(final RtBet bet, final RtBet result,
			XmlToRtResolverData xmlToRtResolverData) {
		// Comprobamos si las apuestas no son exactamente iguales, si lo son no
		// actualizo nada.
		RtBet rtBet = (RtBet) bet.clone();
		// Actualizo la apuesta que voy a devolver y luego en la resolucion del
		// market la comparare con la apuesta de BD
		rtBet.setAttribute(result.getAttribute());
		rtBet.setBetOdd(result.getBetOdd());
		rtBet.setBookmaker(result.getBookmaker());
		return rtBet;
	}

	/**
	 * Resolver abstract rt attribute.
	 * 
	 * @param pStrategyData
	 *            the strategy data
	 * @return the abstract rt attribute
	 */
	private AbstractRtAttribute resolverAbstractRtAttribute(
			StrategyData pStrategyData, RtBet result, XmlMarketBet pXmlData) {
		if (pStrategyData != null && pStrategyData.getXmlBetTypeName() != null
				&& pStrategyData.getBetType() != null) {
			CfgBetType betType = pStrategyData.getBetType();
			IStrategyResolverBet iStrategyResolverBet = null;

			for (IStrategyResolverBet strategy : strategyResolverBet) {
				if (betType != null && betType.getNameId() != null
						&& betType.getNameId().equals(strategy.getName())) {
					iStrategyResolverBet = strategy;
					break;
				}
			}
			if (iStrategyResolverBet != null) {
				return iStrategyResolverBet.resolverAbstractRtResult(
						pStrategyData, pXmlData, result);
			}
		} else {
			getSynchroErrorEvent()
					.errorLog(
							"No se ha encontrado la estrategía para resolver la apuesta",
							pStrategyData, pStrategyData.getBookmaker());
		}
		return null;
	}

	/**
	 * Resolver xml to rt resolver data.
	 * 
	 * @param pBet
	 *            the bet
	 * @param pResolverData
	 *            the resolver data
	 * @return the xml to rt resolver data {@inheritDoc}
	 */
	@Override
	protected XmlToRtResolverData resolverXmlToRtResolverData(RtBet pBet,
			XmlToRtResolverData pResolverData) {
		return pResolverData;
	}

	/**
	 * Map bet.
	 * 
	 * @param xmlBet
	 *            the xml bet
	 * @param pXmlToRtResolverData
	 *            the xml to rt resolver data
	 * @return the rt bet
	 */
	private RtBet mapBet(XmlMarketBet xmlBet,
			XmlToRtResolverData pXmlToRtResolverData) {
		RtBet result = new RtBet();
		result = map(xmlBet, RtBet.class, "xmlMarketBetToRtBet",
				pXmlToRtResolverData.getBookmaker(), pXmlToRtResolverData);
		result.setHashKey(result.getHashKey());
		return result;
	}

}
