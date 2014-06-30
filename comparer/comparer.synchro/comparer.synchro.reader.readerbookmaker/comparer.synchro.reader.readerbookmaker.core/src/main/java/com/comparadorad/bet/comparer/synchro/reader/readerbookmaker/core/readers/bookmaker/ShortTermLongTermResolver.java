/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bookmaker;

/**
 * The Class ShortTermLongTermResolver.
 */
class ShortTermLongTermResolver {

	/** The Constant BLACK_LONG_TERM_ADDL_LEAGUE_DESC. */
	private static final String[] BLACK_LONG_TERM_ADDL_LEAGUE_DESC = { "GROUP" };

	/** The Constant LONG_TERM_LEAGUE_DESC. */
	private static final String[] LONG_TERM_LEAGUE_DESC = { "FUTURES" };

	/** The Constant WHITE_LONG_TERM_ADDL_LEAGUE_DESC. */
	private static final String[] WHITE_LONG_TERM_ADDL_LEAGUE_DESC = {
			"WINNER", "ODDS TO WIN", "TO WIN" };

	/**
	 * Addl league desc indicates future event.
	 * 
	 * @param addlLeagueDesc
	 *            the addl league desc
	 * @return true, if successful
	 */
	private static boolean addlLeagueDescIndicatesLongTermEvent(
			String addlLeagueDesc) {
		for (String whiteDesc : WHITE_LONG_TERM_ADDL_LEAGUE_DESC) {
			if (addlLeagueDesc.contains(whiteDesc)) {
				for (String blackDesc : BLACK_LONG_TERM_ADDL_LEAGUE_DESC) {
					if (!addlLeagueDesc.contains(blackDesc)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Contains multiple bets.
	 * 
	 * @param xmlBetSize
	 *            the xml bet size
	 * @return true, if successful
	 */
	private static boolean containsMultipleBets(int xmlBetSize) {
		if (xmlBetSize > 1) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if is long term event.
	 * 
	 * @param xmlBetSize
	 *            the xml bet size
	 * @param leagueDesc
	 *            the league desc
	 * @param addlLeagueDesc
	 *            the addl league desc
	 * @return true, if is long term event
	 */
	public static boolean isLongTermEvent(int xmlBetSize, String leagueDesc,
			String addlLeagueDesc) {
		if (containsMultipleBets(xmlBetSize)
				&& leagueDescIndicatesLongTermEvent(leagueDesc)
				&& addlLeagueDescIndicatesLongTermEvent(addlLeagueDesc)) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if is short term event.
	 * 
	 * @param xmlBetSize
	 *            the xml bet size
	 * @return true, if is short term event
	 */
	public static boolean isShortTermEvent(int xmlBetSize) {
		if (xmlBetSize == 1) {
			return true;
		}
		return false;
	}

	/**
	 * League desc indicates future event.
	 * 
	 * @param leagueDesc
	 *            the league desc
	 * @return true, if successful
	 */
	private static boolean leagueDescIndicatesLongTermEvent(String leagueDesc) {
		for (String desc : LONG_TERM_LEAGUE_DESC) {
			if (leagueDesc.contains(desc)) {
				return true;
			}
		}
		return false;
	}

}
