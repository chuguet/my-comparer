/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten;

import static com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten.InterwettenHandicapUtil.getHandicapBetEvent;
import static com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten.InterwettenHandicapUtil.isAsianHandicap;
import static com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten.InterwettenHandicapUtil.isHandicap1X2;
import static com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten.InterwettenMatchWinner1X2Util.getMatchWinner1X2BetEvent;
import static com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten.InterwettenMatchWinner1X2Util.is1X2;
import static com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten.InterwettenMatchWinner1X2Util.isMatchWinner;
import static com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten.InterwettenOverUnderUtil.getOverUnderBetEvent;
import static com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten.InterwettenOverUnderUtil.isOverUnder;
import static com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.interwetten.InterwettenWinnerUtil.isWinner;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlTournament;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.interwetten.FEED.KINDOFSPORT.LEAGUE.EVENT;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.interwetten.FEED.KINDOFSPORT.LEAGUE.EVENT.BET;
import com.comparadorad.bet.comparer.util.logger.readerdatanoprocessed.LogReaderDataNoProcessed;

/**
 * The Class InterwettenUtil.
 */
@Component
public class InterwettenUtil {

	@Inject
	private LogReaderDataNoProcessed LOG_DATA_NO_PROCESSED;

	/** The forbiddenword player. */
	private static List<String> forbiddenwordPlayer;

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(InterwettenUtil.class);

	static {
		forbiddenwordPlayer = new ArrayList<String>();
		forbiddenwordPlayer.add("Over");
		forbiddenwordPlayer.add("Under");
	}

	/**
	 * Bet group to string.
	 * 
	 * @param betGroup
	 *            the bet group
	 * @return the string
	 */
	public static String betGroupToString(List<BET> betGroup) {
		StringBuffer logMsg = new StringBuffer();
		for (int i = 0; i < betGroup.size(); i++) {
			logMsg.append(betGroup.get(i));
			if (i < betGroup.size() - 1) {
				logMsg.append("\n ");
			}
		}
		return logMsg.toString();
	}

	/**
	 * Clean participant name.
	 * 
	 * @param participantName
	 *            the participant name
	 * @param betTypeAndBetTypeEvent
	 *            the bet type and bet type event
	 * @return the string
	 */
	private static String cleanParticipantName(String participantName,
			BetTypeAndBetTypeEvent betTypeAndBetTypeEvent) {
		String result = "";
		if (betTypeAndBetTypeEvent.getBetType().equals(
				BetTypeInterwetten.HANDICAP_ASIATICO)) {
			result = participantName.substring(0, participantName.indexOf("("));
		}
		return result;
	}

	/**
	 * Equal bet.
	 * 
	 * @param presentBet
	 *            the present bet
	 * @param pastBet
	 *            the past bet
	 * @return the boolean
	 */
	private static Boolean equalBet(final BET presentBet, final BET pastBet) {
		Boolean result = Boolean.FALSE;
		if (presentBet.getTYPEID().equals(pastBet.getTYPEID())) {
			result = Boolean.TRUE;
		}
		return result;
	}

	/**
	 * Gets the bet type interwetten.
	 * 
	 * @param bets
	 *            the bets
	 * @return the bet type interwetten
	 * @throws InterwettenBetTypeNotFoundException
	 *             the interwetten bet type exception
	 * @throws InterwettenBetTypeEventNotFoundException
	 *             the interwetten bet type event not found exception
	 */
	public BetTypeAndBetTypeEvent getBetType(List<BET> bets, XmlSport sport)
			throws InterwettenBetTypeNotFoundException,
			InterwettenBetTypeEventNotFoundException {
		BetTypeAndBetTypeEvent result = null;

		Integer betTypeId = bets.get(0).getTYPEID();

		if (isMatchWinner(betTypeId, bets)) {
			result = new BetTypeAndBetTypeEvent(
					BetTypeInterwetten.GANADOR_PARTIDO,
					getMatchWinner1X2BetEvent(betTypeId));
		} else if (is1X2(betTypeId, bets)) {
			result = new BetTypeAndBetTypeEvent(BetTypeInterwetten.UNO_X_DOS,
					getMatchWinner1X2BetEvent(betTypeId));
		} else if (isOverUnder(betTypeId, bets)) {
			result = new BetTypeAndBetTypeEvent(BetTypeInterwetten.MAS_MENOS,
					getOverUnderBetEvent(betTypeId));
		} else if (isHandicap1X2(betTypeId, bets)) {
			result = new BetTypeAndBetTypeEvent(
					BetTypeInterwetten.UNO_X_DOS_HANDICAP,
					getHandicapBetEvent(betTypeId));
		} else if (isAsianHandicap(betTypeId, bets)) {
			result = new BetTypeAndBetTypeEvent(
					BetTypeInterwetten.HANDICAP_ASIATICO,
					getHandicapBetEvent(betTypeId));
		} else if (isWinner(betTypeId)) {
			result = new BetTypeAndBetTypeEvent(BetTypeInterwetten.GANADOR,
					null);
		} else {
			StringBuffer logMsg = new StringBuffer();
			logMsg.append("No ha procesado el tipo de apuesta [ID: ");
			logMsg.append(betTypeId).append(" y NOMBRE: ")
					.append(bets.get(0).getTYPENAME()).append("]");
			LOG_DATA_NO_PROCESSED.info(logMsg.toString());
			throw new InterwettenBetTypeNotFoundException(logMsg.toString());
		}

		// Se tratan las exceptions correspondientes al tipo de deporte, las
		// excetions propias de etiquetas e Ids se tratan en su "Utils"
		// correspondiente
		if (result.getBetType() == BetTypeInterwetten.GANADOR_PARTIDO
				|| result.getBetType() == BetTypeInterwetten.HANDICAP_ASIATICO
				|| result.getBetType() == BetTypeInterwetten.MAS_MENOS) {
			if (InterwettenSportUtil.isAmericanFootball(sport.getName())
					|| InterwettenSportUtil.isBasketball(sport.getName())
					|| InterwettenSportUtil.isBaseball(sport.getName())) {
				if (result.getBetEvent() == BetTypeEventInterwetten.PARTIDO_COMPLETO) {
					result.setBetEvent(BetTypeEventInterwetten.PARTIDO_COMPLETO_PRORROGA);
				}
			}
		}

		if (LOG.isDebugEnabled()) {
			StringBuffer logMsg = new StringBuffer();
			logMsg.append("Se selecciona la apuesta de tipo: ");
			logMsg.append(result);
			logMsg.append(" Para el grupo:\n ");
			logMsg.append(betGroupToString(bets));
			LOG.debug(logMsg);
		}

		return result;
	}

	/**
	 * Group bet.
	 * 
	 * @param event
	 *            the event
	 * @return the list
	 */
	public static List<List<BET>> groupBet(EVENT event) {
		List<List<BET>> result = new ArrayList<List<BET>>();
		List<BET> bets = null;
		BET presentBet;
		BET pastBet = null;
		for (int i = 0; i < event.getBET().size(); i++) {
			presentBet = event.getBET().get(i);
			if (pastBet == null) {
				bets = new ArrayList<BET>();
				bets.add(presentBet);
			} else {
				if (equalBet(presentBet, pastBet)) {
					bets.add(presentBet);
				} else {
					result.add(bets);
					bets = new ArrayList<BET>();
					bets.add(presentBet);
				}
			}
			if (i == (event.getBET().size() - 1)) {
				result.add(bets);
			}
			pastBet = presentBet;
		}
		if (LOG.isDebugEnabled()) {
			StringBuffer logMsg = new StringBuffer();
			logMsg.append("Se ha creado los siguientes grupos de apuestas:");
			for (List<BET> betList : result) {
				logMsg.append("\n Se ha creado el grupo:\n ");
				logMsg.append(betGroupToString(betList));
			}
			logMsg.append("\n Fin agrupacion de apuestas");
			LOG.debug(logMsg);
		}
		return result;
	}

	/**
	 * Read away participant.
	 * 
	 * @param bet
	 *            the bet
	 * @param tournament
	 *            the tournament
	 * @param betTypeAndBetTypeEvent
	 *            the bet type and bet type event
	 * @return the xml match participant
	 */
	public static XmlMatchParticipant readAwayParticipant(final BET bet,
			final XmlTournament tournament,
			final BetTypeAndBetTypeEvent betTypeAndBetTypeEvent) {
		String participant = cleanParticipantName(bet.getPLAYER2(),
				betTypeAndBetTypeEvent);
		return new XmlMatchParticipant(participant, false, true, tournament);
	}

	/**
	 * Read home participant.
	 * 
	 * @param bet
	 *            the bet
	 * @param tournament
	 *            the tournament
	 * @param betTypeAndBetTypeEvent
	 *            the bet type and bet type event
	 * @return the xml match participant
	 */
	public static XmlMatchParticipant readHomeParticipant(final BET bet,
			final XmlTournament tournament,
			final BetTypeAndBetTypeEvent betTypeAndBetTypeEvent) {
		String participant = cleanParticipantName(bet.getPLAYER2(),
				betTypeAndBetTypeEvent);
		return new XmlMatchParticipant(participant, true, false, tournament);
	}

}
