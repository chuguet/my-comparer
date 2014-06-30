/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bookmaker;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The Class TournamentNameResolver.
 */
class TournamentNameResolver {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(TournamentNameResolver.class);

	/** The Constant LONG_TERM_EVENT_PATTERNS_TO_DELETE. */
	private final static String[] LONG_TERM_EVENT_PATTERNS_TO_DELETE = {
			"ODDS TO WIN THE ", "ODDS TO WIN ", "TO WIN - ", "TO WIN ",
			" - WINNER", "WINNER" };

	/** The Constant SHORT_TERM_EVENT_PATTERNS_TO_DELETE. */
	private final static String[] SHORT_TERM_EVENT_PATTERNS_TO_DELETE = {
			" - 1ST HALFS", " - QUARTERS", " - 2ND HALFS", " 1ST 5 FULL INN",
			" - ADJ-SPREAD/TOTALS", " - EXTRA GAMES", " - PERIODS",
			" - 3 WAY LINES" };

	/**
	 * Delete date notation. Quita una fecha que a veces viene al final del
	 * nombre de la competicion: 'BASKETBALL - GERMANY - Oct 09' será
	 * 'BASKETBALL - GERMANY'
	 * 
	 * @param tournamentNameWithDate
	 *            the tournament name with date
	 * @return the string
	 */
	private static String deleteDateNotation(String tournamentNameWithDate) {
		String tournamentNameWhitoutDate = tournamentNameWithDate.replaceAll(
				"\\s-\\s[A-Z][a-z][a-z]\\s\\d\\d", "");
		return tournamentNameWhitoutDate;
	}

	/**
	 * Resolve future event tournament name. En el xml vienen los nombres de la
	 * competicion de un evento de tipo largo plazo muchas veces como una frase
	 * entera. Por ejemplo: 'WORLS CUP 2015 - WINNER' y 'ODDS TO WIN THE UEFA
	 * CHAMPIONS LEAGUE 2013/14'
	 * 
	 * @param originalTournamentName
	 *            the original tournament name
	 * @return the string
	 */
	public static String resolveLongTermTournamentName(
			String originalTournamentName) {
		String tournamentName = originalTournamentName;
		for (String patternToDelete : LONG_TERM_EVENT_PATTERNS_TO_DELETE) {
			tournamentName = tournamentName.replace(patternToDelete, "");
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug(new StringBuffer()
					.append("Resolvemos nombre de competicion. En el xml viene como: ")
					.append(originalTournamentName)
					.append(". Nosotros guardamos: ").append(tournamentName));
		}
		return tournamentName;
	}

	/**
	 * Resolve tournament name. Resuleve el nombre de la competición en los
	 * casos donde el betTypeEvent llega en el nombre de ella. Por ejemplo: 'NFL
	 * - 2ND HALFS' y 'NFL - QUARTERS'
	 * 
	 * @param sportName
	 *            the sport name
	 * @param origTournamentName
	 *            the original tournament name
	 * @param addlTournamentName
	 *            the addl tournament name
	 * @return the string
	 */
	public static String resolveTournamentName(String sportName,
			String origTournamentName, String addlTournamentName) {
		String tournamentName;
		if (sportAsTournamentName(origTournamentName, sportName)
				|| sportInTournamentName(origTournamentName, sportName)) {
			tournamentName = deleteDateNotation(addlTournamentName);
			if (LOG.isDebugEnabled()) {
				LOG.debug(new StringBuffer()
						.append("Resolvemos nombre de competicion. En el xml viene como: ")
						.append(origTournamentName)
						.append(". Utilizamos el nombre addicional: ")
						.append(addlTournamentName)
						.append(". Al final guardamos: ")
						.append(tournamentName));
			}
		} else {
			tournamentName = origTournamentName;
			for (String patternToDelete : SHORT_TERM_EVENT_PATTERNS_TO_DELETE) {
				tournamentName = tournamentName.replace(patternToDelete, "");
			}
			if (LOG.isDebugEnabled()) {
				LOG.debug(new StringBuffer()
						.append("Resolvemos nombre de competicion. En el xml viene como: ")
						.append(origTournamentName)
						.append(". Nosotros guardamos: ")
						.append(tournamentName));
			}
		}
		return tournamentName;
	}

	/**
	 * Sport as tournament name.
	 * 
	 * @param tournamentName
	 *            the tournament name
	 * @param sportName
	 *            the sport name
	 * @return true, if successful
	 */
	private static boolean sportAsTournamentName(String tournamentName,
			String sportName) {
		if (tournamentName.equalsIgnoreCase(sportName)) {
			return true;
		}
		return false;
	}

	/**
	 * Sport in tournament name.
	 * 
	 * @param tournamentName
	 *            the tournament name
	 * @param sportName
	 *            the sport name
	 * @return true, if successful
	 */
	private static boolean sportInTournamentName(String tournamentName,
			String sportName) {
		if (tournamentName.contains(sportName)) {
			return true;
		}
		return false;
	}
}
