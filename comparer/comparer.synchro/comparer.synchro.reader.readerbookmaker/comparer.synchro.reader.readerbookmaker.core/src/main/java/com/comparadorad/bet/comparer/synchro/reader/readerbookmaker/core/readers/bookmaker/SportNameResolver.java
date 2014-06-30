/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.bookmaker;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The Class SportNameResolver.
 */
class SportNameResolver {

	/** The Constant AMERICAN_FOOTBALL_PREFIX. */
	private static final String AMERICAN_FOOTBALL_PREFIX = "AMERICAN ";

	/** The Constant AMERICAN_FOOTBALL_XML_DESC. */
	private static final String AMERICAN_FOOTBALL_XML_DESC = "FOOTBALL";

	/** The Constant BASEBALL. */
	private static final String BASEBALL_XML_DESC = "BASEBALL";

	/** The Constant ICE_HOCKEY_PREFIX. */
	private static final String ICE_HOCKEY_PREFIX = "ICE ";

	/** The Constant ICE_HOCKEY_XML_DESC. */
	private static final String ICE_HOCKEY_XML_DESC = "HOCKEY";

	/** The Constant BASKETBALL_XML_DESC. */
	private static final String BASKETBALL_XML_DESC = "BASKETBALL";

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(SportNameResolver.class);

	/**
	 * Checks if is american football.
	 * 
	 * @param sportName
	 *            the sport name
	 * @return true, if is american football
	 */
	public static boolean isAmericanFootball(String sportName) {
		// Modificacion para deteccion de deporte con partido resuelto
		// if (sportName.equalsIgnoreCase(AMERICAN_FOOTBALL_XML_DESC))
		if (sportName.contains(AMERICAN_FOOTBALL_XML_DESC)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Checks if is baseball.
	 * 
	 * @param sportName
	 *            the sport name
	 * @return true, if is baseball
	 */
	public static boolean isBaseball(String sportName) {
		if (sportName.equalsIgnoreCase(BASEBALL_XML_DESC)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if is ice hockey.
	 * 
	 * @param sportName
	 *            the sport name
	 * @return true, if is ice hockey
	 */
	public static boolean isIceHockey(String sportName) {
		if (sportName.equalsIgnoreCase(ICE_HOCKEY_PREFIX + ICE_HOCKEY_XML_DESC)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Checks if is ice basketball.
	 * 
	 * @param sportName
	 *            the sport name
	 * @return true, if is ice basketball
	 */
	public static boolean isBasketball(final String sportName) {
		if (sportName.equalsIgnoreCase(BASKETBALL_XML_DESC)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Resolve sport.
	 * 
	 * @param idLeague
	 *            the id league
	 * @param leaguesBySport
	 *            the leagues by sport
	 * @return the string
	 */
	public static String resolveSport(int idLeague,
			Map<String, String> leaguesBySport) {
		String origSportName = leaguesBySport.get(String.valueOf(idLeague));
		String sportName = origSportName;
		if (sportName != null) {
			if (isAmericanFootball(sportName)) {
				sportName = new StringBuffer(AMERICAN_FOOTBALL_PREFIX).append(
						sportName).toString();
			} else if (sportName.equalsIgnoreCase( ICE_HOCKEY_XML_DESC)) {
				sportName = new StringBuffer(ICE_HOCKEY_PREFIX).append(
						sportName).toString();
			}
			if (LOG.isDebugEnabled()) {
				LOG.debug(new StringBuffer()
						.append("Resolvemos nombre de deporte. En el xml viene como: ")
						.append(origSportName).append(". Nosotros guardamos: ")
						.append(sportName));
			}
		}
		return sportName;
	}

	/**
	 * Return true if a sport have overtime
	 * 
	 * @param sportName
	 * @return
	 */
	public static Boolean isOvertimeSport(final String sportName) {

		return isAmericanFootball(sportName) || isIceHockey(sportName)
				|| isBasketball(sportName) || isBaseball(sportName);
	}

}
