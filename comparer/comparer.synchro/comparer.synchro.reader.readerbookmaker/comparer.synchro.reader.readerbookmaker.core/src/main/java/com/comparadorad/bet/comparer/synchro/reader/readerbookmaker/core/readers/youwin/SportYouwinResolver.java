/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.youwin;

import com.comparadorad.bet.comparer.model.bet.bean.IBetEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport.CfgSportId;

/**
 * The Enum SportYouwinResolver.
 */
enum SportYouwinResolver {

	/** The FOOTBALL. */
	FOOTBALL(CfgSportId.FOOTBALL.nameId(), "21.1"),
	/** The TENNIS. */
	TENNIS(CfgSportId.TENNIS.nameId(), "31.1"),
	/** The BASKETBALL. */
	BASKETBALL(CfgSportId.BASKETBALL.nameId(), "28.1"),
	/** The BASEBALL. */
	BASEBALL(CfgSportId.BASEBALL.nameId(), "27.1"),
	/** The IC e_ hockey. */
	ICE_HOCKEY(CfgSportId.ICE_HOCKEY.nameId(), "3159.1"),
	/** The HANDBALL. */
	HANDBALL(CfgSportId.HANDBALL.nameId(), "43.1"),
	/** The CYCLING. */
	CYCLING(CfgSportId.CYCLING.nameId(), "50.1"),
	/** The AMERICA n_ football. */
	AMERICAN_FOOTBALL(CfgSportId.AMERICAN_FOOTBALL.nameId(), "24.1");

	/** The events. */
	private final String[] events;

	/**
	 * Instantiates a new bet event bookmaker.
	 * 
	 * @param pValue
	 *            the value
	 */
	SportYouwinResolver(String... pValue) {
		this.events = pValue;
	}

	/**
	 * Gets the events.
	 * 
	 * @return the events
	 */
	public String[] getEvents() {
		return events;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public String getId() {
		return events[0];
	}

	/**
	 * Checks if is ice hockey.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the boolean
	 */
	public static Boolean isIceHockey(String sportId) {
		String[] events = SportYouwinResolver.ICE_HOCKEY.getEvents();
		for (int i = 1; i < events.length; i++) {
			if (events[i].equals(sportId)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if is basketball.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the boolean
	 */
	public static Boolean isBasketball(String sportId) {
		String[] events = SportYouwinResolver.BASKETBALL.getEvents();
		for (int i = 1; i < events.length; i++) {
			if (events[i].equals(sportId)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if is american football.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the boolean
	 */
	public static Boolean isAmericanFootball(String sportId) {
		String[] events = SportYouwinResolver.AMERICAN_FOOTBALL.getEvents();
		for (int i = 1; i < events.length; i++) {
			if (events[i].equals(sportId)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if is baseball.
	 * 
	 * @param sportId
	 *            the sport id
	 * @return the boolean
	 */
	public static Boolean isBaseball(String sportId) {
		String[] events = SportYouwinResolver.BASEBALL.getEvents();
		for (int i = 1; i < events.length; i++) {
			if (events[i].equals(sportId)) {
				return true;
			}
		}
		return false;

	}
}
