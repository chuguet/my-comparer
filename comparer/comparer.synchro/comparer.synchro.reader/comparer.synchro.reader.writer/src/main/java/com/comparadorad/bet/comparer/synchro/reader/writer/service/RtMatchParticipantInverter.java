/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.writer.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.AsianResult;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2Attribute;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2HandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtAsianHandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtGanadorPartidoAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.synchro.reader.writer.exception.InconsistentParticipantOrderException;
import com.comparadorad.bet.comparer.synchro.reader.writer.exception.SynchroMatchWriterServiceException;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class RtMatchParticipantInverter.
 */
@Component
class RtMatchParticipantInverter {

	/** The Constant participantInversionNotRequiered. */
	private static final List<String> participantInversionNotRequiered;

	static {
		participantInversionNotRequiered = new ArrayList<String>();
		participantInversionNotRequiered.add(CfgBetTypeId.MAS_MENOS.id());
		participantInversionNotRequiered.add(CfgBetTypeId.GANADOR.id());
		participantInversionNotRequiered.add(CfgBetTypeId.MAXIMO_GOLEADOR.id());
	}

	/** The LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/**
	 * Gets the away participant.
	 * 
	 * @param participiants
	 *            the participiants
	 * @return the away participant
	 * @throws NullPointerException
	 *             the null pointer exception
	 */
	private RtParticipant getAwayParticipant(Set<RtParticipant> participiants)
			throws NullPointerException {
		for (RtParticipant part : participiants) {
			if (part.isAwayParticipant()) {
				return part;
			}
		}
		throw new NullPointerException("El partido no tiene homeParticipant");
	}

	/**
	 * Gets the home participant.
	 * 
	 * @param participiants
	 *            the participiants
	 * @return the home participant
	 * @throws NullPointerException
	 *             the null pointer exception
	 */
	private RtParticipant getHomeParticipant(Set<RtParticipant> participiants)
			throws NullPointerException {
		for (RtParticipant part : participiants) {
			if (part.isHomeParticipant()) {
				return part;
			}
		}
		throw new NullPointerException("El partido no tiene homeParticipant");
	}

	/**
	 * Invert bet attribute.
	 * 
	 * @param bet
	 *            the bet
	 * @return the rt bet
	 */
	private RtBet invertBetAttribute(RtBet bet) {

		RtBet result = bet;

		if (bet.getAttribute() instanceof RtGanadorPartidoAttribute) {
			RtGanadorPartidoAttribute attr = ((RtGanadorPartidoAttribute) bet
					.getAttribute());
			if (attr.getResult().equals(Result.ONE)) {
				attr.setResult(Result.TWO);
			} else if (attr.getResult().equals(Result.TWO)) {
				attr.setResult(Result.ONE);
			}
			attr.setWinnerName(bet.getParticipant().getCfgParticipant()
					.getName(null));
			result.setAttribute(attr);
		} else if (bet.getAttribute() instanceof Rt1X2Attribute) {
			Rt1X2Attribute attr = ((Rt1X2Attribute) bet.getAttribute());
			if (attr.getResult().equals(Result.ONE)) {
				attr.setResult(Result.TWO);
			} else if (attr.getResult().equals(Result.TWO)) {
				attr.setResult(Result.ONE);
			}
			result.setAttribute(attr);
		} else if (bet.getAttribute() instanceof Rt1X2HandicapAttribute) {
			Rt1X2HandicapAttribute attr = (Rt1X2HandicapAttribute) bet
					.getAttribute();
			if (attr.getResult().equals(Result.ONE)) {
				attr.setResult(Result.TWO);
			} else if (attr.getResult().equals(Result.TWO)) {
				attr.setResult(Result.ONE);
			}
			attr.setFinalValue(-1 * attr.getFinalValue());
			attr.setFirstValue(-1 * attr.getFirstValue());
			if (attr.getSecondValue() != null) {
				attr.setSecondValue(-1 * attr.getSecondValue());
			}
			result.setAttribute(attr);
		} else if (bet.getAttribute() instanceof RtAsianHandicapAttribute) {
			RtAsianHandicapAttribute attr = (RtAsianHandicapAttribute) bet
					.getAttribute();
			if (attr.getAsianResult().equals(AsianResult.ONE)) {
				attr.setAsianResult(AsianResult.TWO);
			} else if (attr.getAsianResult().equals(AsianResult.TWO)) {
				attr.setAsianResult(AsianResult.ONE);
			}
			attr.setFinalValue(-1 * attr.getFinalValue());
			attr.setFirstValue(-1 * attr.getFirstValue());
			if (attr.getSecondValue() != null) {
				attr.setSecondValue(-1 * attr.getSecondValue());
			}
			result.setAttribute(attr);
		}
		return result;
	}

	/**
	 * Invert bet participants.
	 * 
	 * @param bet
	 *            the bet
	 * @param homeParticipantDB
	 *            the home participant db
	 * @param awayParticipantDB
	 *            the away participant db
	 * @return the rt bet
	 * @throws InconsistentParticipantOrderException
	 *             the inconsistent participant order exception. Se supone que
	 *             hasta aqui solo llegan bets que pertenecen a partidos donde
	 *             el orden de los participantes esta invertido. Si un bet NO
	 *             tiene los participantes invertidos se salta la siguiente
	 *             exception. No se va a procesar el mercado correspondiente ya
	 *             que si ocurre esto falla algo en el reader.
	 */
	private RtBet invertBetParticipants(RtBet bet,
			RtParticipant homeParticipantDB, RtParticipant awayParticipantDB)
			throws InconsistentParticipantOrderException {

		RtBet result = bet;

		if (bet.getParticipant().isHomeParticipant()
				&& !bet.getParticipant().equals(homeParticipantDB)) {
			result.setParticipant(awayParticipantDB);
		} else if (bet.getParticipant().isAwayParticipant()
				&& !bet.getParticipant().equals(awayParticipantDB)) {
			result.setParticipant(homeParticipantDB);
		} else if (bet.getParticipant().getCfgParticipant() == null) {
			// Apuesta DRAW - do nothing
		} else {
			throw new InconsistentParticipantOrderException(bet,
					homeParticipantDB, awayParticipantDB);
		}
		result = invertBetAttribute(result);
		// Reseteamos el hashKey
		result.getHashKey();

		return result;
	}

	/**
	 * Invert market participants.
	 * 
	 * @param rtMatch
	 *            the rt match
	 * @param homeParticipantDB
	 *            the home participant db
	 * @param awayParticipantDB
	 *            the away participant db
	 * @return the rt match
	 */
	private RtMatch invertMarketParticipants(RtMatch rtMatch,
			RtParticipant homeParticipantDB, RtParticipant awayParticipantDB) {
		LOG.debug(Thread.currentThread(),
				"Inicio inversion de participantes a nivel de mercado");

		RtMatch result = rtMatch;
		Set<RtMarket> invertedMarkets = new HashSet<RtMarket>();
		Set<RtBet> invertedBets;

		for (RtMarket market : rtMatch.getRtMarkets()) {
			try {
				if (marketRequiereParticipantInversion(market)) {
					LOG.debug(Thread.currentThread(), new StringBuffer(
							"Vamos a invertir los participantes del mercado: ")
							.append(market.getBetType().getNameId()).toString());
					invertedBets = new HashSet<RtBet>();
					for (RtBet bet : market.getBets()) {
						bet = invertBetParticipants(bet, homeParticipantDB,
								awayParticipantDB);
						invertedBets.add(bet);
					}
					market.setBets(invertedBets);
				}
				invertedMarkets.add(market);
			} catch (InconsistentParticipantOrderException e) {
				LOG.error(Thread.currentThread(),
						new StringBuffer("No vamos a procesar el mercado: ")
								.append(market.getBetType().getNameId())
								.toString(), e);
			}
		}
		result.setRtMarkets(invertedMarkets);

		LOG.debug(Thread.currentThread(),
				"Fin inversion de participantes a nivel de mercado");
		return result;
	}

	/**
	 * Invert match participants.
	 * 
	 * @param rtMatch
	 *            the rt match
	 * @param rtMatchDB
	 *            the rt match db
	 * @return the rt match
	 */
	private RtMatch invertMatchParticipants(RtMatch rtMatch, RtMatch rtMatchDB) {
		RtMatch result = rtMatch;
		result.getMatchId().setParticipiants(
				rtMatchDB.getMatchId().getParticipiants());
		return result;
	}

	/**
	 * Invert participants.
	 * 
	 * @param rtMatch
	 *            the rt match
	 * @param rtMatchDB
	 *            the rt match db
	 * @return the rt match
	 * @throws SynchroMatchWriterServiceException
	 *             the synchro match writer service exception
	 */
	public RtMatch invertParticipants(RtMatch rtMatch, RtMatch rtMatchDB)
			throws SynchroMatchWriterServiceException {
		LOG.debug(Thread.currentThread(), "Inicio inversion de participantes");

		RtMatch result = rtMatch;
		RtParticipant homeParticipantDB;
		RtParticipant awayParticipantDB;
		RtParticipant homeParticipant;
		RtParticipant awayParticipant;

		if (!isLongTerm(rtMatch)) {
			LOG.debug(
					Thread.currentThread(),
					"El evento es de corto plazo - Se procede a verificar el orden de los participantes");
			try {
				homeParticipantDB = getHomeParticipant(rtMatchDB.getMatchId()
						.getParticipiants());
				awayParticipantDB = getAwayParticipant(rtMatchDB.getMatchId()
						.getParticipiants());
				homeParticipant = getHomeParticipant(rtMatch.getMatchId()
						.getParticipiants());
				awayParticipant = getAwayParticipant(rtMatch.getMatchId()
						.getParticipiants());
			} catch (NullPointerException e) {
				throw new SynchroMatchWriterServiceException(e.getMessage(), e);
			}
			LOG.debug(
					Thread.currentThread(),
					new StringBuffer("Participante local correcto: id = ")
							.append(homeParticipantDB.getCfgParticipant()
									.getObjectId().toString())
							.append(", name = ")
							.append(homeParticipantDB.getCfgParticipant()
									.getName(null)).toString());
			LOG.debug(
					Thread.currentThread(),
					new StringBuffer("Participante visitante correcto: id = ")
							.append(awayParticipantDB.getCfgParticipant()
									.getObjectId().toString())
							.append(", name = ")
							.append(awayParticipantDB.getCfgParticipant()
									.getName(null)).toString());
			if (isParticipantsInverted(homeParticipant, homeParticipantDB,
					awayParticipant, awayParticipantDB)) {
				// A nivel de RtMatchId
				result = invertMatchParticipants(result, rtMatchDB);
				// A nivel de bet
				result = invertMarketParticipants(result, homeParticipantDB,
						awayParticipantDB);
			}

		} else {
			LOG.debug(Thread.currentThread(),
					"El evento es de largo plazo - No se va a invertir participantes");
		}

		LOG.debug(Thread.currentThread(), "Fin inversion de participantes");
		return result;
	}

	/**
	 * Checks if is long term.
	 * 
	 * @param rtMatch
	 *            the rt match
	 * @return the boolean
	 */
	private Boolean isLongTerm(RtMatch rtMatch) {
		return rtMatch.getCompetitionEvent().getLongTerm().getLongTerm();
	}

	/**
	 * Checks if is participants inverted.
	 * 
	 * @param homeParticipant
	 *            the home participant
	 * @param homeParticipantDB
	 *            the home participant db
	 * @param awayParticipant
	 *            the away participant
	 * @param awayParticipantDB
	 *            the away participant db
	 * @return the boolean
	 */
	private Boolean isParticipantsInverted(RtParticipant homeParticipant,
			RtParticipant homeParticipantDB, RtParticipant awayParticipant,
			RtParticipant awayParticipantDB) {

		if (!homeParticipant.equals(homeParticipantDB)
				&& !awayParticipant.equals(awayParticipantDB)) {
			LOG.debug(Thread.currentThread(),
					"Los participantes estan invertidos");
			return Boolean.TRUE;
		}
		LOG.debug(Thread.currentThread(),
				"Los participantes NO estan invertidos");
		return Boolean.FALSE;

	}

	/**
	 * Market requiere participant inversion.
	 * 
	 * @param market
	 *            the market
	 * @return the boolean
	 */
	private Boolean marketRequiereParticipantInversion(RtMarket market) {
		if (!participantInversionNotRequiered.contains(market.getBetType()
				.getObjectId().toString())) {
			return Boolean.TRUE;
		} else {
			LOG.debug(Thread.currentThread(), new StringBuffer(
					"Mercado que no requiere inversion de participantes: ")
					.append(market.getBetType().getNameId()).toString());
			return Boolean.FALSE;
		}
	}

}
