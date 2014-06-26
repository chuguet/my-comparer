/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2Attribute;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2HandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMasMenosAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMarketBet;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.bean.XmlToRtResolverData;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class XmlToRtBetResolver.
 * 
 * @param <T>
 *            the generic type
 * @param <I>
 *            the generic type
 */
@Service
class XmlToRtBetResolver extends AbstractXmlToRtResolver<RtBet, RtMarket, XmlMarketBet> implements IXmlToRtBetResolver {

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

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
	public RtBet resolve(final XmlMarketBet pXmlData, final RtMarket rtMarket, final XmlToRtResolverData pXmlToRtResolverData) {
		RtBet result = new RtBet();
		LOG.debug(Thread.currentThread(), "Inicio mapeo apuestas");
		if (pXmlData != null && pXmlToRtResolverData != null && pXmlToRtResolverData.getBookmaker() != null) {

			result = mapBet(pXmlData, pXmlToRtResolverData);

			result = processBetParticipants(pXmlToRtResolverData, pXmlData, result);
			if (result == null) {
				LOG.debug(Thread.currentThread(),
						"La apuesta no ha podido resolver su participante sin BD, se procede a buscarlo a traves de la BD");
				result = mapBetByDatabase(pXmlData, pXmlToRtResolverData);
			}

			if (result != null) {
				result.setBookmaker(pXmlToRtResolverData.getBookmaker());
				result.setHistoricCreationData(getUser());
				result.setHistoricCreationData(getUser());
				result.setUpdated(false);
				result.setHashKey(result.getHashKey());
			}

		}
		LOG.debug(Thread.currentThread(), "Fin mapeo apuestas");
		return result;
	}

	/**
	 * Procesa los participantes de la apuesta, para las apuestas de tipo mas
	 * menos que no tienen participantes indica si es de tipo Mas o Menos, y
	 * para las apuestas de tipo "X" les pone el RtParticipant por defecto con
	 * home y away a false
	 * 
	 * @param pXmlToRtResolverData
	 *            Contenedor de datos para propagar la información entre los
	 *            distintos pasos del process
	 * @param pXmlData
	 *            La apuesta leida del Xml
	 * @param result
	 *            La apuesta en formato Rt mapeada parcialmente
	 * @return RtBet resultante del procesado de los participantes
	 */
	private RtBet processBetParticipants(final XmlToRtResolverData pXmlToRtResolverData, final XmlMarketBet pXmlData,
			final RtBet betSemiProcesada) {
		RtBet result = (RtBet) betSemiProcesada.clone();
		for (RtParticipant rtParticipant : pXmlToRtResolverData.getMatch().getMatchId().getParticipiants()) {
			String cfgParticipant = rtParticipant.getCfgParticipant().getParticipantXmlName();
			if (pXmlData.getXmlMatchParticipant() != null) {
				if (cfgParticipant.equals(pXmlData.getXmlMatchParticipant().getName())) {
					result.setParticipant(rtParticipant);
					LOG.debug(Thread.currentThread(),
							new StringBuffer("Se ha resuelto el participante ").append(rtParticipant.getCfgParticipant().getName(null))
									.toString());
					break;
				}
			}
		}

		Boolean empate = Boolean.FALSE;
		if (result.getAttribute() instanceof Rt1X2Attribute) {
			Rt1X2Attribute atributo = (Rt1X2Attribute) result.getAttribute();
			if (atributo.getResult().equals(Result.DRAW)) {
				empate = Boolean.TRUE;
			}
		} else if (result.getAttribute() instanceof Rt1X2HandicapAttribute) {
			Rt1X2HandicapAttribute atributo = (Rt1X2HandicapAttribute) result.getAttribute();
			if (atributo.getResult().equals(Result.DRAW)) {
				empate = Boolean.TRUE;
			}
		}

		if (result.getAttribute().getBetName().equals("Mas_Menos")) {
			LOG.debug(Thread.currentThread(),
					"La apuesta es de tipo mas/menos con lo que solo indicamos en el participante si es mas o menos");
			RtMasMenosAttribute atributo = (RtMasMenosAttribute) result.getAttribute();
			RtParticipant participante = new RtParticipant();
			result.setParticipant(participante);
			if (atributo.getMasMenos().equals(MasMenos.MAS)) {
				result.getParticipant().setOver(Boolean.TRUE);
			} else {
				result.getParticipant().setUnder(Boolean.TRUE);
			}
		} else if (empate) {
			LOG.debug(Thread.currentThread(), "La apuesta es de tipo empate con lo que no hay participante dentro de ella");
			if (result.getParticipant() == null) {
				result.setParticipant(new RtParticipant());
			}
		} else if (result.getParticipant() == null) {
			LOG.debug(Thread.currentThread(),
					new StringBuffer("No se ha podido resolver el participante sin consultas en BD para el nombre de participante: ")
							.append(pXmlData.getXmlMatchParticipant().getName()).toString());
			result = null;
		}

		return result;
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
	protected XmlToRtResolverData resolverXmlToRtResolverData(final RtBet pBet, final XmlToRtResolverData pResolverData) {
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
	private RtBet mapBet(final XmlMarketBet xmlBet, final XmlToRtResolverData pXmlToRtResolverData) {
		RtBet result = new RtBet();
		result = map(xmlBet, RtBet.class, "xmlMarketBetToRtBet", pXmlToRtResolverData.getBookmaker(), pXmlToRtResolverData);
		result.setHashKey(result.getHashKey());
		return result;
	}

	/**
	 * Map bet by DB.
	 * 
	 * @param xmlBet
	 *            the xml bet
	 * @param pXmlToRtResolverData
	 *            the xml to rt resolver data
	 * @return the rt bet
	 */
	private RtBet mapBetByDatabase(final XmlMarketBet xmlBet, final XmlToRtResolverData pXmlToRtResolverData) {
		RtBet result = new RtBet();
		result = map(xmlBet, RtBet.class, "xmlMarketBetToRtBetByDB", pXmlToRtResolverData.getBookmaker(), pXmlToRtResolverData);
		result.setHashKey(result.getHashKey());
		return result;
	}
}
